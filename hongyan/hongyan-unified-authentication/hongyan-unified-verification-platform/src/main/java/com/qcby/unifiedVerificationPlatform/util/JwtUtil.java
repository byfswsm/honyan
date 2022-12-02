package com.qcby.unifiedVerificationPlatform.util;


import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.qcby.unifiedVerificationPlatform.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JwtUtil {

    private static volatile Set<String> blackListSet;

    public static Set<String> getBlackListSet() {
        if (blackListSet == null) {
            synchronized (JwtUtil.class) {
                if (blackListSet == null) {
                    blackListSet = new HashSet<>();
                }
            }
        }
        return blackListSet;
    }

    private JwtUtil() {
    }

    //过期时间 30min
    @Value("${jwt.expireTime}")
    private int expireTime;
    //私钥
    @Value("${jwt.tokenSecret}")
    private String tokenSecret;


    // 普通常量
    private static final String CLAIM_USER = "claimUser";

    /**
     * JWT.decode(token).getExpiresAt()
     * <p>
     * 1、退出登录或者 检测到某个token是非法的  将改token添加到  【blacklistMap】中
     * <p>
     * 2、 每次验证token是否有效之前  先验证  黑名单中是否已有 => false
     * <p>
     * 3、 超时时间=>  有定时任务定时检查  超时的token删除 => 防止长期运行占用内存越来越多
     */

    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字
     * 加密密钥：这个人的id加上一串字符串
     *
     * @param user
     * @return
     */
    public String createToken(User user) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, expireTime);
        Date expiresDate = nowTime.getTime();

        String userJson = JSON.toJSONString(user);
        return JWT.create()
                .withAudience(user.getId() + "")   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
//                .withClaim(USER_NAME, userName)    //载荷，随便写几个都可以 => 附带信息：比如我们的用户信息
                // 存储用户信息   =>   json转化 ，序列化
                .withClaim(CLAIM_USER, userJson)
                .sign(Algorithm.HMAC256(user.getId() + tokenSecret));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     *
     * @param token
     * @param secret
     * @return
     */
    public boolean verifyToken(String token, String secret) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret + tokenSecret)).build();
            verifier.verify(token);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            //效验失败
            //自定义的一个异常
            return false;
        }
        return true;
    }

    /**
     * 获取签发对象
     */
    public String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (Exception j) {
            log.error(j.getMessage(), j);
            return null;
        }
        return audience;
    }

    /**
     * 获取载荷中用户信息
     *
     * @param token
     * @return
     */
    public User getUser(String token) {
        User user = null;
        try {
            String userJson = JWT.decode(token).getClaim(CLAIM_USER).asString();
            user = JSON.parseObject(userJson, User.class);
        } catch (JWTDecodeException j) {
            log.error(j.getMessage(), j);
            return null;
        }
        return user;
    }


    public void delayDeleteBlackListSet(String token) {
        log.info("2分钟后删除该token  " + token);

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {
            try {
                blackListSet.remove(token);
                log.info("已删除该token  " + token);
            } catch (Exception e) {
                log.error("Got an exception!");
            }
        }, 30, TimeUnit.MINUTES);

        scheduledExecutorService.shutdown();
    }
}

package com.qcby.hongyanfriendcircle.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.qcby.hongyanfriendcircle.entity.User;

import java.util.Calendar;

/**
 * @ProjectName: xmfs-3_project
 * @Package: com.qcby.xmfs3_project.util
 * @ClassName: JwtUtil
 * @Author: zxh
 * @Description: Jwt工具类
 * @Date: 2021/11/29 21:01
 * @Version: 1.0
 */
public class JwtUtil {
    //过期时间
    private static final int expireTime = 1;
    //私钥
    private static final String tokenSecret = "bwfw";

    private static final String CLAIM_USER = "claimUser";

    public static String createToken(User user) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, expireTime);
        String userJson = JSON.toJSONString(user);
        String token = JWT.create()
                .withAudience(user.getId() + "")
                .withClaim("username", user.getUsername())
                .withExpiresAt(instance.getTime())
                .withClaim(CLAIM_USER,userJson)
                .sign(Algorithm.HMAC256(tokenSecret));
        return token;
    }

    /**
     * 验证token,并且如果token不合法就报错
     * @param token
     */
    public static DecodedJWT getDecodedJWT(String token){
        return JWT.require(Algorithm.HMAC256(tokenSecret)).build().verify(token);
    }

    /**
     * 获取token中的用户的用户名
     * @param token
     * @return
     */
    public static String getUsername(String token){
        DecodedJWT decodedJWT = getDecodedJWT(token);
        String username = decodedJWT.getClaim("username").asString();
        return username;
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            return null;
        }
        return audience;
    }

    /**
     * 获取载荷中用户信息
     * @param token
     * @return
     */
    public static User getUser(String token) {
        User user = null;
        try {
            String userJson = JWT.decode(token).getClaim(CLAIM_USER).asString();
            user = JSON.parseObject(userJson, User.class);
        } catch (JWTDecodeException j) {
            return null;
        }
        return user;
    }

}

package com.qcby.unifiedVerificationPlatform.util;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
public class CodeUtil {


    private static LineCaptcha lineCaptcha;

    /**
     * 1.给Test的实例分配内存 2.初始化Test的构造器 3.将instance对象指向分配的内存空间（注意 此时instance就不为空）
     *
     */
    private static volatile Map<String, String> loginCodeMap;

    //单例模式,双检测锁
    public static Map<String, String> getLoginCodeMap() {
        if (loginCodeMap == null) {
            synchronized (CodeUtil.class) {
                if (loginCodeMap == null) {
                    loginCodeMap = new HashMap<>();
                }
            }
        }
        return loginCodeMap;
    }

    private CodeUtil() {

    }

    /**
     * 生成验证码
     *
     * @param httpServletRequest
     * @return
     */
    public static String doCode(HttpServletRequest httpServletRequest) {
        //定义图形验证码的长和宽
        lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        String code = lineCaptcha.getCode();
        //放入session中============>改成一个滑动验证
        httpServletRequest.getServletContext().setAttribute(code, "1");
        //输出code
        Console.log("code:  " + code);

        //延迟删除code
        delayDeleteCode(code, httpServletRequest);

        /*  //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("C:\\Users\\Administrator\\Desktop\\SMS\\line.png");
        */
        BASE64Encoder encoder = new BASE64Encoder();
        String imagestr = "data:image/png;base64," + encoder.encode(lineCaptcha.getImageBytes()).replaceAll("\r|\n", "");
        return imagestr;
    }

    /**
     * 检验普通验证码
     *
     * @param webcode
     * @param httpServletRequest
     * @return
     */
    public static boolean checkCode(String webcode, HttpServletRequest httpServletRequest) {
        String s = (String) httpServletRequest.getServletContext().getAttribute(webcode);

        log.info("httpServletRequest=====>s: " + s);
        if (StringUtils.isEmpty(webcode) || webcode == null) {
            return false;
        }
        //验证图形验证码的有效性，返回boolean值
        boolean f = "1".equalsIgnoreCase(s);

        //如果是,则删除该条数据
        if (f) {
            httpServletRequest.getServletContext().removeAttribute("code");
            log.info("已删除该code  " + webcode + "  的session");
        }
        log.info("验证码输入是否正确:  " + f);
        return f;
    }

    /**
     * 检验手机或者邮箱验证码
     *
     * @return
     */
    public static boolean checkCode(String getPhoneEmail, String webCode) {
        String code = getLoginCodeMap().get(getPhoneEmail);
        log.info("getPhoneEmail: " + getPhoneEmail + "--------webCode: " + webCode + "---------code: " + code);
        if (StringUtils.isEmpty(webCode) || !RegexUtil.isSixNumber(webCode) || StringUtils.isEmpty(code)) {
            return false;
        }
        boolean f = webCode.equalsIgnoreCase(code);

        //如果是,则删除该条数据
        if (f) {
            loginCodeMap.remove(getPhoneEmail);
            log.info("已删除该用户  " + getPhoneEmail + "  的验证码");
        }
        return f;
    }


    /**
     * 延迟删除普通验证码/session
     *
     * @param code
     */
    public static void delayDeleteCode(String code, HttpServletRequest httpServletRequest) {
        log.info("2分钟后删除该code  " + code + "  的session");

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {
            try {
                httpServletRequest.getServletContext().removeAttribute("code");
                log.info("已删除该code  " + code + "  的session");
            } catch (Exception e) {
                log.error("Got an exception!");
            }
        }, 2, TimeUnit.MINUTES);
        scheduledExecutorService.shutdown();
    }

    /**
     * 延迟删除用户验证码(包括email和phone)
     *
     * @param getPhoneEmail
     */

    public static void delayDeleteUserCode(String getPhoneEmail) {
        log.info("2分钟后删除该用户  " + getPhoneEmail + "  的验证码");

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {
            try {
                loginCodeMap.remove(getPhoneEmail);
                log.info("已删除该用户  " + getPhoneEmail + "  的验证码");
            } catch (Exception e) {
                log.error("Got an exception!");
            }
        }, 2, TimeUnit.MINUTES);
        scheduledExecutorService.shutdown();
    }

    /**
     * 获得随机 6 位验证码
     *
     * @return
     */
    public static String getCode() {
        String code = "";
        Random rd = new Random();
        for (int i = 0; i < 6; i++) {
            code += rd.nextInt(10) + "";
        }

        log.info("mailCode:  " + code);
        return code;
    }
}

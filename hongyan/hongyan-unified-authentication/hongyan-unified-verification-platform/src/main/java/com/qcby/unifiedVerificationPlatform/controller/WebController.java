package com.qcby.unifiedVerificationPlatform.controller;

import com.qcby.unifiedVerificationPlatform.entity.User;
import com.qcby.unifiedVerificationPlatform.service.LoginService;
import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.login.SsoWebLoginHelper;
import com.xxl.sso.core.store.SsoLoginStore;
import com.xxl.sso.core.store.SsoSessionIdHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * sso server (for web)
 *
 * @author xuxueli 2017-08-01 21:39:47
 */
@Controller
public class WebController {
    @Resource
    private LoginService loginService;


    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {

        // login check
        XxlSsoUser xxlUser = SsoWebLoginHelper.loginCheck(request, response);

        if (xxlUser == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("xxlUser", xxlUser);
            return "index";
        }
    }



    /**
     * Login page
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(Conf.SSO_LOGIN)
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {

        // login check
        XxlSsoUser xxlUser = SsoWebLoginHelper.loginCheck(request, response);

        if (xxlUser != null) {

            // success redirect
            String redirectUrl = request.getParameter(Conf.REDIRECT_URL);
            if (redirectUrl != null && redirectUrl.trim().length() > 0) {

                String sessionId = SsoWebLoginHelper.getSessionIdByCookie(request);
                String redirectUrlFinal = redirectUrl + "?" + Conf.SSO_SESSIONID + "=" + sessionId;
                ;

                return "redirect:" + redirectUrlFinal;
            } else {
                return "redirect:/";
            }
        }

        model.addAttribute("errorMsg", request.getParameter("errorMsg"));
        model.addAttribute(Conf.REDIRECT_URL, request.getParameter(Conf.REDIRECT_URL));
        return "login";
    }

    /**
     *  doLogin
     *  前台login表单传送
     * @param request
     * @param response
     * @param redirectAttributes
     * @param username
     * @param password
     * @param ifRemember
     * @return
     */
    @RequestMapping("doLogin")
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response,
                          RedirectAttributes redirectAttributes,
                          String username,
                          String password,
                          String ifRemember) {

        //mysql数据库的一个查询
        User user = User.builder().username(username).password(password).build();
        User user1 = loginService.usernameLogin(user);
        if (user1 != null) {
            //是否记住密码
            boolean ifRem = (ifRemember != null && "on".equals(ifRemember)) ? true : false;

            XxlSsoUser xxlUser = new XxlSsoUser();
            xxlUser.setUserid(String.valueOf(user1.getId()));
            xxlUser.setUsername(user1.getUsername());

            xxlUser.setVersion(UUID.randomUUID().toString().replaceAll("-", ""));
            xxlUser.setExpireMinite(SsoLoginStore.getRedisExpireMinite());
            xxlUser.setExpireFreshTime(System.currentTimeMillis());

            //产生session和storeKey
            String sessionId = SsoSessionIdHelper.makeSessionId(xxlUser);

            //登录,存储storeKey
            SsoWebLoginHelper.login(response, sessionId, xxlUser, ifRem);

            //返回重定向sessionId
            String redirectUrl = request.getParameter(Conf.REDIRECT_URL);
            if (redirectUrl!=null && redirectUrl.trim().length()>0) {
                String redirectUrlFinal = redirectUrl + "?" + Conf.SSO_SESSIONID + "=" + sessionId;
                return "redirect:" + redirectUrlFinal;
            }
        }
        return "redirect:/";
    }

    /**
     * Logout
     *
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(Conf.SSO_LOGOUT)
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

        // logout
        SsoWebLoginHelper.logout(request, response);

        redirectAttributes.addAttribute(Conf.REDIRECT_URL, request.getParameter(Conf.REDIRECT_URL));
        return "redirect:/login";
    }



}

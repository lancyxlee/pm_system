package edu.cqut.pm_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.LoginService;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 登录界面Controller层
 *
 * @author llx
 * @date 2019/09/28
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String loginName, String password, HttpSession session) {
        User result = loginService.login(loginName, password);
        if (result != null) {
            session.setAttribute("loginId", result.getUid());
            session.setAttribute("loginName", loginName);
            session.setAttribute("status", result.getRole());
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.POST)
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().removeAttribute("loginId");//清空session信息
            request.getSession().removeAttribute("loginName");//清空session信息
            request.getSession().removeAttribute("status");//清空session信息
            request.getSession().invalidate();//清除 session 中的所有信息
            return JacksonUtil.objectToJson("SUCCESS");
        } catch (Exception e) {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getPermission", method = RequestMethod.GET)
    public String getPermission(HttpSession session) {
        return JacksonUtil.objectToJson(session.getAttribute("status"));
    }

    @RequestMapping(value = "getUsername", method = RequestMethod.GET)
    public String getUsername(HttpSession session) {
        return JacksonUtil.objectToJson(session.getAttribute("loginName"));
    }
}

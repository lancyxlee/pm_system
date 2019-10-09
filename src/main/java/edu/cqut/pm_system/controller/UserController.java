package edu.cqut.pm_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.UserService;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 登录界面Controller层
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public String updatePassword(HttpSession session ,String oldPwd, String newPwd) {
        String id = (String) session.getAttribute("loginId");
        String result = userService.updatePassword(id,oldPwd,newPwd);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else if ("INCORRECT".equals(result)){
            return JacksonUtil.objectToJson("INCORRECT");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
    public String getUserInfo(HttpSession session) {
        String uid = (String) session.getAttribute("loginId");
        System.out.println(uid);
        Map<String, Object> result = userService.getUserInfo(uid);
        if (result != null) {
            System.out.println(result);
            return JacksonUtil.objectToJson(result);
        } else {

            return "FAIL";
        }
    }

}

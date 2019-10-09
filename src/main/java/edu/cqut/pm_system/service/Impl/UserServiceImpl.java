package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import edu.cqut.pm_system.dao.UserDao;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.UserService;
import edu.cqut.pm_system.util.MD5Util;

/**
 * 用户管理界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String updatePassword(String uid,String oldPwd,String newPwd) {
        try {
            User user = userDao.getUserFromId(uid);

            if (user.getPassword().equals(MD5Util.getMD5_32(oldPwd))){
                try {
                    userDao.updatePassword(uid,MD5Util.getMD5_32(newPwd));
                    return "SUCCESS";
                } catch (Exception e) {
                    System.out.println(e);
                    return "FAIL";
                }
            } else {
                return "INCORRECT";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public Map<String, Object> getUserInfo(String uid) {
        return userDao.getUserInfo(uid);
    }
}

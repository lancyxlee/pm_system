package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cqut.pm_system.dao.LoginDao;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.LoginService;
import edu.cqut.pm_system.util.MD5Util;

/**
 * 登录界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    /**
     * @param loginName
     * @param password
     * @return e10adc3949ba59abbe56e057f20f883e
     */
    @Override
    public User login(String loginName, String password) {
        User user = loginDao.login(loginName);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(MD5Util.getMD5_32(password))) {
            return user;
        }
        return null;
    }
}

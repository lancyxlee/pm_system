package edu.cqut.pm_system.service;

import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/09/28
 */

public interface LoginService {

    public User login(String loginId, String password);
}

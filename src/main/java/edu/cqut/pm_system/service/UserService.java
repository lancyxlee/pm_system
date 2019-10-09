package edu.cqut.pm_system.service;

import java.util.List;
import java.util.Map;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface UserService {
    String updatePassword(String uid,String oldPwd,String newPwd);
    Map<String, Object> getUserInfo(String uid);
}

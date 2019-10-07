package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.LoginDao;
import edu.cqut.pm_system.dao.PersonnelDao;
import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.LoginService;
import edu.cqut.pm_system.service.PersonnelService;
import edu.cqut.pm_system.util.MD5Util;

/**
 * 员工信息界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    PersonnelDao personnelDao;

    @Override
    public List<Employee> getAllEmployee() {
        return personnelDao.getAllEmployee();
    }

    @Override
    public List<Dept> getAllDept() {
        return personnelDao.getAllDept();
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            personnelDao.addEmployee(employee);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
}

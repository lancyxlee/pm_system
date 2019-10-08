package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.DeptSalaryDao;
import edu.cqut.pm_system.dao.LoginDao;
import edu.cqut.pm_system.dao.PersonnelDao;
import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.LoginService;
import edu.cqut.pm_system.service.PersonnelService;
import edu.cqut.pm_system.util.EntityIDFactory;
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
    @Autowired
    DeptSalaryDao deptSalaryDao;

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

    @Override
    public String addUser(User user) {
        try {
            personnelDao.addUser(user);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String deleteEmployeeFromUempid(String uempid) {
        try {
            personnelDao.deleteEmployeeFromUempid(uempid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String deleteUserFromUid(String uid) {
        try {
            personnelDao.deleteUserFromUid(uid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<Employee> searchEmployee(String uempid, String deptname) {
        return personnelDao.searchEmployee(uempid, deptname);
    }

    @Override
    public Employee getEmployeeFromId(String uempid) {
        return personnelDao.getEmployeeFromId(uempid);
    }

    @Override
    public String updateEmployee(Employee employee) {
        try {
            personnelDao.updateEmployee(employee);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<Dept> searchDept(String deptnum, String deptname) {
        return personnelDao.searchDept(deptnum, deptname);
    }

    @Override
    public String addDept(Dept dept) {
        //部门经理工资初添加
        DeptSalary deptSalary = new DeptSalary();
        deptSalary.setSalarysetid(EntityIDFactory.createId());
        deptSalary.setDeptnum(dept.getDid());
        deptSalary.setRole(1);
        //普通员工薪资初添加
        DeptSalary deptSalary1 = new DeptSalary();
        deptSalary1.setSalarysetid(EntityIDFactory.createId());
        deptSalary1.setDeptnum(dept.getDid());
        deptSalary1.setRole(2);
        try {
            personnelDao.addDept(dept);
            deptSalaryDao.addDeptSalary(deptSalary);
            deptSalaryDao.addDeptSalary(deptSalary1);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String deleteDeptFromId(String did) {
        try {
            personnelDao.deleteDeptFromId(did);
            deptSalaryDao.deleteDeptFromId(did);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String updateDept(Dept dept) {
        try {
            personnelDao.updateDept(dept);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public Dept getDeptFromId(String did) {
        return personnelDao.getDeptFromId(did);
    }
}

package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.DeptSalaryDao;
import edu.cqut.pm_system.dao.PersonnelDao;
import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.DeptSalaryService;
import edu.cqut.pm_system.service.PersonnelService;
import edu.cqut.pm_system.util.EntityIDFactory;

/**
 * 员工信息界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class DeptSalaryServiceImpl implements DeptSalaryService {

    @Autowired
    DeptSalaryDao deptSalaryDao;


    @Override
    public List<DeptSalary> getAllDeptSalary() {
        return deptSalaryDao.getAllDeptSalary();
    }

    @Override
    public String updateBaseSalary(Double basesalary, String salarysetid) {
        try {
            deptSalaryDao.updateBaseSalary(basesalary, salarysetid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<DeptSalary> searchDeptSalary(Integer role, String deptname) {
        return deptSalaryDao.searchDeptSalary(role, deptname);
    }


}

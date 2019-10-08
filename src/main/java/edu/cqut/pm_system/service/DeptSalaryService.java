package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface DeptSalaryService {

    List<DeptSalary> getAllDeptSalary();
    String updateBaseSalary(Double basesalary, String salarysetid);
    List<DeptSalary> searchDeptSalary(Integer role, String deptname);
}

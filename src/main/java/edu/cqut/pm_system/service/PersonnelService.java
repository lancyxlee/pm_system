package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface PersonnelService {

    List<Employee> getAllEmployee();
    List<Dept> getAllDept();
    String addEmployee(Employee employee);
}

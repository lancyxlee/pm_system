package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface PersonnelService {

    List<Employee> getAllEmployee();
    List<Dept> getAllDept();
    String addEmployee(Employee employee);
    String addUser(User user);
    String deleteEmployeeFromUempid(String uempid);
    String deleteUserFromUid(String uid);
    List<Employee> searchEmployee(String uempid, String deptname);
    Employee getEmployeeFromId(String uempid);
    String updateEmployee(Employee employee);
}

package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface PersonnelDao {
    List<Employee> getAllEmployee();
    List<Dept> getAllDept();
    void addEmployee(Employee employee);
    void addUser(User user);
    void deleteEmployeeFromUempid(String uempid);
    void deleteUserFromUid(String uid);
    List<Employee> searchEmployee(String uempid, String deptname);
    Employee getEmployeeFromId(String uempid);
    void updateEmployee(Employee employee);
    List<Dept> searchDept(String deptnum, String deptname);
    void addDept(Dept dept);
    void deleteDeptFromId(String did);
    void updateDept(Dept dept);
    Dept getDeptFromId(String did);
}

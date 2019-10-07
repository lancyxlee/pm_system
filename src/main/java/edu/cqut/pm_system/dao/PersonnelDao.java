package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface PersonnelDao {
    List<Employee> getAllEmployee();
    List<Dept> getAllDept();
    void addEmployee(Employee employee);
}

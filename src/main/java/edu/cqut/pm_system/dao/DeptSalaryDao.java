package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface DeptSalaryDao {
    List<DeptSalary> getAllDeptSalary();
    void updateBaseSalary(Double basesalary, String salarysetid);
    List<DeptSalary> searchDeptSalary(Integer role, String deptname);
    void addDeptSalary(DeptSalary deptSalary);
    void deleteDeptFromId(String deptnum);

    List<Map<String, Object>> getAllEmpSalary();
    List<Map<String, Object>> searchEmpSalary(String uempid, String uempname, Integer year, Integer month);
}

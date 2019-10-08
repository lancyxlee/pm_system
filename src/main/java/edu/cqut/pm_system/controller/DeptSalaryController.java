package edu.cqut.pm_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.entity.User;
import edu.cqut.pm_system.service.DeptSalaryService;
import edu.cqut.pm_system.service.PersonnelService;
import edu.cqut.pm_system.util.EntityIDFactory;
import edu.cqut.pm_system.util.JacksonUtil;
import edu.cqut.pm_system.util.MD5Util;

/**
 * 登录界面Controller层
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/deptSalary")
public class DeptSalaryController {
    @Autowired
    DeptSalaryService deptSalaryService;

    @RequestMapping(value = "getAllDeptSalary", method = RequestMethod.GET)
    public String getAllDeptSalary() {
        List<DeptSalary> result = deptSalaryService.getAllDeptSalary();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "updateBaseSalary", method = RequestMethod.POST)
    public String updateEmployee(Double basesalary, String salarysetid) {
        String result = deptSalaryService.updateBaseSalary(basesalary, salarysetid);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "searchDeptSalary", method = RequestMethod.GET)
    public String searchDeptSalary(String role, String deptname) {
        List<DeptSalary> result;
        if ("".equals(role)) result = deptSalaryService.searchDeptSalary(null, deptname);
        else if ("部门经理".contains(role)) result = deptSalaryService.searchDeptSalary(1, deptname);
        else if ("普通员工".contains(role)) result =  deptSalaryService.searchDeptSalary(2, deptname);
        else result = deptSalaryService.searchDeptSalary(null, deptname);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }
}

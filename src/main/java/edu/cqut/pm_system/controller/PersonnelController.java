package edu.cqut.pm_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cqut.pm_system.entity.Dept;
import edu.cqut.pm_system.entity.Employee;
import edu.cqut.pm_system.service.PersonnelService;
import edu.cqut.pm_system.util.EntityIDFactory;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 登录界面Controller层
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/employee")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @RequestMapping(value = "getAllEmployee", method = RequestMethod.GET)
    public String getAllEmployee() {
        List<Employee> result = personnelService.getAllEmployee();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "getAllDept", method = RequestMethod.GET)
    public String getAllDept() {
        List<Dept> result = personnelService.getAllDept();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(String uempname, Integer age, Integer sex, String idnum, String telnum, String startdate, String deptnum, HttpSession session) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(format.parse(startdate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee();
        employee.setUid((String) session.getAttribute("loginId"));
        employee.setUempid(EntityIDFactory.createId());
        employee.setUempname(uempname);
        employee.setAge(age);
        employee.setSex(sex);
        employee.setIdnum(idnum);
        employee.setTelnum(telnum);
        employee.setStartdate(timestamp);
        employee.setDeptnum(deptnum);
        String result = personnelService.addEmployee(employee);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }
}

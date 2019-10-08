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
import edu.cqut.pm_system.entity.User;
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
    public String addEmployee(String uempname, Integer age, Integer sex, String idnum, String telnum, String startdate, String deptnum, String username, String password, Integer role) {
        String id = EntityIDFactory.createId();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(format.parse(startdate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUid(id);
        user.setUsername(username);
        user.setPassword(MD5Util.getMD5_32(password));
        user.setRole(role);
        Employee employee = new Employee();
        employee.setUid(id);
        employee.setUempid(id);
        employee.setUempname(uempname);
        employee.setAge(age);
        employee.setSex(sex);
        employee.setIdnum(idnum);
        employee.setTelnum(telnum);
        employee.setStartdate(timestamp);
        employee.setDeptnum(deptnum);
        String result = personnelService.addEmployee(employee);
        String result1 = personnelService.addUser(user);
        if ("SUCCESS".equals(result) && "SUCCESS".equals(result1)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "deleteEmployee", method = RequestMethod.DELETE)
    public String deleteEmployeeFromUempid(String uempid) {
        String result = personnelService.deleteEmployeeFromUempid(uempid);
        String result1 = personnelService.deleteUserFromUid(uempid);
        if ("SUCCESS".equals(result) && "SUCCESS".equals(result1)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "searchEmployee", method = RequestMethod.GET)
    public String searchEmployee(String uempid, String deptname) {
        List<Employee> result = personnelService.searchEmployee(uempid, deptname);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "getEmployeeFromId", method = RequestMethod.GET)
    public String getEmployeeFromId(String uempid) {
        Employee result = personnelService.getEmployeeFromId(uempid);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(String uempname, Integer age, Integer sex, String idnum, String telnum, String startdate, String deptnum, String uempid) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(format.parse(startdate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee();
        employee.setUid(uempid);
        employee.setUempid(uempid);
        employee.setUempname(uempname);
        employee.setAge(age);
        employee.setSex(sex);
        employee.setIdnum(idnum);
        employee.setTelnum(telnum);
        employee.setStartdate(timestamp);
        employee.setDeptnum(deptnum);
        String result = personnelService.updateEmployee(employee);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "searchDept", method = RequestMethod.GET)
    public String searchDept(String deptnum, String deptname) {
        List<Dept> result = personnelService.searchDept(deptnum, deptname);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "addDept", method = RequestMethod.POST)
    public String addDept(String deptnum, String deptname, String tel) {
        String id = EntityIDFactory.createId();
        Dept dept = new Dept(id, deptname, deptnum, tel);
        String result = personnelService.addDept(dept);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "deleteDeptFromId", method = RequestMethod.DELETE)
    public String deleteDeptFromId(String did) {
        String result = personnelService.deleteDeptFromId(did);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "updateDept", method = RequestMethod.POST)
    public String updateDept(String deptnum, String deptname, String tel, String did) {
        Dept dept = new Dept(did, deptname, deptnum, tel);
        String result = personnelService.updateDept(dept);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getDeptFromId", method = RequestMethod.GET)
    public String getDeptFromId(String did) {
        Dept result = personnelService.getDeptFromId(did);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }
}

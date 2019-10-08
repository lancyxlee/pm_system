package edu.cqut.pm_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.service.AttendanceService;
import edu.cqut.pm_system.service.DeptSalaryService;
import edu.cqut.pm_system.util.EntityIDFactory;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 登录界面Controller层
 *
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "getAllAttendance", method = RequestMethod.GET)
    public String getAllDeptSalary() {
        List<Attendance> result = attendanceService.getAllAttendance();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "addAttendance", method = RequestMethod.POST)
    public String addAttendance(String uempid, String uempname) {
        String id = EntityIDFactory.createId();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        Attendance attendance = new Attendance();
        attendance.setAid(id);
        attendance.setUempid(uempid);
        attendance.setUempname(uempname);
        attendance.setAyear(year);
        attendance.setAmonth(month);
        String result = attendanceService.addAttendance(attendance);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

//    @RequestMapping(value = "updateBaseSalary", method = RequestMethod.POST)
//    public String updateEmployee(Double basesalary, String salarysetid) {
//        String result = deptSalaryService.updateBaseSalary(basesalary, salarysetid);
//        if ("SUCCESS".equals(result)) {
//            return JacksonUtil.objectToJson("SUCCESS");
//        } else {
//            return JacksonUtil.objectToJson("FAIL");
//        }
//    }
//
//    @RequestMapping(value = "searchDeptSalary", method = RequestMethod.GET)
//    public String searchDeptSalary(String role, String deptname) {
//        List<DeptSalary> result;
//        if ("".equals(role)) result = deptSalaryService.searchDeptSalary(null, deptname);
//        else if ("部门经理".contains(role)) result = deptSalaryService.searchDeptSalary(1, deptname);
//        else if ("普通员工".contains(role)) result =  deptSalaryService.searchDeptSalary(2, deptname);
//        else result = deptSalaryService.searchDeptSalary(null, deptname);
//        if (result != null) {
//            return JacksonUtil.objectToJson(result);
//        } else {
//            return "FAIL";
//        }
//    }
}

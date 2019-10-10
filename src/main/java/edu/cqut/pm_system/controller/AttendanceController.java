package edu.cqut.pm_system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.service.AttendanceService;
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
    public String getAllAttendance(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageHelper.startPage(page, limit);
        List<Attendance> attendances = attendanceService.getAllAttendance();
        PageInfo<Attendance> attendancePageInfo = new PageInfo<>(attendances);
        return JacksonUtil.objectToJson(attendances);
    }

    @RequestMapping(value = "addAttendance", method = RequestMethod.POST)
    public String addAttendance(String uempid, String uempname) {
        String id = EntityIDFactory.createId();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        Attendance attendance = new Attendance(id, uempid, uempname, year, month, 0, 0, 0, 0, 0, 0, 0, 0.0);
        String result = attendanceService.addAttendance(attendance);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "updateAttendance", method = RequestMethod.POST)
    public String updateAttendance(Integer ayear, Integer amonth, Integer alatecome, Integer aearlyleave, Integer workovertime, Integer aleave, Integer wovertime, Integer hovertime, String aid) {
        String result = attendanceService.updateAttendance(ayear, amonth, alatecome, aearlyleave, workovertime, aleave, wovertime, hovertime, aid);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "deleteAttendance", method = RequestMethod.DELETE)
    public String deleteAttendance(String aid) {
        String result = attendanceService.deleteAttendance(aid);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "searchAttendance", method = RequestMethod.GET)
    public String searchAttendance(String uempid, String uempname, Integer ayear, Integer amonth) {
        List<Attendance> attendances = attendanceService.searchAttendance(uempid, uempname, ayear, amonth);
        return JacksonUtil.objectToJson(attendances);
    }

    @RequestMapping(value = "getAllAttendanceSet", method = RequestMethod.GET)
    public String getAllAttendanceSet() {
        AttendanceSet result = attendanceService.getAllAttendanceSet();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }
    @RequestMapping(value = "updateAttendanceSet", method = RequestMethod.POST)
    public String updateAttendanceSet(Double setlatecome, Double setearlyleave, Double setworkovertime, Double setwovertime, Double sethovertime,String setid) {
        String result = attendanceService.updateAttendanceSet(setlatecome, setearlyleave, setworkovertime, setwovertime, sethovertime, setid);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

}

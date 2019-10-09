package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.AttendanceDao;
import edu.cqut.pm_system.dao.DeptSalaryDao;
import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.DeptSalary;
import edu.cqut.pm_system.service.AttendanceService;
import edu.cqut.pm_system.service.DeptSalaryService;

/**
 * 员工信息界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceDao attendanceDao;


    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceDao.getAllAttendance();
    }

    @Override
    public String addAttendance(Attendance attendance) {
        try {
            attendanceDao.addAttendance(attendance);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String updateAttendance(Integer ayear, Integer amonth, Integer alatecome, Integer aearlyleave, Integer workovertime, Integer aleave, Integer wovertime, Integer hovertime, String aid) {
        try {
//            dayli = basesalary / 21.75
//            (dayli * setworkovertime * workovertime + dayli * sethovertime * hovertime + dayli * setwovertime * wovertime) - (setlatecome * alatecome + setearlyleave * aearlyleave) - (dayli * aleave)
            AttendanceSet attendanceSet = attendanceDao.getAllAttendanceSet();
            attendanceDao.updateAttendance(ayear, amonth, alatecome, aearlyleave, workovertime, aleave, wovertime, hovertime, aid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String deleteAttendance(String aid) {
        try {
            attendanceDao.deleteAttendance(aid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<Attendance> searchAttendance(String uempid, String uempname, Integer ayear, Integer amonth) {
        return attendanceDao.searchAttendance(uempid, uempname, ayear, amonth);
    }

    @Override
    public AttendanceSet getAllAttendanceSet() {
        return attendanceDao.getAllAttendanceSet();
    }

}

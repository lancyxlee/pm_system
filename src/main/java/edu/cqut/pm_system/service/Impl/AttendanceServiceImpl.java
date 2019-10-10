package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
            Double basesalary = attendanceDao.getEmpBasesalary(aid);
            Double dailyWage = basesalary / 21.75;
            AttendanceSet attendanceSet = attendanceDao.getAllAttendanceSet();
            Double setworkovertime = attendanceSet.getSetworkovertime();
            Double sethovertime = attendanceSet.getSethovertime();
            Double setwovertime = attendanceSet.getSetwovertime();
            Double setlatecome = attendanceSet.getSetlatecome();
            Double setearlyleave = attendanceSet.getSetearlyleave();
            Double bonusres = (dailyWage * setworkovertime * workovertime + dailyWage * sethovertime * hovertime + dailyWage * setwovertime * wovertime) - (setlatecome * alatecome + setearlyleave * aearlyleave) - (dailyWage * aleave);
            //四舍五入保留两位小数
            BigDecimal bigDecimal = new BigDecimal(bonusres).setScale(2, RoundingMode.HALF_UP);
            bonusres = bigDecimal.doubleValue();
            attendanceDao.updateAttendance(ayear, amonth, alatecome, aearlyleave, workovertime, aleave, wovertime, hovertime, bonusres, aid);
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

    @Override
    public Double getEmpBasesalary(String aid) {
        return attendanceDao.getEmpBasesalary(aid);
    }

    @Override
    public String updateAttendanceSet(Double setlatecome, Double setearlyleave, Double setworkovertime, Double setwovertime, Double sethovertime,String setid) {
        try {
            attendanceDao.updateAttendanceSet(setlatecome,setearlyleave,setworkovertime,setwovertime,sethovertime,setid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

}

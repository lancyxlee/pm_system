package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.AttendanceDao;
import edu.cqut.pm_system.dao.DeptSalaryDao;
import edu.cqut.pm_system.entity.Attendance;
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

}

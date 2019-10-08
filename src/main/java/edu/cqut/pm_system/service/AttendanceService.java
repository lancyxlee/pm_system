package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.DeptSalary;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface AttendanceService {

    List<Attendance> getAllAttendance();
    String addAttendance(Attendance attendance);
}

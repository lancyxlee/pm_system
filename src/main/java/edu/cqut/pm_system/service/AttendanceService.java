package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.DeptSalary;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface AttendanceService {

    List<Attendance> getAllAttendance();
    String addAttendance(Attendance attendance);
    String updateAttendance(Integer ayear, Integer amonth, Integer alatecome, Integer aearlyleave, Integer workovertime, Integer aleave, Integer wovertime, Integer hovertime, String aid);
    String deleteAttendance(String aid);
    List<Attendance> searchAttendance(String uempid, String uempname, Integer ayear, Integer amonth);
    AttendanceSet getAllAttendanceSet();
}

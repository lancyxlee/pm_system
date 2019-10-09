package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.DeptSalary;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface AttendanceDao {
    List<Attendance> getAllAttendance();
    void addAttendance(Attendance attendance);
    void updateAttendance(Integer ayear, Integer amonth, Integer alatecome, Integer aearlyleave, Integer workovertime, Integer aleave, Integer wovertime, Integer hovertime, String aid);
    void deleteAttendance(String aid);
    List<Attendance> searchAttendance(String uempid, String uempname, Integer ayear, Integer amonth);
}

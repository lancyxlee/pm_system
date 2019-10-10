package edu.cqut.pm_system.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface PerformanceService {
    List<PerformanceSet> getAllPerformanceSet();
    List<Performance>  getAllPerformance();
    String updatePerformanceSetFromId(String pset_id,Double bonus_set);
}

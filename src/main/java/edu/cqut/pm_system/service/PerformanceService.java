package edu.cqut.pm_system.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.entity.Workplan;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface PerformanceService {
    List<PerformanceSet> getAllPerformanceSet();

    List<Performance> getAllPerformance();

    List<Workplan> getWorkplan(String uid, Integer role);

    String updatePerformanceSetFromId(String pset_id, Double bonus_set);

    String addPerformance(Performance performance);

    String addWorkplan(Workplan workplan);

    Map<String, Object> getPlanFromId(String wid);

    String updatePerformance(Performance performance);

    String updateWorkplan(Workplan workplan);

    List<Double> getMouthGrade(String uid);
}

package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.entity.Salary;
import edu.cqut.pm_system.entity.Workplan;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface PerformanceDao {
    List<Performance> getAllPerformance();

    List<PerformanceSet> getAllPerformanceSet();

    List<Workplan> getWorkplanOrdinary(String uid);

    List<Workplan> getWorkplanManager(String uid);

    List<Workplan> getWorkplanAdmin();

    void addPerformance(Performance performance);

    void addWorkplan(Workplan workplan);

    void updatePerformanceSetFromId(@Param("pset_id") String pset_id, @Param("bonus_set") Double bonus_set);

    Map<String, Object> getPlanFromId(String wid);

    void updatePerformance(Performance performance);

    void updateWorkplan(Workplan workplan);

    Double getBounsSet(Integer grade);

    Double getMouthGrade(String uid, Integer pmonth);

    List<Map<String, Object>> searchPerformance(@Param("uempid")String uempid, @Param("uempname")String uempname, @Param("pyear")Integer pyear, @Param("pmonth")Integer pmonth);

    Double getBaseSalary(String uid);

    Double getAttendance(String uid);

    Integer getPyear(String uid);

    Integer getPmonth(String uid);

    String getUid(String pid);

    void addEmpSalary(Salary salary);
}

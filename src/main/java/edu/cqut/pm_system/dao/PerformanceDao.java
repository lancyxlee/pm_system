package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface PerformanceDao {
    List<Performance>  getAllPerformance();


    List<PerformanceSet> getAllPerformanceSet();
    void updatePerformanceSetFromId(@Param("pset_id")String pset_id,@Param("bonus_set")Double bonus_set);
}

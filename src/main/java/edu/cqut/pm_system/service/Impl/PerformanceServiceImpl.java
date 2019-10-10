package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.cqut.pm_system.dao.PerformanceDao;
import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.service.PerformanceService;

/**
 * 绩效管理界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    PerformanceDao performanceDao;

    @Override
    public List<PerformanceSet> getAllPerformanceSet() {
        try {
            return performanceDao.getAllPerformanceSet();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Performance> getAllPerformance() {
        try {
            return performanceDao.getAllPerformance();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String updatePerformanceSetFromId(String pset_id, Double bonus_set) {
        try {
            performanceDao.updatePerformanceSetFromId(pset_id, bonus_set);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
}

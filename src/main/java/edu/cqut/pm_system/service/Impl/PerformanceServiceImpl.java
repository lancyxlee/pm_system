package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.cqut.pm_system.dao.PerformanceDao;
import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.entity.Salary;
import edu.cqut.pm_system.entity.Workplan;
import edu.cqut.pm_system.service.PerformanceService;
import edu.cqut.pm_system.util.EntityIDFactory;

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
    public List<Workplan> getWorkplan(String uid, Integer role) {
        try {
            if (role == 0) {
                return performanceDao.getWorkplanAdmin();
            } else if (role == 1) {
                return performanceDao.getWorkplanManager(uid);
            } else {
                return performanceDao.getWorkplanOrdinary(uid);
            }
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

    @Override
    public String addPerformance(Performance performance) {
        try {
            performanceDao.addPerformance(performance);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String addWorkplan(Workplan workplan) {
        try {
            performanceDao.addWorkplan(workplan);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public Map<String, Object> getPlanFromId(String wid) {
        try {
            return performanceDao.getPlanFromId(wid);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String updatePerformance(Performance performance) {
        String uid = performanceDao.getUid(performance.getPid());
        if (performance.getAdst_rating() != null) {
            Double performanceValue = (performance.getSelf_rating() + performance.getAdst_rating() + performance.getSupv_rating()) / 3;
            //大于85小于100为绩效一等
            if (performanceValue > 85 && performanceValue <= 100) {
                performance.setGrade(1);
            } else if (performanceValue > 70 && performanceValue <= 85) {
                //大于70小于85为绩效二等
                performance.setGrade(2);
            } else if (performanceValue > 60 && performanceValue <= 70) {
                //大于60小于70为绩效三等
                performance.setGrade(3);
            } else {
                performance.setGrade(4);
            }
            //四舍五入保留两位小数
            BigDecimal bigDecimal = new BigDecimal(performanceValue).setScale(2, RoundingMode.HALF_UP);
            performanceValue = bigDecimal.doubleValue();
            performance.setPerformance(performanceValue);
            Double grade = performanceDao.getBounsSet(performance.getGrade());
            performance.setBonusres(performanceDao.getBaseSalary(uid) * grade);
            Salary salary = new Salary();
            salary.setId(EntityIDFactory.createId());
            salary.setUid(uid);
            salary.setBaseSalary(performanceDao.getBaseSalary(uid));
            salary.setYear(performanceDao.getPyear(uid));
            salary.setMonth(performanceDao.getPmonth(uid));
            salary.setAttendence(performanceDao.getAttendance(uid));
            salary.setKpi(performance.getBonusres());
            salary.setFinalSalary(salary.getBaseSalary() + salary.getAttendence() + salary.getKpi());
            performanceDao.addEmpSalary(salary);
        }
        try {
            performanceDao.updatePerformance(performance);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String updateWorkplan(Workplan workplan) {
        if (workplan.getSelf_rating() != null) workplan.setCompletion("已完成");
        else workplan.setCompletion("未完成");
        try {
            performanceDao.updateWorkplan(workplan);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<Double> getMouthGrade(String uid) {
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            Double result;
            try {
                result = performanceDao.getMouthGrade(uid, i);
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
            if (result == null) list.add(0.0);
            else {
                BigDecimal bigDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
                result = bigDecimal.doubleValue();
                list.add(result);
            }
        }
        return list;
    }

    public List<Map<String, Object>> searchPerformance(String uempid, String uempname, Integer pyear, Integer pmonth) {
        try {
            return performanceDao.searchPerformance(uempid,uempname,pyear,pmonth);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

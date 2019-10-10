package edu.cqut.pm_system.controller;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.entity.Workplan;
import edu.cqut.pm_system.service.PerformanceService;
import edu.cqut.pm_system.util.EntityIDFactory;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 绩效管理界面Controller层
 *
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    PerformanceService performanceService;

    @RequestMapping(value = "getAllPerformance", method = RequestMethod.GET)
    public String getAllPerformance(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageHelper.startPage(page, limit);
        List<Performance> performance = performanceService.getAllPerformance();
        return JacksonUtil.objectToJson(performance);
    }

    @RequestMapping(value = "getAllPerformanceSet", method = RequestMethod.GET)
    public String getAllPerformanceSet() {
        List<PerformanceSet> result = performanceService.getAllPerformanceSet();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "getWorkplan", method = RequestMethod.GET)
    public String getWorkplan(HttpSession httpSession) {
        Integer role = (Integer) httpSession.getAttribute("status");
        List<Workplan> result = performanceService.getWorkplan((String) httpSession.getAttribute("loginId"), role);

        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "updatePerformanceSetFromId", method = RequestMethod.POST)
    public String updatePerformanceSetFromId(String pset_id, Double bonus_set) {
        String result = performanceService.updatePerformanceSetFromId(pset_id, bonus_set);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "updatePerformance", method = RequestMethod.POST)
    public String updatePerformance(String dailyplan, Double self_rating, String completion, Double supv_rating, Double adst_rating, String wid) {
        Workplan workplan = new Workplan();
        workplan.setDailyplan(dailyplan);
        workplan.setCompletion(completion);
        workplan.setSelf_rating(self_rating);
        workplan.setSupv_rating(supv_rating);
        workplan.setAdst_rating(adst_rating);
        workplan.setWid(wid);
        Performance performance = new Performance();
        performance.setSelf_rating(self_rating);
        performance.setSupv_rating(supv_rating);
        performance.setAdst_rating(adst_rating);
        performance.setPid(wid);
        String result1 = performanceService.updateWorkplan(workplan);
        String result2 = performanceService.updatePerformance(performance);
        if ("SUCCESS".equals(result1) && "SUCCESS".equals(result2)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "addPerformance", method = RequestMethod.POST)
    public String addPerformance(HttpSession httpSession, String dailyplan) {
        String id = EntityIDFactory.createId();
        Performance performance = new Performance();
        performance.setPid(id);
        performance.setUid((String) httpSession.getAttribute("loginId"));
        Calendar cal = Calendar.getInstance();
        performance.setPyear(cal.get(Calendar.YEAR));
        performance.setPmonth(cal.get(Calendar.MONTH) + 1);
        Workplan workplan = new Workplan();
        workplan.setWid(id);
        workplan.setUid((String) httpSession.getAttribute("loginId"));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(format.parse(format.format(new Date())).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        workplan.setDate(timestamp);
        workplan.setDailyplan(dailyplan);
        workplan.setCompletion("未完成");
        String result1 = performanceService.addPerformance(performance);
        String result2 = performanceService.addWorkplan(workplan);
        if ("SUCCESS".equals(result1) && "SUCCESS".equals(result2)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getPlanFromId", method = RequestMethod.GET)
    public String getPlanFromId(String wid) {
        Map<String, Object> result = performanceService.getPlanFromId(wid);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }
}

package edu.cqut.pm_system.controller;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.cqut.pm_system.entity.Performance;
import edu.cqut.pm_system.entity.PerformanceSet;
import edu.cqut.pm_system.service.PerformanceService;
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
    @RequestMapping(value = "updatePerformanceSetFromId", method = RequestMethod.POST)
    public String updatePerformanceSetFromId(String pset_id, Double bonus_set) {
        String result = performanceService.updatePerformanceSetFromId(pset_id, bonus_set);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

}

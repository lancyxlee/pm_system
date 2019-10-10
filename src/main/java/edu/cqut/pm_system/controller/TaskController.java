package edu.cqut.pm_system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.Task;
import edu.cqut.pm_system.service.AttendanceService;
import edu.cqut.pm_system.service.TaskService;
import edu.cqut.pm_system.util.EntityIDFactory;
import edu.cqut.pm_system.util.JacksonUtil;

/**
 * 任务管理Controller层
 *
 * @author llx
 * @date 2019/09/28
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "getAllTask", method = RequestMethod.GET)
    public String getAllTask() {
        List<Task> result = taskService.getAllTask();
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "getTaskFromId", method = RequestMethod.GET)
    public String getTaskFromId(String tid) {
        Task result = taskService.getTaskFromId(tid);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }

    @RequestMapping(value = "addTask", method = RequestMethod.POST)
    public String addTask(String name, String detail, String did, String deadline) {
        String id = EntityIDFactory.createId();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp timestamp1 = null;
        Timestamp timestamp2 = null;
        try {
            timestamp1 = new Timestamp(format.parse(format.format(new Date())).getTime());
            timestamp2 = new Timestamp(format.parse(deadline).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Task task = new Task();
        task.setTid(id);
        task.setName(name);
        task.setDetail(detail);
        task.setDid(did);
        task.setCreatetime(timestamp1);
        task.setDeadline(timestamp2);
        task.setStatus(0);
        String result = taskService.addTask(task);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "updateTask", method = RequestMethod.POST)
    public String updateTask(String name, String detail, String did, String deadline, Integer status, String tid) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(format.parse(deadline).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Task task = new Task();
        task.setTid(tid);
        task.setName(name);
        task.setDetail(detail);
        task.setDid(did);
        task.setDeadline(timestamp);
        task.setStatus(status);
        String result = taskService.updateTask(task);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "deleteTask", method = RequestMethod.DELETE)
    public String deleteTask(String tid) {
        String result = taskService.deleteTask(tid);
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "searchTask", method = RequestMethod.GET)
    public String searchTask(String name, String deptname) {
        List<Task> result = taskService.searchTask(name, deptname);
        if (result != null) {
            return JacksonUtil.objectToJson(result);
        } else {
            return "FAIL";
        }
    }
}

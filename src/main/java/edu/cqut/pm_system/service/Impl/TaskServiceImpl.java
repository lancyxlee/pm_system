package edu.cqut.pm_system.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import edu.cqut.pm_system.dao.AttendanceDao;
import edu.cqut.pm_system.dao.TaskDao;
import edu.cqut.pm_system.entity.Attendance;
import edu.cqut.pm_system.entity.AttendanceSet;
import edu.cqut.pm_system.entity.Task;
import edu.cqut.pm_system.service.AttendanceService;
import edu.cqut.pm_system.service.TaskService;

/**
 * 员工信息界面Service实现层
 *
 * @author llx
 * @date 2019/09/28
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public List<Task> getAllTask() {
        return taskDao.getAllTask();
    }

    @Override
    public Task getTaskFromId(String tid) {
        return taskDao.getTaskFromId(tid);
    }

    @Override
    public String addTask(Task task) {
        try {
            taskDao.addTask(task);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String updateTask(Task task) {
        try {
            taskDao.updateTask(task);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String deleteTask(String tid) {
        try {
            taskDao.deleteTask(tid);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public List<Task> searchTask(String name, String deptname) {
        return taskDao.searchTask(name, deptname);
    }
}

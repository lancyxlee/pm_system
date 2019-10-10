package edu.cqut.pm_system.service;

import java.util.List;

import edu.cqut.pm_system.entity.Task;

/**
 * @author llx
 * @date 2019/10/04
 */
public interface TaskService {

    List<Task> getAllTask();
    Task getTaskFromId(String tid);
    String addTask(Task task);
    String updateTask(Task task);
    String deleteTask(String tid);
    List<Task> searchTask(String name, String deptname);
}

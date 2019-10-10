package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import edu.cqut.pm_system.entity.Task;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface TaskDao {
    List<Task> getAllTask();
    Task getTaskFromId(String tid);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(String tid);
    List<Task> searchTask(String name, String deptname);
}

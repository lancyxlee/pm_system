package edu.cqut.pm_system.entity;

import java.sql.Timestamp;

/**
 * 任务类 对应 表task_management
 * @author llx
 * @date 2019/9/24
 */
public class Task {
    private String tid;
    private String name;
    private String detail;
    private String did;
    private Timestamp createtime;
    private Timestamp deadline;
    /**
     * 状态（0：未完成；1：已完成）
     */
    private Integer status;

    public Task() {
    }

    public Task(String tid, String name, String detail, String did, Timestamp createtime, Timestamp deadline, Integer status) {
        this.tid = tid;
        this.name = name;
        this.detail = detail;
        this.did = did;
        this.createtime = createtime;
        this.deadline = deadline;
        this.status = status;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskManagement{" +
                "tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", did='" + did + '\'' +
                ", createtime=" + createtime +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }
}

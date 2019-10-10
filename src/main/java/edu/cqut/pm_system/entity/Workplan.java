package edu.cqut.pm_system.entity;

import java.sql.Timestamp;

/**
 * 工作计划类
 * @author llx
 * @date 2019/9/24
 */
public class Workplan {

    private String wid;
    private String uid;
    private Timestamp date;
    private String dailyplan;
    private String completion;
    private Double supv_rating;
    private Double self_rating;
    private Double adst_rating;

    public Workplan() {
    }

    public Workplan(String wid, String uid, Timestamp date, String dailyplan, String completion, Double supv_rating, Double self_rating, Double adst_rating) {
        this.wid = wid;
        this.uid = uid;
        this.date = date;
        this.dailyplan = dailyplan;
        this.completion = completion;
        this.supv_rating = supv_rating;
        this.self_rating = self_rating;
        this.adst_rating = adst_rating;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDailyplan() {
        return dailyplan;
    }

    public void setDailyplan(String dailyplan) {
        this.dailyplan = dailyplan;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public Double getSupv_rating() {
        return supv_rating;
    }

    public void setSupv_rating(Double supv_rating) {
        this.supv_rating = supv_rating;
    }

    public Double getSelf_rating() {
        return self_rating;
    }

    public void setSelf_rating(Double self_rating) {
        this.self_rating = self_rating;
    }

    public Double getAdst_rating() {
        return adst_rating;
    }

    public void setAdst_rating(Double adst_rating) {
        this.adst_rating = adst_rating;
    }

    @Override
    public String toString() {
        return "Workplan{" +
                "wid='" + wid + '\'' +
                ", uid='" + uid + '\'' +
                ", date=" + date +
                ", dailyplan='" + dailyplan + '\'' +
                ", completion='" + completion + '\'' +
                ", supv_rating=" + supv_rating +
                ", self_rating=" + self_rating +
                ", adst_rating=" + adst_rating +
                '}';
    }
}

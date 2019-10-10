package edu.cqut.pm_system.entity;

/**
 * 绩效信息类
 * @author llx
 * @date 2019/9/24
 */
public class Performance {

    private String pid;
    private String uid;
    private Integer pyear;
    private Integer pmonth;
    private Double performance;
    private Integer grade;
    private Double supv_rating;//主管评分
    private Double self_rating;//自评分
    private Double adst_rating;//管理员评分
    private Double bonusres;

    public Performance() {
    }

    public Performance(String pid, String uid, Integer pyear, Integer pmonth, Double performance, Integer grade, Double supv_rating, Double self_rating, Double adst_rating, Double bonusres) {
        this.pid = pid;
        this.uid = uid;
        this.pyear = pyear;
        this.pmonth = pmonth;
        this.performance = performance;
        this.grade = grade;
        this.supv_rating = supv_rating;
        this.self_rating = self_rating;
        this.adst_rating = adst_rating;
        this.bonusres = bonusres;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPyear() {
        return pyear;
    }

    public void setPyear(Integer pyear) {
        this.pyear = pyear;
    }

    public Integer getPmonth() {
        return pmonth;
    }

    public void setPmonth(Integer pmonth) {
        this.pmonth = pmonth;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public Double getBonusres() {
        return bonusres;
    }

    public void setBonusres(Double bonusres) {
        this.bonusres = bonusres;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "pid='" + pid + '\'' +
                ", uid='" + uid + '\'' +
                ", pyear=" + pyear +
                ", pmonth=" + pmonth +
                ", performance=" + performance +
                ", grade=" + grade +
                ", supvRating=" + supv_rating +
                ", selfRating=" + self_rating +
                ", adstRating=" + adst_rating +
                ", bonusres=" + bonusres +
                '}';
    }
}

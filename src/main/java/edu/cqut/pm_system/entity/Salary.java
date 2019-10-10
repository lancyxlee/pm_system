package edu.cqut.pm_system.entity;

/**
 * 工资信息类
 * @author llx
 * @date 2019/9/24
 */
public class Salary {

    String id;
    String uid;
    Double basesalary;
    Double finalsalary;
    Integer year;
    Integer month;
    Double attendance;
    Double kpi;

    public Salary() {
    }

    public Salary(String id, String uid, Double basesalary, Double finalsalary, Integer year, Integer month, Double attendance, Double kpi) {
        this.id = id;
        this.uid = uid;
        this.basesalary = basesalary;
        this.finalsalary = finalsalary;
        this.year = year;
        this.month = month;
        this.attendance = attendance;
        this.kpi = kpi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getBaseSalary() {
        return basesalary;
    }

    public void setBaseSalary(Double basesalary) {
        this.basesalary = basesalary;
    }

    public Double getFinalSalary() {
        return finalsalary;
    }

    public void setFinalSalary(Double finalsalary) {
        this.finalsalary = finalsalary;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getAttendence() {
        return attendance;
    }

    public void setAttendence(Double attendance) {
        this.attendance = attendance;
    }

    public Double getKpi() {
        return kpi;
    }

    public void setKpi(Double kpi) {
        this.kpi = kpi;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", baseSalary=" + basesalary +
                ", finalSalary=" + finalsalary +
                ", year=" + year +
                ", month=" + month +
                ", attendence=" + attendance +
                ", kpi=" + kpi +
                '}';
    }
}

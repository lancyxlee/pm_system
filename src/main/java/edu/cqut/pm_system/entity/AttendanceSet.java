package edu.cqut.pm_system.entity;

/**
 * 考勤奖罚设置类
 * @author llx
 * @date 2019/9/24
 */
public class AttendanceSet {

    private String setid;
    private Double setlatecome;
    private Double setearlyleave;
    private Double setearlycome;
    private Double setovertime;
    private Double setleave;

    public AttendanceSet() {
    }

    public AttendanceSet(String setid, Double setlatecome, Double setearlyleave, Double setearlycome, Double setovertime, Double setleave) {
        this.setid = setid;
        this.setlatecome = setlatecome;
        this.setearlyleave = setearlyleave;
        this.setearlycome = setearlycome;
        this.setovertime = setovertime;
        this.setleave = setleave;
    }

    public String getSetid() {
        return setid;
    }

    public void setSetid(String setid) {
        this.setid = setid;
    }

    public Double getSetlatecome() {
        return setlatecome;
    }

    public void setSetlatecome(Double setlatecome) {
        this.setlatecome = setlatecome;
    }

    public Double getSetearlyleave() {
        return setearlyleave;
    }

    public void setSetearlyleave(Double setearlyleave) {
        this.setearlyleave = setearlyleave;
    }

    public Double getSetearlycome() {
        return setearlycome;
    }

    public void setSetearlycome(Double setearlycome) {
        this.setearlycome = setearlycome;
    }

    public Double getSetovertime() {
        return setovertime;
    }

    public void setSetovertime(Double setovertime) {
        this.setovertime = setovertime;
    }

    public Double getSetleave() {
        return setleave;
    }

    public void setSetleave(Double setleave) {
        this.setleave = setleave;
    }

    @Override
    public String toString() {
        return "AttendanceSet{" +
                "setid='" + setid + '\'' +
                ", setlatecome=" + setlatecome +
                ", setearlyleave=" + setearlyleave +
                ", setearlycome=" + setearlycome +
                ", setovertime=" + setovertime +
                ", setleave=" + setleave +
                '}';
    }
}

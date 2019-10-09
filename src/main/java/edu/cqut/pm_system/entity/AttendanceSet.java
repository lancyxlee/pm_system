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
    private Double setworkovertime;
    private Double setleave;
    private Double setwovertime;
    private Double sethovertime;

    public AttendanceSet() {
    }

    public AttendanceSet(String setid, Double setlatecome, Double setearlyleave, Double setearlycome, Double setworkovertime, Double setleave, Double setwovertime, Double sethovertime) {
        this.setid = setid;
        this.setlatecome = setlatecome;
        this.setearlyleave = setearlyleave;
        this.setearlycome = setearlycome;
        this.setworkovertime = setworkovertime;
        this.setleave = setleave;
        this.setwovertime = setwovertime;
        this.sethovertime = sethovertime;
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

    public Double getSetworkovertime() {
        return setworkovertime;
    }

    public void setSetworkovertime(Double setworkovertime) {
        this.setworkovertime = setworkovertime;
    }

    public Double getSetleave() {
        return setleave;
    }

    public void setSetleave(Double setleave) {
        this.setleave = setleave;
    }

    public Double getSetwovertime() {
        return setwovertime;
    }

    public void setSetwovertime(Double setwovertime) {
        this.setwovertime = setwovertime;
    }

    public Double getSethovertime() {
        return sethovertime;
    }

    public void setSethovertime(Double sethovertime) {
        this.sethovertime = sethovertime;
    }

    @Override
    public String toString() {
        return "AttendanceSet{" +
                "setid='" + setid + '\'' +
                ", setlatecome=" + setlatecome +
                ", setearlyleave=" + setearlyleave +
                ", setearlycome=" + setearlycome +
                ", setworkovertime=" + setworkovertime +
                ", setleave=" + setleave +
                ", setwovertime=" + setwovertime +
                ", sethovertime=" + sethovertime +
                '}';
    }
}

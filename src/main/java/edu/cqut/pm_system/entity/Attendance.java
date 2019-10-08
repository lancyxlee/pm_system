package edu.cqut.pm_system.entity;

/**
 * 考勤信息类
 * @author llx
 * @date 2019/9/24
 */
public class Attendance {
    private String aid;
    private String uempid;
    private String uempname;
    private Integer ayear;
    private Integer amonth;
    private Integer alatecome;
    private Integer aearlyleave;
    private Integer aearlycome;
    private Integer aovertime;
    private Integer aleave;
    private Integer wovertime;
    private Integer hovertime;
    private Double bonusres;

    public Attendance() {
    }

    public Attendance(String aid, String uempid, String uempname, Integer ayear, Integer amonth, Integer alatecome, Integer aearlyleave, Integer aearlycome, Integer aovertime, Integer aleave, Integer wovertime, Integer hovertime, Double bonusres) {
        this.aid = aid;
        this.uempid = uempid;
        this.uempname = uempname;
        this.ayear = ayear;
        this.amonth = amonth;
        this.alatecome = alatecome;
        this.aearlyleave = aearlyleave;
        this.aearlycome = aearlycome;
        this.aovertime = aovertime;
        this.aleave = aleave;
        this.wovertime = wovertime;
        this.hovertime = hovertime;
        this.bonusres = bonusres;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUempid() {
        return uempid;
    }

    public void setUempid(String uempid) {
        this.uempid = uempid;
    }

    public String getUempname() {
        return uempname;
    }

    public void setUempname(String uempname) {
        this.uempname = uempname;
    }

    public Integer getAyear() {
        return ayear;
    }

    public void setAyear(Integer ayear) {
        this.ayear = ayear;
    }

    public Integer getAmonth() {
        return amonth;
    }

    public void setAmonth(Integer amonth) {
        this.amonth = amonth;
    }

    public Integer getAlatecome() {
        return alatecome;
    }

    public void setAlatecome(Integer alatecome) {
        this.alatecome = alatecome;
    }

    public Integer getAearlyleave() {
        return aearlyleave;
    }

    public void setAearlyleave(Integer aearlyleave) {
        this.aearlyleave = aearlyleave;
    }

    public Integer getAearlycome() {
        return aearlycome;
    }

    public void setAearlycome(Integer aearlycome) {
        this.aearlycome = aearlycome;
    }

    public Integer getAovertime() {
        return aovertime;
    }

    public void setAovertime(Integer aovertime) {
        this.aovertime = aovertime;
    }

    public Integer getAleave() {
        return aleave;
    }

    public void setAleave(Integer aleave) {
        this.aleave = aleave;
    }

    public Double getBonusres() {
        return bonusres;
    }

    public void setBonusres(Double bonusres) {
        this.bonusres = bonusres;
    }

    public Integer getWovertime() {
        return wovertime;
    }

    public void setWovertime(Integer wovertime) {
        this.wovertime = wovertime;
    }

    public Integer getHovertime() {
        return hovertime;
    }

    public void setHovertime(Integer hovertime) {
        this.hovertime = hovertime;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "aid='" + aid + '\'' +
                ", uempid='" + uempid + '\'' +
                ", uempname='" + uempname + '\'' +
                ", ayear=" + ayear +
                ", amonth=" + amonth +
                ", alatecome=" + alatecome +
                ", aearlyleave=" + aearlyleave +
                ", aearlycome=" + aearlycome +
                ", aovertime=" + aovertime +
                ", aleave=" + aleave +
                ", wovertime=" + wovertime +
                ", hovertime=" + hovertime +
                ", bonusres=" + bonusres +
                '}';
    }
}

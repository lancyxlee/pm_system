package edu.cqut.pm_system.entity;

import java.util.Date;

/**
 * 员工类
 * @author llx
 * @date 2019/9/24
 */
public class Employee {
    private String uid;
    private String uempid;
    private String uempname;
    private Integer age;
    /**
     * 性别（0：男 1：女）
     */
    private Integer sex;
    private String idnum;
    private String telnum;
    private Date startdate;
    private String deptnum;

    public Employee() {
    }

    public Employee(String uid, String uempid, String uempname, Integer age, Integer sex,
                    String idnum, String telnum, Date startdate, String deptnum) {
        this.uid = uid;
        this.uempid = uempid;
        this.uempname = uempname;
        this.age = age;
        this.sex = sex;
        this.idnum = idnum;
        this.telnum = telnum;
        this.startdate = startdate;
        this.deptnum = deptnum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uid='" + uid + '\'' +
                ", uempid='" + uempid + '\'' +
                ", uempname='" + uempname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", idnum='" + idnum + '\'' +
                ", telnum='" + telnum + '\'' +
                ", startdate=" + startdate +
                ", deptnum='" + deptnum + '\'' +
                '}';
    }
}

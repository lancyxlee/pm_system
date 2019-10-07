package edu.cqut.pm_system.entity;

/**
 * 部门类
 * @author llx
 * @date 2019/9/24
 */
public class Dept {

    private String did;
    private String deptname;
    private String deptnum;
    private String tel;

    public Dept(String did) {
        this.did = did;
    }

    public Dept(String did, String deptname, String deptnum, String tel) {
        this.did = did;
        this.deptname = deptname;
        this.deptnum = deptnum;
        this.tel = tel;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did='" + did + '\'' +
                ", deptname='" + deptname + '\'' +
                ", deptnum='" + deptnum + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

package edu.cqut.pm_system.entity;

/**
 * 部门工资类 对应 salary_set表
 * @author llx
 * @date 2019/9/24
 */
public class DeptSalary {

    private String salarysetid;
    private String deptnum;
    private Double basesalary;
    private Integer role;

    public DeptSalary() {
    }

    public DeptSalary(String salarysetid, String deptnum, Double basesalary, Integer role) {
        this.salarysetid = salarysetid;
        this.deptnum = deptnum;
        this.basesalary = basesalary;
        this.role = role;
    }

    public String getSalarysetid() {
        return salarysetid;
    }

    public void setSalarysetid(String salarysetid) {
        this.salarysetid = salarysetid;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public Double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(Double basesalary) {
        this.basesalary = basesalary;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SalarySet{" +
                "salarysetid='" + salarysetid + '\'' +
                ", deptnum='" + deptnum + '\'' +
                ", basesalary=" + basesalary +
                ", role=" + role +
                '}';
    }
}

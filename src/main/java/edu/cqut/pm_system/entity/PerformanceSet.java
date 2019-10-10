package edu.cqut.pm_system.entity;

/**
 * 绩效奖罚设置类
 * @author llx
 * @date 2019/9/24
 */
public class PerformanceSet {

    private String pset_id;
    private Integer grade;
    private Double bonus_set;

    public PerformanceSet() {
    }

    public PerformanceSet(String pset_id, Integer grade, Double bonus_set) {
        this.pset_id = pset_id;
        this.grade = grade;
        this.bonus_set = bonus_set;
    }

    public String getpSetId() {
        return pset_id;
    }

    public void setpSetId(String pset_id) {
        this.pset_id = pset_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getBonusSet() {
        return bonus_set;
    }

    public void setBonusSet(Double bonusSet) {
        this.bonus_set = bonusSet;
    }

    @Override
    public String toString() {
        return "PerfomanceSet{" +
                "pSetId='" + pset_id + '\'' +
                ", grade=" + grade +
                ", bonusSet=" + bonus_set +
                '}';
    }
}

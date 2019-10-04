package edu.cqut.pm_system.entity;

/**
 * 用户类
 * @author llx
 * @date 2019/10/04
 */
public class User {
    String uid;
    String username;
    String password;
    /**
     * 角色（0：管理员1：部门经理2：普通员工）
     */
    Integer role;

    public User() {
    }

    public User(String uid, String username, String password, Integer role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

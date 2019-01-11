package com.zc.webstu.bean;

public class User {
    //用户ID
    private String userId;
    //用户名称
    private String userName;
    //用户密码
    private String userPwd;
    //用户角色
    private String roleId;
    //余额
    private Integer hasMoney = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(Integer hasMoney) {
        this.hasMoney = hasMoney;
    }
}

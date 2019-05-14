package com.springjdbc.pojo;

public class UserLog {
    private Integer ulId;
    private String action;
    private String userName;
    private String ip;
    private String time;

    public UserLog(Integer ulId, String action, String userName, String ip, String time) {
        this.ulId = ulId;
        this.action = action;
        this.userName = userName;
        this.ip = ip;
        this.time = time;
    }

    public UserLog(String action, String userName, String ip, String time) {
        this.action = action;
        this.userName = userName;
        this.ip = ip;
        this.time = time;
    }

    public UserLog() {
    }

    public Integer getUlId() {
        return ulId;
    }

    public void setUlId(Integer ulId) {
        this.ulId = ulId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.springjdbc.pojo;

public class MeetingRoom {
    private Integer meetingroomId;

    private Integer account;

    private String location;

    private String useAccount;

    private String deviceCondition;

    private Boolean isfree;

    private Boolean isbook;

    public Integer getMeetingroomId() {
        return meetingroomId;
    }

    public void setMeetingroomId(Integer meetingroomId) {
        this.meetingroomId = meetingroomId;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getUseAccount() {
        return useAccount;
    }

    public void setUseAccount(String useAccount) {
        this.useAccount = useAccount == null ? null : useAccount.trim();
    }

    public String getDeviceCondition() {
        return deviceCondition;
    }

    public void setDeviceCondition(String deviceCondition) {
        this.deviceCondition = deviceCondition == null ? null : deviceCondition.trim();
    }

    public Boolean getIsfree() {
        return isfree;
    }

    public void setIsfree(Boolean isfree) {
        this.isfree = isfree;
    }

    public Boolean getIsbook() {
        return isbook;
    }

    public void setIsbook(Boolean isbook) {
        this.isbook = isbook;
    }
}
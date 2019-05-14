package com.springjdbc.pojo;

public class Meeting {
    private Integer meetingId;

    private Integer userId;

    private Integer roomId;

    private String theme;

    private String srarttime;

    private String record;

    private String endetime;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getSrarttime() {
        return srarttime;
    }

    public void setSrarttime(String srarttime) {
        this.srarttime = srarttime == null ? null : srarttime.trim();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public String getEndetime() {
        return endetime;
    }

    public void setEndetime(String endetime) {
        this.endetime = endetime == null ? null : endetime.trim();
    }
}
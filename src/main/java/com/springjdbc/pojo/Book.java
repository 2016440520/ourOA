package com.springjdbc.pojo;

public class Book {
    private Integer bookId;

    private Integer roomId;

    private Integer userId;

    private String bookstate;

    private String srarttime;

    private String endetime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBookstate() {
        return bookstate;
    }

    public void setBookstate(String bookstate) {
        this.bookstate = bookstate == null ? null : bookstate.trim();
    }

    public String getSrarttime() {
        return srarttime;
    }

    public void setSrarttime(String srarttime) {
        this.srarttime = srarttime == null ? null : srarttime.trim();
    }

    public String getEndetime() {
        return endetime;
    }

    public void setEndetime(String endetime) {
        this.endetime = endetime == null ? null : endetime.trim();
    }
}
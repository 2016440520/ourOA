package com.springjdbc.pojo;

public class Message {
    private Integer messageId;

    private Integer addressId;

    private String addressName;

    private String title;

    private String content;

    private String date;

    private Boolean issend;

    private Boolean isread;

    private Integer receiverId;

    private String receiverName;

    private Boolean addressdelete;

    private Boolean receiverdelete;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Boolean getIssend() {
        return issend;
    }

    public void setIssend(Boolean issend) {
        this.issend = issend;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public Boolean getAddressdelete() {
        return addressdelete;
    }

    public void setAddressdelete(Boolean addressdelete) {
        this.addressdelete = addressdelete;
    }

    public Boolean getReceiverdelete() {
        return receiverdelete;
    }

    public void setReceiverdelete(Boolean receiverdelete) {
        this.receiverdelete = receiverdelete;
    }
}
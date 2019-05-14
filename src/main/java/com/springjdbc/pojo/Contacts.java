package com.springjdbc.pojo;

//联系人
public class Contacts {
    private Integer id;
    private String username;
    private String phone;
    private String sex;
    private Integer age;
    private String address;
    private Integer cId;

    public Contacts(Integer id, String username, String phone, String sex, Integer age, String address, Integer cId) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.cId = cId;
    }

    public Contacts() {
    }

    public Contacts(Integer id, String username, String phone, String sex, Integer age, String address) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", cId=" + cId +
                '}';
    }
}

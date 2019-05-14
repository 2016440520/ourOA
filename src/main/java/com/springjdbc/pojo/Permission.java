package com.springjdbc.pojo;

import java.util.List;

public class Permission {
    private Integer id; // 编号

    private String permissionName; // 菜单名称

    private String name; // 备注

    private String parent;

    private List<Permission> children;

    private String msg;

    public Permission(String permissionName, String name, String parent, List<Permission> children, String msg) {
        this.permissionName = permissionName;
        this.name = name;
        this.parent = parent;
        this.children = children;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Permission() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }


    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

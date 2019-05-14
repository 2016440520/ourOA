package com.springjdbc.service;

import com.springjdbc.pojo.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getPermissionByUserName(String userName);

}

package com.springjdbc.service.impl;

import com.springjdbc.mapper.PermissionMapper;
import com.springjdbc.pojo.Permission;
import com.springjdbc.service.PermissionService;
import com.springjdbc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImple implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Permission> getPermissionByUserName(String userName) {
        List<Permission>  permissions = permissionMapper.getPermissionByUserName(userName);
        return permissions;
    }




}

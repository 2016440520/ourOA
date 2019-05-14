package com.springjdbc.service;

import com.springjdbc.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByUserName(String userName);

}

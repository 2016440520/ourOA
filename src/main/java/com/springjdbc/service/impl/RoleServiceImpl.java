package com.springjdbc.service.impl;


import com.springjdbc.mapper.RoleMapper;
import com.springjdbc.pojo.Role;
import com.springjdbc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRolesByUserName(String userName) {
        List<Role>  roles = roleMapper.getRolesByUserName(userName);
        return roles;
    }


}

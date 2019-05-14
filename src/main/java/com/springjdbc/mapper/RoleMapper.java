package com.springjdbc.mapper;

import com.springjdbc.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRolesByUserName(String userName);
}

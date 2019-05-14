package com.springjdbc.mapper;


import com.springjdbc.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission> getPermissionByUserName(String userName);
}

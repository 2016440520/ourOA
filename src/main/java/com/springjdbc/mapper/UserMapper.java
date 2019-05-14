package com.springjdbc.mapper;

import com.springjdbc.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteUserByPrimaryKey(Integer userId);

    int insertUser(User record);

    int insertUserSelective(User record);

    User selectUserByPrimaryKey(Integer userId);

    User selectUserByUsername(String username);

    int updateUserByPrimaryKeySelective(User record);

    int updateUserByPrimaryKey(User record);

    List<User> selectAllUsers();
}
package com.springjdbc.service.impl;

import com.springjdbc.mapper.UserLogMapper;
import com.springjdbc.pojo.UserLog;
import com.springjdbc.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public int insert(UserLog userLog) {
        int row = userLogMapper.insert(userLog);
        return row;
    }
}

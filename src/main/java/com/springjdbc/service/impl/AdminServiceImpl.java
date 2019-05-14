package com.springjdbc.service.impl;

import com.springjdbc.mapper.*;
import com.springjdbc.pojo.*;
import com.springjdbc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    @Autowired
    public static UserServiceImpl userService;



    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUserByPrimaryKey(id);
    }

    @Override
    public int insertUser(User user) {
        if((userMapper.selectUserByUsername(user.getUsername()) == null)) {
            return userMapper.insertUserSelective(user);
        } else {
            return 0;
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectAllUsers();
        return users;
    }

    @Override
    public int deleteMeetingRoom(Integer meetingroomId) {
        return meetingRoomMapper.deleteMeetingRoomByPrimaryKey(meetingroomId);
    }

    @Override
    public int insertMeetingRoom(MeetingRoom record) {
        return meetingRoomMapper.insertMeetingRoomSelective(record);
    }

    @Override
    public int updateMeetingRoom(MeetingRoom record) {
        return meetingRoomMapper.updateMeetingRoomByPrimaryKeySelective(record);
    }

    @Override
    public int deleteMeeting(Integer meetingId) {
        return meetingMapper.deleteMeetingByPrimaryKey(meetingId);
    }

    @Override
    public int insertMeeting(Meeting record) {
        return meetingMapper.insertMeetingSelective(record);
    }

    @Override
    public int updateMeeting(Meeting record) {
        return meetingMapper.updateMeetingByPrimaryKeySelective(record);
    }

}

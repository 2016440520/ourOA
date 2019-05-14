package com.springjdbc.service;

import com.springjdbc.pojo.*;

import java.util.List;

public interface AdminService {

    int insertUser(User user);

    List<User> getAllUser();

    int deleteUser(Integer id);

    int deleteMeetingRoom(Integer meetingroomId);

    int insertMeetingRoom(MeetingRoom record);

    int updateMeetingRoom(MeetingRoom record);

    int deleteMeeting(Integer meetingId);

    int insertMeeting(Meeting record);

    int updateMeeting(Meeting record);


}

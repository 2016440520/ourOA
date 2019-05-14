package com.springjdbc.mapper;

import com.springjdbc.pojo.MeetingRoom;

import java.util.List;

public interface MeetingRoomMapper {
    int deleteMeetingRoomByPrimaryKey(Integer meetingroomId);

    int insertMeetingRoom(MeetingRoom record);

    int insertMeetingRoomSelective(MeetingRoom record);

    MeetingRoom selectMeetingRoomByPrimaryKey(Integer meetingroomId);

    int updateMeetingRoomByPrimaryKeySelective(MeetingRoom record);

    int updateMeetingRoomByPrimaryKey(MeetingRoom record);
}
package com.springjdbc.mapper;

import com.springjdbc.pojo.Meeting;

public interface MeetingMapper {
    int deleteMeetingByPrimaryKey(Integer meetingId);

    int insertMeeting(Meeting record);

    int insertMeetingSelective(Meeting record);

    Meeting selectMeetingByPrimaryKey(Integer meetingId);

    int updateMeetingByPrimaryKeySelective(Meeting record);

    int updateMeetingByPrimaryKey(Meeting record);
}
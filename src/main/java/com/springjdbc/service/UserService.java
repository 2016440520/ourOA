package com.springjdbc.service;

import com.springjdbc.pojo.*;

import java.util.List;

public interface UserService {

    User selectUserByPrimaryKey(Integer userId);

    User selectUserByUsername(String username);

    int updateUserByPrimaryKeySelective(User record);

    boolean findUserPassword(String username,String password);

    void sendEmail(String username);

    boolean validate(String code);

    String getCode();

    boolean updateUserPassword(String username,String password,String newPassword);

    int deleteMessageByPrimaryKey(Integer messageId);

    int insertMessageSelective(Message record);

    Message selectMessageByPrimaryKey(Integer messageId);

    List<Message> selectMessageByUserId(Integer id);

    int updateMessageByPrimaryKeySelective(Message record);

    Meeting selectMeetingByPrimaryKey(Integer meetingId);

    MeetingRoom selectMeetingRoomByPrimaryKey(Integer meetingroomId);

    int insertBook(Book book);

    List<Notice> getAllNotice();

    int deleteNoticeByPrimaryKey(Integer noticeId);

    int insertNoticeSelective(Notice record);



}

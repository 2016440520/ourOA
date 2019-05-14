package com.springjdbc.service.impl;

import com.springjdbc.mapper.*;
import com.springjdbc.pojo.*;
import com.springjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

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
    BookMapper bookMapper;
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    private JavaMailSender mailSender;
    private String validateCode = new String();


    @Override
    public User selectUserByPrimaryKey(Integer userId) {
        return userMapper.selectUserByPrimaryKey(userId);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public int updateUserByPrimaryKeySelective(User record) {
        record.setUserId(selectUserByUsername(record.getUsername()).getUserId());
        return userMapper.updateUserByPrimaryKeySelective(record);
    }

    @Override
    public void sendEmail(String username) {
        User user = userMapper.selectUserByUsername(username);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2272830035@qq.com");
        message.setTo(user.getEmail());
        message.setSubject("主题：找回密码");
        validateCode = getCode();
        message.setText(validateCode);
        mailSender.send(message);
    }
    @Override
    public boolean validate(String code) {
        if (code.equals(validateCode)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String getCode() {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] ch = new char[5];
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int index = random.nextInt(string.length());
            ch[i] = string.charAt(index);
        }
        String result = String.valueOf(ch);
        return result;
    }

    @Override
    public boolean updateUserPassword(String username,String password,String newPassword) {
        User user = userMapper.selectUserByUsername(username);
        if(user.getPassword().equals(password)) {
            user.setPassword(newPassword);
            userMapper.updateUserByPrimaryKeySelective(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean findUserPassword(String username,String password) {
        User user = selectUserByUsername(username);
        user.setPassword(password);
        userMapper.updateUserByPrimaryKeySelective(user);
        return true;
    }

    @Override
    public int deleteMessageByPrimaryKey(Integer messageId) {
        return messageMapper.deleteMessageByPrimaryKey(messageId);
    }

    @Override
    public int insertMessageSelective(Message record) {
        return messageMapper.insertMessageSelective(record);
    }

    @Override
    public Message selectMessageByPrimaryKey(Integer messageId) {
        return messageMapper.selectMessageByPrimaryKey(messageId);
    }

    @Override
    public int updateMessageByPrimaryKeySelective(Message record) {
        return messageMapper.updateMessageByPrimaryKeySelective(record);
    }

    @Override
    public Meeting selectMeetingByPrimaryKey(Integer meetingId) {
        return meetingMapper.selectMeetingByPrimaryKey(meetingId);
    }

    @Override
    public List<Message> selectMessageByUserId(Integer id) {
        return messageMapper.selectMessageByUserId(id);
    }

    @Override
    public MeetingRoom selectMeetingRoomByPrimaryKey(Integer meetingroomId) {
        return meetingRoomMapper.selectMeetingRoomByPrimaryKey(meetingroomId);
    }

    @Override
    public int insertBook(Book book) {
        List<Book> books = bookMapper.selectBookByRoomId(book.getRoomId());
        if(books.size() == 0) {
            return bookMapper.insertBookSelective(book);
        } else {

            return bookMapper.insertBookSelective(book);
        }
    }

    public List<MeetingRoom> getFreeMeetingRoom(String startTime,String endTime) {

        return null;
    }

    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.getAllNotices();
    }

    @Override
    public int deleteNoticeByPrimaryKey(Integer noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public int insertNoticeSelective(Notice record) {
        return noticeMapper.insertSelective(record);
    }
}

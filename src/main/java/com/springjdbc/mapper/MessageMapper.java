package com.springjdbc.mapper;

import com.springjdbc.pojo.Message;

import java.util.List;

public interface MessageMapper {
    int deleteMessageByPrimaryKey(Integer messageId);

    int insertMessage(Message record);

    int insertMessageSelective(Message record);

    Message selectMessageByPrimaryKey(Integer messageId);

    int updateMessageByPrimaryKeySelective(Message record);

    int updateMessageByPrimaryKey(Message record);

    List<Message> selectMessageByUserId(Integer id);
}
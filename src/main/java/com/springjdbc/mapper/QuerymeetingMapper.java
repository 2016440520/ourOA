package com.springjdbc.mapper;

import com.springjdbc.pojo.Querymeeting;

public interface QuerymeetingMapper {
    int deleteQuerymeetingByPrimaryKey(Integer id);

    int insertQuerymeeting(Querymeeting record);

    int insertQuerymeetingSelective(Querymeeting record);

    Querymeeting selectQuerymeetingByPrimaryKey(Integer id);

    int updateQuerymeetingByPrimaryKeySelective(Querymeeting record);

    int updateQuerymeetingByPrimaryKey(Querymeeting record);
}
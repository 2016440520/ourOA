package com.springjdbc.mapper;

import com.springjdbc.pojo.Book;

import java.util.List;

public interface BookMapper {
    int deleteBookByPrimaryKey(Integer bookId);

    int insertBook(Book record);

    int insertBookSelective(Book record);

    Book selectBookByPrimaryKey(Integer bookId);

    List<Book> selectBookByRoomId(Integer id);

    int updateBookByPrimaryKeySelective(Book record);

    int updateBookByPrimaryKey(Book record);
}
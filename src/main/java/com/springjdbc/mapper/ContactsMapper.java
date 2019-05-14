package com.springjdbc.mapper;

import com.springjdbc.pojo.Contacts;

import java.util.List;
public interface ContactsMapper {
    List<Contacts> findAllContacts(Integer id);

    int insert(Contacts contacts);

    int delete(int c_id);

    int update(Contacts contacts);
}

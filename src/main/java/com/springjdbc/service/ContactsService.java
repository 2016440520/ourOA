package com.springjdbc.service;

import com.springjdbc.pojo.Contacts;

import java.util.List;

public interface ContactsService {
    List<Contacts> queryAll(Integer id);

    int save(Contacts contacts);

    int deleteContactsByid(Integer c_id);

    int updateContacts(Contacts contacts);
}

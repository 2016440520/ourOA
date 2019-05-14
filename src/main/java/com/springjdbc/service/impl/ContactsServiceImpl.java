package com.springjdbc.service.impl;

import com.springjdbc.mapper.ContactsMapper;
import com.springjdbc.pojo.Contacts;
import com.springjdbc.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public int save(Contacts contacts) {
        return contactsMapper.insert(contacts);
    }

    @Override
    public int updateContacts(Contacts contacts) {
        return contactsMapper.update(contacts);
    }

    @Override
    public int deleteContactsByid(Integer c_id) {
        return contactsMapper.delete(c_id);
    }


    @Override
    public List<Contacts> queryAll(Integer id) {

        return contactsMapper.findAllContacts(id);
    }
}

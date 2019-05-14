package com.springjdbc.controller;

import com.springjdbc.Response.CommonReturnType;
import com.springjdbc.annotation.SystemControllerLog;
import com.springjdbc.pojo.Contacts;
import com.springjdbc.pojo.User;
import com.springjdbc.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @GetMapping("/contacts/query")
    @SystemControllerLog(description = "查询所有联系人")
    public String queryAll( Model model,@ModelAttribute("user") User user){
       List<Contacts> contactsList = contactsService.queryAll(user.getUserId());
       model.addAttribute("contactsList",contactsList);
       return contactsList.toString();//返回联系人列表
    }


    //添加联系人
    @PostMapping("/contacts")
    @SystemControllerLog(description = "添加联系人")
    public CommonReturnType addContacts(Contacts contacts){
        int row = contactsService.save(contacts);
        return CommonReturnType.create(row);//返回联系人列表
    }

    //删除联系人
    @DeleteMapping("/contacts/{c_id}")
    @SystemControllerLog(description = "删除联系人")
    public CommonReturnType deleteContactsById(@PathVariable("c_id") Integer c_id){
        int row = contactsService.deleteContactsByid(c_id);
        return CommonReturnType.create(row);//返回联系人列表
    }

    //更新联系人
    @PutMapping("/contacts")
    @SystemControllerLog(description = "更新联系人")
    public CommonReturnType updateContacts(Contacts contacts){
        int row = contactsService.updateContacts(contacts);
        return CommonReturnType.create(row);
    }

}

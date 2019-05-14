package com.springjdbc.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springjdbc.mapper.BookMapper;
import com.springjdbc.pojo.*;
import com.springjdbc.service.PermissionService;
import com.springjdbc.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @Autowired
    PermissionService permissionService;


    @RequestMapping(value = "/login")
    @ResponseBody
    public List<Permission> login(@RequestParam("username") String username, @RequestParam("password") String password ) {

        // 获取subject
        Subject subject = SecurityUtils.getSubject();

        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //Map<String ,Object > resMap = new LinkedHashMap<>();
        //resMap.put("res_code","000");
        //resMap.put("res_msg","success");
        try {
            // 执行登录方法
            subject.login(token);

            User user = (User)subject.getPrincipal();

            // 获取用户菜单

            List<Permission> permissions = permissionService.getPermissionByUserName(user.getUsername());

            // 合并菜单
            List<Permission> mergedPermissions = new ArrayList<>();



            // 一级菜单直接放入mergedMenus
            for(Permission permission :permissions) {
                if(permission.getParent().equals("0")) {
                    System.out.println(permission);
                    mergedPermissions.add(permission);
                }
            }
//             二级菜单放在一级菜单下
            for(Permission permission:permissions) {
                if(permission.getParent()!=null) {
                    System.out.println(permission.getParent());
                    for(Permission mergedPermission:mergedPermissions) {
                        // 找到父菜单
                        if(String.valueOf(mergedPermission.getId()).equals(permission.getParent())) {
                            // 如果父节点没有子节点List就创建一个
                            List<Permission> childPermissions;
                            if (mergedPermission.getChildren() == null) {
                                childPermissions = new ArrayList<>();
                            } else {
                                childPermissions = mergedPermission.getChildren();
                            }
                            childPermissions.add(permission);
                            mergedPermission.setChildren(childPermissions);
                            break;
                        }
                    }
                }
            }
            System.out.println(mergedPermissions);
            return mergedPermissions;

        } catch (UnknownAccountException e) {
            List<Permission> mergedMenus = new ArrayList<>();
            Permission menu = new Permission();
            menu.setMsg("用户不存在");
            mergedMenus.add(menu);
            return mergedMenus;
        } catch (IncorrectCredentialsException e) {
            List<Permission> mergedMenus = new ArrayList<>();
            Permission menu = new Permission();
            menu.setMsg("密码错误");
            mergedMenus.add(menu);
            return mergedMenus;
            //resMap.put("res_code","002");
            //resMap.put("res_msg","Error");
            //resMap.put("res_body","");
            //return resMap;
        }

    }

    @RequestMapping(value = "/loginOut")
    public void loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @RequestMapping("/testLogin")
    public String testSelect() {
        return "testLogin";
    }

    /**
     * 未登录就请求其他url
     */
    @RequestMapping("/needLogin")
    public Map needLogin() {
        HashMap<String,Object> info = new HashMap<>();
        info.put("info","you need login");
        return info;
    }

    /**
     * 未授权
     */
    @RequestMapping("/noAuth")
    public Map<String, Object> noAuth() {
        HashMap<String,Object> info = new HashMap<>();
        info.put("info","you have no auth");
        return info;
    }

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.selectUserByPrimaryKey(id);
    }

    /**
     * 通过用户名获取用户
     * @return
     */
    @GetMapping("/getUserByname")
    public User getUser(@RequestParam("username") String username) {
        return userService.selectUserByUsername(username);
    }

    @RequestMapping(value = "/isUserExist",method = RequestMethod.POST)
    public Map<String, Object> isUserExist(@RequestBody Map<String,Object> object) {
        Map<String, Object> map = new HashMap<>();
        String username = object.get("username").toString();
        if(userService.selectUserByUsername(username) == null) {
            map.put("msg",false);
            return map;
        }
        map.put("msg",true);

        return map;
    }


    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public int updateUserPassword(@RequestBody User user) {
        return userService.updateUserByPrimaryKeySelective(user);
    }

    /**
     * 发送邮件
     * @param
     */
    //@GetMapping("/sendEmail")
    @RequestMapping(value = "/sendEmail",method = RequestMethod.GET)
    public boolean sendEmail(@RequestParam("username") String  username) {
          System.out.println(username);
        userService.sendEmail(username);
        return true;
    }

    /**
     * 验证邮件中的验证码
     * @param
     * @return
     */
    @GetMapping("/validate")
    public boolean validate(@RequestParam("code") String code) {
        return userService.validate(code);
    }

    /**
     * 修改用户密码
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    //@PostMapping("/updatePassword")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public boolean updateUserPassword(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("newPassword") String newPassword) {
        return userService.updateUserPassword(username,password,newPassword);
    }

//    @PostMapping("/findPassword")
    @RequestMapping(value = "/findPassword",method = RequestMethod.POST)
    public boolean findUserPassword(@RequestParam("username") String username,
                                      @RequestParam("newPassword") String newPassword) {
        return userService.findUserPassword(username,newPassword);
    }



    /**
     * 删除消息
     * @param id
     * @return
     */
    @DeleteMapping("/message/{id}")
    public int deleteMessageByPrimaryKey(@PathVariable("id") Integer id) {
        return userService.deleteMessageByPrimaryKey(id);
    }

    /**
     * 增加消息
     * @param message
     * @return
     */
//    @PostMapping("/message")
//    public int insertMessage(@RequestBody Message message) {
//        return userService.insertMessage(message);
//    }
    /**
     * 增加消息
     * @param message
     * @return
     */
    @PostMapping("/message")
    public int insertMessage(@RequestBody Message message) {
        return userService.insertMessageSelective(message);
    }

    /**
     * 查询消息
     * @param messageId
     * @return
     */
    @GetMapping("/message/{id}")
    public Message selectMessageByPrimaryKey(@PathVariable("id") Integer messageId) {
        return userService.selectMessageByPrimaryKey(messageId);
    }

    /**
     * 修改消息
     * @param message
     * @return
     */
    @PutMapping("/message")
    public int updateMessage(@RequestBody Message message) {
        return userService.updateMessageByPrimaryKeySelective(message);
    }

    /**
     * 查询会议
     * @param id
     * @return
     */
    @GetMapping("/meeting/{id}")
    public Meeting gettMeeting(@PathVariable("id") Integer id) {
        return userService.selectMeetingByPrimaryKey(id);
    }

    /**
     * 查询会议室
     * @param id
     * @return
     */
    @GetMapping("/meetingRoom/{id}")
    public MeetingRoom getMeetingRoom(@PathVariable("id") Integer id) {
        return userService.selectMeetingRoomByPrimaryKey(id);
    }
    //获取用户的消息
    @GetMapping("/getUserMsg")
    public List<Message> getMessageByUserId(@RequestParam("id") Integer id) {
        return userService.selectMessageByUserId(id);
    }

    @Autowired
    BookMapper bookMapper;

    @GetMapping("/getBooks")
    public List<Book> getBook(@RequestParam("id") Integer id) {
        return bookMapper.selectBookByRoomId(id);
    }

    @GetMapping("/getNotice")
    public List<Notice> getNotices() {
        return userService.getAllNotice();
    }

    @PostMapping("/insertNotice")
    public int insertNotice(@RequestBody Notice notice) {
        return userService.insertNoticeSelective(notice);
    }

    @DeleteMapping("/deleteNotice/{id}")
    public int deleteNotice(@PathVariable Integer id) {
        return userService.deleteNoticeByPrimaryKey(id);
    }

}

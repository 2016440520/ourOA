package com.springjdbc.controller;

import com.springjdbc.pojo.Meeting;
import com.springjdbc.pojo.MeetingRoom;
import com.springjdbc.pojo.User;
import com.springjdbc.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl adminService;

    /**
     * 获取所有用户
     * @return
     */
//    @GetMapping("/users")
//    public Map<String,List<User>> getAllUser() {
//        Map<String,List<User>> map = new HashMap<>();
//        map.put("users",adminService.getAllUser());
//        return map;
//    }
    @GetMapping("/users")
    public List<User> getAllUser() {
        return adminService.getAllUser();
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
//    @PostMapping("/user")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        return adminService.insertUser(user);
    }

    /**
     * 通过ID删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public int deleteUser(@PathVariable("id") Integer id) {
        return adminService.deleteUser(id);
    }

    /**
     * 通过ID删除会议室
     * @param id
     * @return
     */
    @DeleteMapping("/meetingRoom/{id}")
    public int deleteMeetingRoom(@PathVariable("id") Integer id){
        return adminService.deleteMeetingRoom(id);
    }

    /**
     * 增加会议室
     * @param meetingRoom
     * @return
     */
    @PostMapping("/meetingRoom")
    public int insertMeetingRoom(MeetingRoom meetingRoom){
        return adminService.insertMeetingRoom(meetingRoom);
    }

    /**
     * 修改会议室
     * @param meetingRoom
     * @return
     */
    @PutMapping("meetingRoom")
    public int updateMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        return adminService.updateMeetingRoom(meetingRoom);
    }

    /**
     * 删除会议
     * @param id
     * @return
     */
    @DeleteMapping("/meeting/{id}")
    public int deleteMeeting(@PathVariable("id") Integer id){
        return adminService.deleteMeeting(id);
    }

    /**
     * 增加会议
     * @param meeting
     * @return
     */
    @PostMapping("meeting")
    public int insertMeeting(@RequestBody Meeting meeting){
        return adminService.insertMeeting(meeting);
    }

    /**
     * 修改会议
     * @param meeting
     * @return
     */
    @PutMapping("meeting")
    public int updateMeeting(@RequestBody Meeting meeting){
        return adminService.updateMeeting(meeting);
    }
}

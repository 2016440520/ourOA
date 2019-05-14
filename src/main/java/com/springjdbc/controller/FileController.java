package com.springjdbc.controller;

import com.springjdbc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/file/upLoad")
    @ResponseBody
    public String upLoad(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        return fileService.upLoad(file);
    }

    @GetMapping("/file/downLoad")
    @ResponseBody
    public String downLoad(HttpServletResponse response, @RequestParam("id") Integer id){
       return fileService.downLoad(response,id);
    }
}

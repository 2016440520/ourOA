package com.springjdbc.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    String upLoad(MultipartFile file);

    String downLoad(HttpServletResponse response, Integer id);
}

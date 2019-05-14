package com.springjdbc.mapper;

import com.springjdbc.pojo.File;

public interface FileMapper {
    void save(File biaopath);

    File selectById(Integer id);
}

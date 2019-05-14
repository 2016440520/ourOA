package com.springjdbc.service.impl;

import com.springjdbc.mapper.FileMapper;
import com.springjdbc.pojo.File;
import com.springjdbc.service.FileService;
import com.springjdbc.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    public String upLoad(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
        if (file != null) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";

            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            File biaopath = new File();
            biaopath.setPath("http://localhost:8081/" + fileName);
            biaopath.setFileUploader("admin");
            biaopath.setFileName(fileName);
            System.out.println(biaopath);
            fileMapper.save(biaopath);
        }
        return "success";
    }

    @Override
    public String downLoad(HttpServletResponse response, Integer id) {
        File file = fileMapper.selectById(id);
        return file.getPath();
//        String fileName = file.getFileName();
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new java.io.File(path +fileName));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        //如果文件不存在
//        if (inputStream == null) {
//            return "文件不存在";
//        }
//        response.setHeader("content-type", "application/octet-stream");
//        response.setContentType("application/octet-stream");
//        try {
//            String name = java.net.URLEncoder.encode(fileName, "UTF-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + name);
//        } catch (UnsupportedEncodingException e2) {
//            e2.printStackTrace();
//        }
//        byte[] buff = new byte[1024];
//        BufferedInputStream bis = null;
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            bis = new BufferedInputStream(new FileInputStream(new java.io.File(path + fileName)));
//            int i = bis.read(buff);
//            while (i != -1) {
//                os.write(buff, 0, buff.length);
//                os.flush();
//                i = bis.read(buff);
//            }
//        } catch (FileNotFoundException e1) {
//            //e1.getMessage()+"系统找不到指定的文件";
//            System.out.println(e1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return "success";
//    }
    }
}

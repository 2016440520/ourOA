package com.springjdbc.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Program：mizhi
 * @Description：在线编辑器文件上传下载工具类
 * @Author：LearnLi
 * @Create:2018-11-23 23:53
 */

@Controller
public class FileUtil1 {

    @RequestMapping("/uploadArticle")
    @ResponseBody
    public Map<String, Object> uploadArticleImg(
            @RequestParam MultipartFile file,  //这样接收文件
            @RequestParam Map<String, String> params,
            HttpServletRequest request
    ) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {

            Map<String, String> name = uploadFile( file, request);
            ret.put("link", "http://" + request.getServerName() //服务器地址
                    + ":"
                    + request.getServerPort() + name.get("saveName"));
            // 返回前台
            System.out.println("返回的地址： " + ret.get("link"));
            System.out.println("接受的请求：" + request);
            return ret;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *
     * @param file：前台接受的文件
     * @param request：请求
     * @return
     * @throws IOException
     */
    public Map<String, String> uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> result = new HashMap<String, String>();//新建结果接受，用于返回结果。
        String fileName = file.getOriginalFilename();//获取原型文件名称
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();//文件后缀
        String saveName = String.valueOf((new Date()).getTime()).substring(8) + (int) ((Math.random() * 999 + 1)) + '.' + fileType;
        String path=createdic(request,fileType);
        File tempFile = new File(path, String.valueOf(saveName));
        System.out.println("文件：" + tempFile);
        file.transferTo(tempFile);
        System.out.println("修改之后的原型名称：" + file.getOriginalFilename());
        result.put("fileName", fileName);
        result.put("saveName", fileName(tempFile.toString()));
        return result;
    }
    //创建，分配文件夹
    public String createdic( HttpServletRequest request,String filetype){
        //暂时设置
        String path="";
        path=request.getSession().getServletContext().getRealPath("temp");
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        if(filetype.equals("jpg")){
            path="/img/";
        }else if (filetype.equals("mp4")){
            path="/video/";
        }else{
        path="/file/";
        }
        path=request.getSession().getServletContext().getRealPath("temp")+path;
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        return path;

    }
    public String fileName(String path){
        StringBuffer sb=new StringBuffer(path);
        int index=sb.indexOf("webapp")+6;
        String res=sb.substring(index);
        return res;
    }

}

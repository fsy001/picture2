package com.fusanyong.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class pictureC {
    @RequestMapping("/hello")
    public String lujing(){

        return "index";
    }
    @GetMapping("/zhanshi")
    public String pictureTest(Map map){
        map.put("src","picture/tupian2.jpg");
        return "index";
    }
    @PostMapping("/upload")
    public String upload( MultipartFile file,Map map){
        String ofn = file.getOriginalFilename();
       String zhuomian ="/Users/a243931608/aaa/";
        File file1 = new File(zhuomian);
        String absolutePath = file1.getAbsolutePath();
        String filename =absolutePath+"/"+ofn;
        File dest = new File(filename);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();// 新建文件夹
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ofn);
        System.out.println(file);
        map.put("srca","aaa/"+ofn);
        return "index";
    }
}
//注意事项
//1、需要配置路径映射，理解/**通配符含义
//2、需要创建目录需要用 mkdirs方法
//3、Mac需要获取绝对路径
//4、注意把路径转化成文件的方法
//5、绝对路径和文件名之间要拥"/"
//6、准确理解操作系统的根路径 Mac 最少要到用户

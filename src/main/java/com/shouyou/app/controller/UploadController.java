package com.shouyou.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shouyou.app.entity.ExecuteResult;
import com.shouyou.app.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 01436296 on 2017/6/14.
 */
@RestController
@RequestMapping(value = "/app/upload")
public class UploadController {
    @Autowired
    HttpUtils httpUtils;
    @RequestMapping(value = "/upload")
    public ExecuteResult upload(@RequestParam("file") MultipartFile [] files){
        JSONArray jsonArray = new JSONArray();
        for(MultipartFile file : files){
            String re = httpUtils.uploadFile(file);
            if(re!=null){
                jsonArray.add(JSON.parse(re));
            }else{
                return new ExecuteResult(0,"error");
            }
        }
        return new ExecuteResult(1,jsonArray.toString());
    }
}

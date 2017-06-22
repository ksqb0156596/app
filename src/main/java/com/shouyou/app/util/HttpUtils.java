package com.shouyou.app.util;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.shouyou.app.entity.ExecuteResult;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 01436296 on 2017/6/14.
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class HttpUtils {
    private String accessKey;
    private String secretKey;
    private String bucketName;

    public String uploadFile(MultipartFile file){
        Zone z = Zone.zone2();
        Configuration c = new Configuration(z);
        UploadManager uploadManager = new UploadManager(c);
        Auth auth = Auth.create(accessKey, secretKey);
        String token = auth.uploadToken(bucketName);
        try {
            Response r = uploadManager.put(file.getBytes(),UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")) , token);
            if(r.isOK()){
                return r.bodyString();
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}

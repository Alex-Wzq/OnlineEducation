package com.suda.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.suda.oss.service.OssService;
import com.suda.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。

        String url = null;
        try {
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();

            // 1. 文件名+uuid, 以防覆盖
            String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");
            filename = uuid + filename;

            // 2. 根据日期分类文件
            String datePath = new DateTime().toString("yyyy/MM/dd");
            filename = datePath + "/" + filename;

            ossClient.putObject(ConstantPropertiesUtils.BUCKET_NAME, filename, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //  https://edu-suda.oss-cn-shanghai.aliyuncs.com/1.jpeg
            url = "https://"+bucketName+"."+endpoint+"/"+filename;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }
}

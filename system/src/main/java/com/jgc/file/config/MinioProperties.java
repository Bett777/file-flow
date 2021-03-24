package com.jgc.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Minio配置</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 14:27
 **/
@Component
@ConfigurationProperties(prefix = "spring.minio")
public class MinioProperties {
    private String url;
    private String accessKey;
    private String secretKey;
    private String bucketImage;
    private String bucketDoc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getBucketImage() {
        return bucketImage;
    }

    public void setBucketImage(String bucketImage) {
        this.bucketImage = bucketImage;
    }

    public String getBucketDoc() {
        return bucketDoc;
    }

    public void setBucketDoc(String bucketDoc) {
        this.bucketDoc = bucketDoc;
    }

    @Override
    public String toString() {
        return "MinioProperties{" +
                "url='" + url + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", bucketImage='" + bucketImage + '\'' +
                ", bucketDoc='" + bucketDoc + '\'' +
                '}';
    }
}

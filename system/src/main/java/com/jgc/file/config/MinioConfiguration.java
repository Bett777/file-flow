package com.jgc.file.config;

import io.minio.MinioClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * <p>MinIo配置类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/23 16:04
 **/
@Configuration
@ConditionalOnClass({MinioClient.class})
@EnableConfigurationProperties({MinioProperties.class})
public class MinioConfiguration {
    @Resource
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(minioProperties.getUrl())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
    }
}

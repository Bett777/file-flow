package com.jgc.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>*</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 22:15
 **/
@SpringBootApplication(scanBasePackages = {"com.jgc"})
public class FileFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileFlowApplication.class, args);
    }
}

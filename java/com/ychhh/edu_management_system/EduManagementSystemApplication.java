package com.ychhh.edu_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class EduManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduManagementSystemApplication.class, args);
    }

}

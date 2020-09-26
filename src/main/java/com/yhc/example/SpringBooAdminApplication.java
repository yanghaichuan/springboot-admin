package com.yhc.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.yhc.example.domain.mapper","com.yhc.example.**.mapper"})
public class SpringBooAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBooAdminApplication.class, args);
    }

}

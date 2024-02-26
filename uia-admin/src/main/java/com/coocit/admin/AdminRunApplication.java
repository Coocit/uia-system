package com.coocit.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@SpringBootApplication
@MapperScan("com.coocit.admin.repository")
@EnableTransactionManagement
public class AdminRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminRunApplication.class, args);
    }

}

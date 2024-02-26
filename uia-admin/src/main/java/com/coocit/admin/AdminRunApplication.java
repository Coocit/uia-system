package com.coocit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(value = "com.coocit.admin.repository")
@EntityScan("com.coocit.admin.model.entity")
public class AdminRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminRunApplication.class, args);
    }

}

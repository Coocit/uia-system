package com.coocit.admin.service;

import com.coocit.admin.model.dto.LoginDTO;
import com.coocit.admin.model.response.LoginResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@SpringBootTest
public class AuthServiceTest {

    @Resource
    private AuthService authService;

    @Test
    public void loginTest(){
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("admin");
        loginDTO.setPassword("123456");
        LoginResult result = authService.login(loginDTO);
        System.out.println(result);

    }
}

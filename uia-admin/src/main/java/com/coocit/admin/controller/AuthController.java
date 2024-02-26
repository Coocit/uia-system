package com.coocit.admin.controller;

import com.coocit.admin.model.dto.LoginDTO;
import com.coocit.admin.model.response.LoginResult;
import com.coocit.admin.service.AuthService;
import com.coocit.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public Result<LoginResult> login(@RequestBody LoginDTO loginDTO) {
        LoginResult loginResult = authService.login(loginDTO);
        return Result.success(loginResult);
    }



}

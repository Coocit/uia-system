package com.coocit.admin.service.impl;

import com.coocit.admin.model.dto.LoginDTO;
import com.coocit.admin.model.response.LoginResult;
import com.coocit.admin.service.AuthService;
import com.coocit.common.utils.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResult login(LoginDTO loginDTO) {
        // 生成token
        Map<String, String> map = new HashMap<>();
        map.put("username", loginDTO.getUsername());
        String accessToken = JWTUtil.getToken(map, "123456");
        return LoginResult.builder()
                .tokenType("Bearer")
                .accessToken(accessToken)
                .build();
    }
}

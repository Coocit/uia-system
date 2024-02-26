package com.coocit.admin.service;

import com.coocit.admin.model.dto.LoginDTO;
import com.coocit.admin.model.response.LoginResult;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */

public interface AuthService {

    LoginResult login(LoginDTO loginDTO);

}

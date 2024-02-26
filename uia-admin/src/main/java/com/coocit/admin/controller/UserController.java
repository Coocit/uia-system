package com.coocit.admin.controller;

import com.coocit.admin.model.vo.UserInfoVo;
import com.coocit.admin.service.UserService;
import com.coocit.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/me")
    public Result<UserInfoVo> getUserInfo() {
        UserInfoVo userInfoVo = userService.getUserInfo();
        return Result.success(userInfoVo);
    }
}

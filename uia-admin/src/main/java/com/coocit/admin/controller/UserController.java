package com.coocit.admin.controller;

import com.coocit.admin.model.dto.UserDTO;
import com.coocit.admin.model.dto.UserForm;
import com.coocit.admin.model.vo.UserInfoVo;
import com.coocit.admin.model.vo.UserVo;
import com.coocit.admin.service.UserService;
import com.coocit.common.response.PageResult;
import com.coocit.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/page")
    public Result<PageResult<UserVo>> page(@RequestBody UserDTO userDTO) {
        userDTO.fillPage();
        return Result.success(userService.findUserPage(userDTO));
    }

    @PostMapping("/add")
    public Result<Long> add(@RequestBody UserForm userForm) {
        return Result.success(userService.add(userForm));
    }

}

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

    /**
     * 获取用户信息
     *
     * @return {@link Result}<{@link UserInfoVo}>
     */
    @GetMapping("/me")
    public Result<UserInfoVo> getUserInfo() {
        UserInfoVo userInfoVo = userService.getUserInfo();
        return Result.success(userInfoVo);
    }

    /**
     * 用户分页查询
     *
     * @param userDTO 用户dto
     * @return {@link Result}<{@link PageResult}<{@link UserVo}>>
     */
    @PostMapping("/page")
    public Result<PageResult<UserVo>> page(@RequestBody UserDTO userDTO) {
        userDTO.fillPage();
        return Result.success(userService.findUserPage(userDTO));
    }

    /**
     * 用户新增
     *
     * @param userForm 用户表单
     * @return {@link Result}<{@link Long}>
     */
    @PostMapping("/add")
    public Result<Long> add(@RequestBody UserForm userForm) {
        return Result.success(userService.add(userForm));
    }

    /**
     * 用户id查询
     *
     * @param id 身份证件
     * @return {@link Result}<{@link UserForm}>
     */
    @PostMapping("{id}")
    public Result<UserForm> detail(@PathVariable Long id) {
        return Result.success(userService.findUserById(id));
    }

    /**
     * 用户id修改
     *
     * @param id       身份证件
     * @param userForm 用户表单
     * @return {@link Result}<{@link Long}>
     */
    @PostMapping("/{id}/update")
    public Result<Long> update(@PathVariable Long id, @RequestBody UserForm userForm) {
        return Result.success(userService.modifyUserById(id, userForm));
    }

    // TODO 用户删除接口

    // TODO 用户重置密码接口

}

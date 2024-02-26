package com.coocit.admin.service;

import com.coocit.admin.model.dto.UserDTO;
import com.coocit.admin.model.dto.UserForm;
import com.coocit.admin.model.vo.UserInfoVo;
import com.coocit.admin.model.vo.UserVo;
import com.coocit.common.response.PageResult;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
public interface UserService {

    UserInfoVo getUserInfo();

    PageResult<UserVo> findUserPage(UserDTO userDTO);

    Long add(UserForm userForm);

    UserForm findUserById(Long id);

    Long modifyUserById(Long id, UserForm userForm);
}

package com.coocit.admin.service.impl;
import com.coocit.admin.model.vo.UserInfoVo;
import com.coocit.admin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfoVo getUserInfo() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(1000L);
        userInfoVo.setNickname("Coocit");
        userInfoVo.setAvatar("null");
        Set<String> roles = new HashSet<>();
        roles.add("ROOT");
        userInfoVo.setRoles(roles);
        HashSet<String> perms = new HashSet<>();
        userInfoVo.setPerms(perms);
        return userInfoVo;
    }

}

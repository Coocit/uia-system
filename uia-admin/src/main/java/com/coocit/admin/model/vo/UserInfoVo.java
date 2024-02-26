package com.coocit.admin.model.vo;

import lombok.Data;

import java.util.Set;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
public class UserInfoVo {

    private Long userId;

    private String nickname;

    private String avatar;

    private Set<String> roles;

    private Set<String>perms;

}

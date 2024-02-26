package com.coocit.admin.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
@TableName("tb_user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer gender;

    private String password;

    private String email;

    private String mobile;

    private String avatar;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private List<Organization> organizationList;
}

package com.coocit.admin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
@TableName("tb_user_org")
@Builder
public class UserOrg implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long orgId;

}

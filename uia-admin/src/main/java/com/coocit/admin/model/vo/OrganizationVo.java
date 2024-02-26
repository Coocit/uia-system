package com.coocit.admin.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
public class OrganizationVo {

    @JsonSerialize(using = ToStringSerializer.class)
    // 分布式ID 会有精度损失问题 转成string类型
    private Long id;

    private String name;

    private String code;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private Long sort;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private List<OrganizationVo> children;

}

package com.coocit.admin.model.vo;

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

    private Long id;

    private String name;

    private String code;

    private Long parentId;

    private Long sort;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private List<OrganizationVo> children;

}

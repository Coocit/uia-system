package com.coocit.admin.model.dto;

import lombok.Data;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
public class OrganizationDTO {

    private Integer pageNum;

    private Integer pageSize;

    private String keywords;

    private Integer status;

}

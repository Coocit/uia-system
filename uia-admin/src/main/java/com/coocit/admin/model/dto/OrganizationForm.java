package com.coocit.admin.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
public class OrganizationForm {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private String code;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private Long sort;

    private Integer status;

}

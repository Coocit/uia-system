package com.coocit.admin.model.dto;

import com.coocit.admin.model.serialize.ListLongToStringArrayJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
public class UserForm {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private Integer gender;

    private String email;

    private String mobile;

    private String avatar;

    private Integer status;

    @JsonSerialize(using = ListLongToStringArrayJsonSerializer.class)
    private List<Long> orgIds;

}

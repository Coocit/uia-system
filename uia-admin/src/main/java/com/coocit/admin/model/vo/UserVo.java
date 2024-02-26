package com.coocit.admin.model.vo;

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
public class UserVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private Integer gender;

    private String email;

    private String mobile;

    private String avatar;

    private Integer status;

    private String createTime;

    private List<String> orgNames;

}

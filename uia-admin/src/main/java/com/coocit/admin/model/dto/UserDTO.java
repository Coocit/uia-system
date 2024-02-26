package com.coocit.admin.model.dto;

import lombok.Data;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
public class UserDTO {

    private String keywords;

    private Integer status;

    private Long orgId;

    private Integer pageNum;

    private Integer pageSize;

    public void fillPage() {
        if (this.pageNum == null){
            this.pageNum = 1;
        }
        if (this.pageSize == null){
            this.pageSize = 10;
        }
    }

}

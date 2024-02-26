package com.coocit.admin.model.convert;

import com.coocit.admin.model.dto.UserForm;
import com.coocit.admin.model.entity.User;
import com.coocit.admin.model.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Mapper(componentModel = "Spring")
public interface UserConvert {

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVo toVO(User user);

    User toEntity(UserForm userForm);

    UserForm toForm(User user);

}

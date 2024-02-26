package com.coocit.admin.model.convert;

import com.coocit.admin.model.dto.OrganizationForm;
import com.coocit.admin.model.entity.Organization;
import com.coocit.admin.model.vo.OrganizationVo;
import org.mapstruct.Mapper;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Mapper(componentModel = "Spring")
public interface OrganizationConvert {

    OrganizationVo toVO(Organization org);

    Organization toEntity(OrganizationForm form);

    OrganizationForm toForm(Organization org);

}

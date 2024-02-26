package com.coocit.admin.service;

import com.coocit.admin.model.dto.OrganizationDTO;
import com.coocit.admin.model.dto.OrganizationForm;
import com.coocit.admin.model.vo.OrganizationVo;
import com.coocit.common.model.Option;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
public interface OrganizationService {

    List<OrganizationVo> listOrganization(OrganizationDTO org);

    List<Option<String>> listOptions();

    Long add(OrganizationForm organizationForm);

    OrganizationForm  findOrgDetailById(Long id);

    Long modifyOrg(Long id, OrganizationForm organizationForm);
}

package com.coocit.admin.service;

import com.coocit.admin.model.dto.OrganizationDTO;
import com.coocit.admin.model.vo.OrganizationVo;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
public interface OrganizationService {

    List<OrganizationVo> listOrganization(OrganizationDTO org);

}

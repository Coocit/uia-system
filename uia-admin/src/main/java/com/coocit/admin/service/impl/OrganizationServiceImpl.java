package com.coocit.admin.service.impl;

import com.coocit.admin.model.convert.OrganizationConvert;
import com.coocit.admin.model.dto.OrganizationDTO;
import com.coocit.admin.model.entity.Organization;
import com.coocit.admin.model.vo.OrganizationVo;
import com.coocit.admin.repository.OrganizationRepository;
import com.coocit.admin.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationConvert organizationConvert;

    private final Long ROOT = 0L;

    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public List<OrganizationVo> listOrganization(OrganizationDTO org) {
        List<Organization> organizationList = organizationRepository.findAll(Sort.by(Sort.Order.asc("sort")));
        // 组织为一个树形结构
        return toTreeList(ROOT, organizationList);
    }

    private List<OrganizationVo> toTreeList(Long parentId, List<Organization> organizationList) {
        return organizationList.stream()
                .filter(organization -> organization.getParentId().equals(parentId))
                .map(organization -> {
                    OrganizationVo organizationVo = organizationConvert.toVO(organization);
                    organizationVo.setChildren(toTreeList(organization.getId(), organizationList));
                    return organizationVo;
                }).collect(Collectors.toList());
    }
}

package com.coocit.admin.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coocit.admin.model.convert.OrganizationConvert;
import com.coocit.admin.model.dto.OrganizationDTO;
import com.coocit.admin.model.entity.Organization;
import com.coocit.admin.model.vo.OrganizationVo;
import com.coocit.admin.repository.OrganizationRepository;
import com.coocit.admin.service.OrganizationService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
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
public class OrganizationServiceImpl extends ServiceImpl<OrganizationRepository,Organization> implements OrganizationService {

    private final OrganizationConvert organizationConvert;

    private final Long ROOT = 0L;

    @Resource
    private OrganizationRepository organizationRepository;


    @Override
    public List<OrganizationVo> listOrganization(OrganizationDTO org) {
        LambdaQueryWrapper<Organization> queryWrapper = Wrappers.lambdaQuery();
        if (org != null) {
            if (CharSequenceUtil.isNotBlank(org.getKeywords())) {
                queryWrapper.like(Organization::getName, org.getKeywords());
            }
            if (org.getStatus() != null) {
                queryWrapper.eq(Organization::getStatus, org.getStatus());
            }
        }
        List<Organization> organizationList = this.list(queryWrapper);
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

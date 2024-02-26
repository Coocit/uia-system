package com.coocit.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
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
import com.coocit.common.model.Option;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl extends ServiceImpl<OrganizationRepository, Organization> implements OrganizationService {

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
        queryWrapper.orderByAsc(Organization::getSort);
        List<Organization> organizationList = this.list(queryWrapper);
        // 搜索出来的结果 节点不一定是从root 顶级节点开始
        // 找出目前真正的 根节点
        Set<Long> parentIds = organizationList.stream().map(Organization::getParentId).collect(Collectors.toSet());
        Set<Long> ids = organizationList.stream().map(Organization::getId).collect(Collectors.toSet());
        List<Long> rootIds = CollUtil.subtractToList(parentIds, ids);
        List<OrganizationVo> organizationVOList = new ArrayList<>();
        for (Long rootId : rootIds) {
            organizationVOList.addAll(toTreeList(rootId, organizationList));
        }
        return organizationVOList;
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

    @Override
    public List<Option<String>> listOptions() {
        LambdaQueryWrapper<Organization> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByAsc(Organization::getSort);
        List<Organization> organizationList = this.list(queryWrapper);
        return toTreeOptionList(ROOT, organizationList);
    }

    private List<Option<String>> toTreeOptionList(Long parentId, List<Organization> all) {
        return all.stream().
                filter(organization -> organization.getParentId().equals(parentId)).
                map(organization -> {
                    Option<String> option = new Option<>(organization.getId().toString(), organization.getName(), null);
                    option.setChildren(toTreeOptionList(organization.getId(), all));
                    return option;
                }).toList();
    }


}

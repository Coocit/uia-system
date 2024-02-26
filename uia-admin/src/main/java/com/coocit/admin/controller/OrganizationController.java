package com.coocit.admin.controller;

import com.coocit.admin.model.dto.OrganizationDTO;
import com.coocit.admin.model.dto.OrganizationForm;
import com.coocit.admin.model.vo.OrganizationVo;
import com.coocit.admin.service.OrganizationService;
import com.coocit.common.model.Option;
import com.coocit.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@RestController
@RequestMapping("/v1/org")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 组织列表
     *
     * @param org org
     * @return {@link Result}<{@link List}<{@link OrganizationVo}>>
     */
    @PostMapping("/list")
    public Result<List<OrganizationVo>> listOrganization(@RequestBody(required = false) OrganizationDTO org){
        return Result.success(organizationService.listOrganization(org));
    }

    /**
     * 组织选项
     *
     * @return {@link Result}<{@link List}<{@link Option}<{@link String}>>>
     */
    @PostMapping("/options")
    public Result<List<Option<String>>> options(){
        return Result.success(organizationService.listOptions());
    }

    /**
     * 组织新增
     *
     * @param organizationForm 组织形式
     * @return {@link Result}<{@link Long}>
     */
    @PostMapping("/add")
    public Result<Long> add(@RequestBody OrganizationForm organizationForm){
        return Result.success(organizationService.add(organizationForm));
    }

    /**
     * 组织id查询
     *
     * @param id 身份证件
     * @return {@link Result}<{@link OrganizationForm}>
     */
    @PostMapping("{id}")
    public Result<OrganizationForm> detail(@PathVariable Long id){
        return Result.success(organizationService.findOrgDetailById(id));
    }

    /**
     * 组织id修改
     *
     * @param id   身份证件
     * @param form 类型
     * @return {@link Result}<{@link Long}>
     */
    @PostMapping("{id}/update")
    public Result<Long> update(@PathVariable Long id, @RequestBody OrganizationForm form){
        return Result.success(organizationService.modifyOrg(id,form));
    }

    // TODO 组织删除接口



}

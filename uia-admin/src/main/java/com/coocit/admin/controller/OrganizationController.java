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

    @PostMapping("/list")
    public Result<List<OrganizationVo>> listOrganization(@RequestBody(required = false) OrganizationDTO org){
        return Result.success(organizationService.listOrganization(org));
    }

    @PostMapping("/options")
    public Result<List<Option<String>>> options(){
        return Result.success(organizationService.listOptions());
    }

    @PostMapping("/add")
    public Result<Long> add(@RequestBody OrganizationForm organizationForm){
        return Result.success(organizationService.add(organizationForm));
    }

    @PostMapping("{id}")
    public Result<OrganizationForm> detail(@PathVariable Long id){
        return Result.success(organizationService.findOrgDetailById(id));
    }

    @PostMapping("{id}/update")
    public Result<Long> update(@PathVariable Long id, @RequestBody OrganizationForm form){
        return Result.success(organizationService.modifyOrg(id,form));
    }



}

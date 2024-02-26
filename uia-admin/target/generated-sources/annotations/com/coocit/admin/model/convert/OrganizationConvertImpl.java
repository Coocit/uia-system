package com.coocit.admin.model.convert;

import com.coocit.admin.model.dto.OrganizationForm;
import com.coocit.admin.model.entity.Organization;
import com.coocit.admin.model.vo.OrganizationVo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T10:20:21+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OrganizationConvertImpl implements OrganizationConvert {

    @Override
    public OrganizationVo toVO(Organization org) {
        if ( org == null ) {
            return null;
        }

        OrganizationVo organizationVo = new OrganizationVo();

        organizationVo.setId( org.getId() );
        organizationVo.setName( org.getName() );
        organizationVo.setCode( org.getCode() );
        organizationVo.setParentId( org.getParentId() );
        organizationVo.setSort( org.getSort() );
        organizationVo.setStatus( org.getStatus() );
        organizationVo.setCreateTime( org.getCreateTime() );
        organizationVo.setUpdateTime( org.getUpdateTime() );

        return organizationVo;
    }

    @Override
    public Organization toEntity(OrganizationForm form) {
        if ( form == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setId( form.getId() );
        organization.setName( form.getName() );
        organization.setCode( form.getCode() );
        organization.setParentId( form.getParentId() );
        organization.setSort( form.getSort() );
        organization.setStatus( form.getStatus() );

        return organization;
    }

    @Override
    public OrganizationForm toForm(Organization org) {
        if ( org == null ) {
            return null;
        }

        OrganizationForm organizationForm = new OrganizationForm();

        organizationForm.setId( org.getId() );
        organizationForm.setName( org.getName() );
        organizationForm.setCode( org.getCode() );
        organizationForm.setParentId( org.getParentId() );
        organizationForm.setSort( org.getSort() );
        organizationForm.setStatus( org.getStatus() );

        return organizationForm;
    }
}

package com.coocit.admin.repository;

import com.coocit.admin.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}

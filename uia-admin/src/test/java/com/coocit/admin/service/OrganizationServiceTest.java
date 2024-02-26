package com.coocit.admin.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@SpringBootTest
public class OrganizationServiceTest {

    @Resource
    private OrganizationService organizationService;

    @Test
    public void testList(){
        System.out.println(organizationService.listOrganization(null));

    }
}

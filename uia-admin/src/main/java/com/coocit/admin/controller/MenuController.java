package com.coocit.admin.controller;

import com.coocit.admin.model.vo.RouteVo;
import com.coocit.admin.service.MenuService;
import com.coocit.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/routes")
    public Result<List<RouteVo>> listRoutes() {
        List<RouteVo> routeList = menuService.listRoutes();
        return Result.success(routeList);
    }

}

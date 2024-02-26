package com.coocit.admin.service.impl;

import com.coocit.admin.model.vo.RouteVo;
import com.coocit.admin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public List<RouteVo> listRoutes() {
        //路由从菜单得来
        List<RouteVo> routeVoList = new ArrayList<>();
        RouteVo routevo = new RouteVo();
        routevo.setPath("/organization");
        routevo.setComponent("Layout");
        routevo.setRedirect("/organization");
        RouteVo child = new RouteVo();
        routevo.setChildren(List.of(child));
        routeVoList.add(routevo);
        return routeVoList;
    }
}

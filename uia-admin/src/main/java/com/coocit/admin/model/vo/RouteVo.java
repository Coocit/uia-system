package com.coocit.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
@Schema(description = "路由对象")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteVo {

    @Schema(description = "路由路径", example = "user")
    private String path;

    @Schema(description = "组件路径", example = "system/user/index")
    private String component;

    @Schema(description = "跳转链接", example = "https://www.example.com/")
    private String redirect;

    @Schema(description = "路由名称")
    private String name;

    @Schema(description = "路由属性")
    private Meta meta;

    @Schema(description = "路由属性类型")
    @Data
    public static class Meta {

        @Schema(description = "路由title")
        private String title;

        @Schema(description = "ICON")
        private String icon;

        @Schema(description = "是否隐藏", example = "true")
        private Boolean hidden;

        @Schema(description = "拥有路由权限的角色编码", example = "['ADMIN','ROOT']")
        private List<String> roles;

        @Schema(description = "是否开启缓存", example = "true")
        private Boolean keepAlive;

    }

    @Schema(description = "子路由列表")
    private List<RouteVo> children;
}

package com.coocit.admin.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
@Builder
public class LoginResult {

    private String accessToken;

    private String tokenType;

    private String refreshToken;

    private Long expires;

}

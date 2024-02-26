package com.coocit.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
public class JWTUtil {

    /**
     * 传入payload信息获取token
     *
     * @param map    map
     * @param secret 密钥
     * @return {@link String}
     */
    public static String getToken(Map<String, String> map, String secret) {
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach(builder::withClaim);
        Calendar instance = Calendar.getInstance();
        //默认7天过期
        instance.add(Calendar.DATE, 7);
        //指定令牌的过期时间
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token
     *
     * @param token  令牌
     * @param secret 密钥
     * @return {@link DecodedJWT}
     */
    public static DecodedJWT verify(String token, String secret) {
        //如果有任何验证异常，此处都会抛出异常
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }

    /**
     * 获取token信息方法
     *
     * @param token  令牌
     * @param secret 密钥
     * @return {@link Map}<{@link String}, {@link Claim}>
     */
    public static Map<String, Claim> getTokenInfo(String token, String secret) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getClaims();
    }

}

package com.coocit.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg, null);
    }

}

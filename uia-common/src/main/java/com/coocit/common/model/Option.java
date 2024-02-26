package com.coocit.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
@Data
@AllArgsConstructor
public class Option<T> {

    private T value;

    private String label;

    private List<Option<T>> children;

}

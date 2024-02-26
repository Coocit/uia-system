package com.coocit.admin.model.serialize;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/2/26
 * @description:
 */
public class ListLongToStringArrayJsonSerializer extends JsonSerializer<List<Long>> {
    @Override
    public void serialize(List<Long> values, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        String[] newValues =
                ObjectUtil.defaultIfNull(values, Collections.emptyList()).stream()
                        .map(String::valueOf)
                        .toArray(String[]::new);
        gen.writeArray(newValues, 0, newValues.length);
    }
}

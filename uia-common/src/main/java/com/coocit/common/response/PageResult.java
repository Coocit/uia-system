package com.coocit.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private int total;
    private int page;
    private int pageSize;
    private int pageCount;
    private List<T> list;

    public static <T> PageResult<T> of(List<T> list, int total, int page, int pageSize) {
        PageResult<T> pageResult = new PageResult<>(total, page, pageSize, 0, list);
        pageResult.pageCount = getPageCount(total, pageSize);
        return pageResult;
    }

    public static int getPageCount(int total, int pageSize) {
        return ((total - 1) / pageSize) + 1;
    }

    public static <T> PageResult<T> of(Page<T> all, int page, int pageSize) {
        return new PageResult<>(all.getSize(), page, pageSize, all.getTotalPages(), all.getContent());
    }

    public static <T> PageResult<T> empty() {
        return of(Collections.emptyList(),0,1,10);
    }

}

package com.koldex.seach.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchFilter<T> {

    List<T> apply();

    default Page<T> search(Pageable pageable) {
        List<T> unpaged = apply();
        if (pageable.isUnpaged()) {
            return new PageImpl<>(unpaged);
        }
        List<T> page = unpaged.stream()
                .skip(pageable.getOffset())
                .limit(pageable.getPageSize())
                .toList();
        return new PageImpl<>(page, pageable, unpaged.size());
    }

}

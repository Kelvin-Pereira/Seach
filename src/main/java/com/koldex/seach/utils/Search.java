package com.koldex.seach.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Search<T> {

    Page<T> search(Pageable pageable);

    default Page<T> search() {
        return search(Pageable.unpaged());
    }

}

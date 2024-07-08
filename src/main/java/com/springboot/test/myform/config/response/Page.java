package com.springboot.test.myform.config.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Page {

    private long recordsFiltered;

    private long recordsTotal;

    protected Page(long totalElements) {
        this.recordsFiltered = totalElements;

        this.recordsTotal = totalElements;
    }
}

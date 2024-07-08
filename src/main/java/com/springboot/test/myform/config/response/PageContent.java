package com.springboot.test.myform.config.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PageContent<T> {

    private Page page;

    private T contents;
}

package com.springboot.test.myform.config.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseContent<T> {

    private List<String> remarks = new ArrayList<>();

    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private int status;

    private String code;

    private Object data;

    public ResponseContent(StatusCode statusCode) {
        this.message = statusCode.getMessage();
        this.timestamp = LocalDateTime.now();
        this.status = statusCode.getStatus();
        this.code = statusCode.getCode();
    }

    public ResponseContent(StatusCode statusCode, T data) {
        this(statusCode);
        this.data = data;
    }

    public ResponseContent(StatusCode statusCode, String message) {
        this(statusCode);
        this.remarks.add(message);
    }

    public ResponseContent(StatusCode statusCode, T data, long totalElements) {
        this(statusCode);
        this.data = new PageContent<>(new Page(totalElements), data);
    }

    public ResponseContent(StatusCode statusCode, T data, boolean hasNext) {
        this(statusCode);
        this.data = new SliceContent<>(new Slice(hasNext), data);
    }

    public ResponseContent(StatusCode statusCode, List<FieldError> remarks) {
        this(statusCode);
        this.remarks = remarks.stream()
                .map(c -> c.getDefaultMessage())
                .collect(Collectors.toList());
    }
}

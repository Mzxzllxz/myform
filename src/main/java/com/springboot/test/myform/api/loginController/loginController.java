package com.springboot.test.myform.api.loginController;

import com.springboot.test.myform.config.response.ResponseContent;
import com.springboot.test.myform.config.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class loginController {
    @GetMapping("/login")
    public ResponseEntity login() {
        return ResponseEntity
                .ok()
                .body(new ResponseContent<>(StatusCode.OK));
    }
}

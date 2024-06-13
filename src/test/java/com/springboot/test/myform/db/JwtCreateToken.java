package com.springboot.test.myform.db;

import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

public class JwtCreateToken {

    public static void main(String[] args) {
        long tokenValidTime =        1000L * 60 * 60; // 1시간
        String id = "dddd";
        String secretKey = "Jl/4lI8k1y6aI66yiJGXMgW6NZPjG9Jn2iPKJ71uu2Q=";
        byte[] keybytes = Base64.getDecoder().decode(secretKey);
        System.out.println(Arrays.toString(keybytes));
        String Algorithms = "HmacSHA256";
        // 1. SecretKeySpec 클래스를 사용한 키 생성
        SecretKeySpec key = new SecretKeySpec(keybytes, Algorithms);

        Date now = new Date();

        String jwtSrc = Jwts.builder()
                .subject(id)
                .issuedAt(now)
                .expiration(new Date(System.currentTimeMillis() + tokenValidTime))
                .signWith(key)
                .compact();

        System.out.println("jwtsrc: " + jwtSrc);

        try {
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwtSrc);
            System.out.println("true");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("false");
        }
    }

}

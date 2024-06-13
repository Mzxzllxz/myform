package com.springboot.test.myform.db;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class RandomGen {

    // Buffer를 사용하여 변환하기
    private static char[] toCharsUseBuffer(byte[] bytes) {
        if (bytes == null) return null;
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
        char[] chars = Arrays.copyOfRange(charBuffer.array(), charBuffer.position(), charBuffer.limit());
        // 민감 정보 지우기
        Arrays.fill(charBuffer.array(), '\u0000');
        return chars;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] hmacKey = new byte[32];
        secureRandom.nextBytes(hmacKey);

        //System.out.println(Hex.encodeHexString(hmacKey));
        System.out.println(Base64.getEncoder().encodeToString(hmacKey));

        //char[] hmacChar = toCharsUseBuffer(hmacKey);
        //System.out.println("hmacChar length: " + hmacChar.length);
        for (char c : Base64.getEncoder().encodeToString(hmacKey).toCharArray()) {
            System.out.print(", " + (long)c);
        }
    }

}

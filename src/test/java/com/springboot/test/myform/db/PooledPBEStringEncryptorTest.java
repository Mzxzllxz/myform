package com.springboot.test.myform.db;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import java.security.Security;

public class PooledPBEStringEncryptorTest {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {

        String passwd = "dongdong2024!";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(passwd);
        config.setAlgorithm("PBEWithMD5AndDES"); //사용할 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("BC");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");

        encryptor.setConfig(config);

        String plainText = "qwe123";
        String encryptedText = encryptor.encrypt(plainText);
        String decryptedText = encryptor.decrypt(encryptedText);
        System.out.println("Enc = " + encryptedText);
        System.out.println("Dec = " + decryptedText);
    }

}
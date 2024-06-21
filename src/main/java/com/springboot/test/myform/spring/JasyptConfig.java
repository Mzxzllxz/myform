package com.springboot.test.myform.spring;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
	
	@Value("${jasypt.encryptor.password}")
	private String encryptKey;
	
	@Value("${jasypt.encryptor.algorithm}")
	private String algorithm;
	
	@Value("${jasypt.encryptor.key-obtention-iterations}")
	private String keyObtentionIterations;
	
	@Value("${jasypt.encryptor.pool-size}")
	private String poolize;
	
	@Value("${jasypt.encryptor.provider-name}")
	private String providerName;
	
	@Value("${jasypt.encryptor.salt-generator-classname}")
	private String saltGeneratorClassname;
	
	@Value("${jasypt.encryptor.string-output-type}")
	private String stringOutputType;

	@Bean(name = "jasyptStringEncryptor")
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		
		config.setPassword(encryptKey);
		config.setAlgorithm(algorithm); //사용할 알고리즘		
        config.setKeyObtentionIterations(keyObtentionIterations);
        config.setPoolSize(poolize);
        config.setProviderName(providerName);
        config.setSaltGeneratorClassName(saltGeneratorClassname);
        config.setStringOutputType(stringOutputType);
        encryptor.setConfig(config);
        return encryptor;
	}
}

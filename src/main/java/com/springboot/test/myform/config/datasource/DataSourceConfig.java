package com.springboot.test.myform.config.datasource;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {



    private final Environment environment;

    @Bean(value = "thisDataSource")
    public DataSource thisDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return dataSource;
    }

}

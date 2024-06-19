package com.springboot.test.myform.config.datasource.jpa;


import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(
        basePackages = "com.springboot.test.myform.repository",
        entityManagerFactoryRef = "thisEntityManagerFactory",
        transactionManagerRef = "thisTransactionManager"
)
public class ThisJpaConfig {

    private final Environment environment;

    @Bean(name = "thisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManager(@Qualifier("thisDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entitymanagerFactory = new LocalContainerEntityManagerFactoryBean();
        entitymanagerFactory.setDataSource(dataSource);
        entitymanagerFactory.setPackagesToScan("com.springboot.test.myform.repository");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        entitymanagerFactory.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> prop = new HashMap<>();
        prop.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
        prop.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        prop.put("hibernate.format_sql", environment.getProperty("spring.jpa.properties.hibernate.format_sql"));
        prop.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        entitymanagerFactory.setJpaPropertyMap(prop);

        return entitymanagerFactory;
    }

    @Bean("thisTransactionManager")
    public PlatformTransactionManager writeTransactionManager(
            @Qualifier("thisEntityManagerFactory") EntityManagerFactory writeEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(writeEntityManagerFactory);
        return transactionManager;
    }
}

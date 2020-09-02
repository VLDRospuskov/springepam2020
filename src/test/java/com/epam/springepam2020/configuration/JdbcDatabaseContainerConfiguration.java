package com.epam.springepam2020.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcDatabaseContainerConfiguration {

    @Bean
    public BeanPostProcessor jdbcDatabaseContainerBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof DataSourceProperties) {
                    SpringPostgreSqlContainer container = SpringPostgreSqlContainer.getInstance();
                    DataSourceProperties properties = (DataSourceProperties) bean;
                    properties.setName(container.getDatabaseName());
                    properties.setDriverClassName(container.getDriverClassName());
                    properties.setUrl(container.getJdbcUrl());
                    properties.setUsername(container.getUsername());
                    properties.setPassword(container.getPassword());
                }

                return bean;
            }
        };
    }

}

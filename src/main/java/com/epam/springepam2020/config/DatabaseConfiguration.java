package com.epam.springepam2020.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class DatabaseConfiguration {

    @Autowired
    private Environment environment;

    @Value("${jdbc.username}")
    private String username;

    @Bean
    public Connection connection() {
        Connection connection = null;
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/spring",
                    "postgres",
                    "postgres"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Bean
    public DataSource DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.Driver"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(username);
        dataSource.setPassword("postgres");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(DataSource());
        return jdbcTemplate;
    }

}

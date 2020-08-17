//package com.epam.springepam2020.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = {"classpath:application.properties"})
//@EnableJpaRepositories("com.epam.springepam2020.repository")
//public class DatabaseConfiguration {
//
//    @Autowired
//    private Environment environment;
//
//    // Driver Manager
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("jdbc.Driver"));
//        dataSource.setUrl(environment.getProperty("jdbc.url"));
//        dataSource.setUsername(environment.getProperty("jdbc.username"));
//        dataSource.setPassword(environment.getProperty("jdbc.password"));
//        return dataSource;
//    }
//
//    // Jdbc Template
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }
//
//    // Hibernate
////    @Bean
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource());
////        sessionFactory.setPackagesToScan("com.epam.springepam2020");
////        sessionFactory.setHibernateProperties(hibernateProperties());
////
////        return sessionFactory;
////    }
//
////    @Bean
////    public PlatformTransactionManager hibernateTransactionManager() {
////        HibernateTransactionManager transactionManager
////                = new HibernateTransactionManager();
////        transactionManager.setSessionFactory(sessionFactory().getObject());
////        return transactionManager;
////    }
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "create-drop");
//        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//
//        return hibernateProperties;
//    }
//
//    // JPA
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean containerEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        containerEntityManagerFactory.setDataSource(dataSource());
//        containerEntityManagerFactory.setPackagesToScan("com.epam.springepam2020.model");
//        containerEntityManagerFactory.setJpaProperties(hibernateProperties());
//        containerEntityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter()); // реализация
//        return containerEntityManagerFactory;
//    }
//
//    @Bean
//    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return jpaTransactionManager;
//    }
//
//}

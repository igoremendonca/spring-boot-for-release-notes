package com.spring.boot.release.pocrelease.controller.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriver;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean(destroyMethod = "close", name = "dataSource")
    public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(dataSourceDriver);
        dataSourceConfig.setJdbcUrl(dataSourceUrl);
        dataSourceConfig.setUsername(dataSourceUsername);
        dataSourceConfig.setPassword(dataSourcePassword);

        return new HikariDataSource(dataSourceConfig);
    }
}

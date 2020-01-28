package com.example.SimpleBoot.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
@Profile("dev")
public class DevDatasource implements Datasource {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Override
    public DataSource getDatasource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:derby://localhost:1527/contact")
                .username("nbuser")
                .password("nbuser")
                .build();
    }
}

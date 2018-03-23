package com.example.demo.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProdPersistenceConfig {
	
    @Bean
    @Profile("prod")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
    	// Enable this to use Embedded database
    	// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    	// EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("initialize.sql").build();
    	DataSource db = DataSourceBuilder.create().build();
    	return db;
    }

}
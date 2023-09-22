package com.dolex.APICitasCMDolex.config;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	private static final Logger LOGGER = LogManager.getLogger(DataSourceConfig.class);
	
	@Value("${cmdolex.datasource.dev-driver}")
	private String driverBD;
	
	@Value("${cmdolex.datasource.dev-url}")
	private String urlBD;

	@Value("${cmdolex.datasource.dev-bd}")
	private String nameBD;
	
	@Value("${cmdolex.datasource.dev-user}")
	private String userBD;

	@Value("${cmdolex.datasource.dev-password}")
	private String passwordBD;

	@Bean
    DataSource getDataSource() {
        LOGGER.info("Inicia DataSource");
        HikariDataSource dataSource= new HikariDataSource();
        dataSource.setDriverClassName(driverBD);
        dataSource.setJdbcUrl(urlBD.concat(nameBD));
        dataSource.setUsername(userBD);
        dataSource.setPassword(passwordBD);
        dataSource.setMaximumPoolSize(15);
        dataSource.setMinimumIdle(5);
        return dataSource;
    }
	
}
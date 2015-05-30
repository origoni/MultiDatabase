package com.millky.dev.database.multi.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataBaseConfig {
	private static final String DEFAULT_NAMING_STRATEGY = "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy";

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.article")
	public DataSource articleDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {

		Map<String, String> propertiesHashMap = new HashMap<>();
		propertiesHashMap.put("hibernate.ejb.naming_strategy", DEFAULT_NAMING_STRATEGY);

		return builder.dataSource(articleDataSource())
				.packages("com.millky.dev.database.multi.domain.article")
				.properties(propertiesHashMap)
				.build();
	}
	
	@Primary
	@Bean(name = "transactionManager")
	PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}

	@Configuration
	@EnableJpaRepositories(basePackages="com.millky.dev.database.multi.infra.article",
			entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
	static class DbOnepaRepositoriesConfig {
	}

	
	@Bean
	@ConfigurationProperties(prefix = "datasource.user")
	public DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactoryUser")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder) {

		return builder.dataSource(userDataSource())
				.packages("com.millky.dev.database.multi.domain.user")
				.build();
	}

	@Bean(name = "transactionManagerUser")
	@Primary
	PlatformTransactionManager userTransactionManagerMain(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(userEntityManagerFactory(builder).getObject());
	}
	
	@Configuration
	@EnableJpaRepositories(
			basePackages="com.millky.dev.database.multi.infra.user",
			entityManagerFactoryRef = "entityManagerFactoryUser",
			transactionManagerRef = "transactionManagerUser")
	static class DbTwoJpaRepositoriesConfig {
	}
}

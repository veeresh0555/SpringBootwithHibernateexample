package com.hiber.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	private DataSource datasource;
	
	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactorybean=new LocalSessionFactoryBean();
		sessionFactorybean.setDataSource(datasource);
		sessionFactorybean.setPackagesToScan("com.hiber.model");
		sessionFactorybean.setHibernateProperties(HibernateProperties());
		return sessionFactorybean;
	}
	
	
	/*
	 * @Bean public DataSource dataSource() { BasicDataSource dataSource = new
	 * BasicDataSource(); dataSource.setDriverClassName("org.h2.Driver");
	 * dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
	 * dataSource.setUsername("sa"); dataSource.setPassword("sa");
	 * 
	 * return dataSource; }
	 */
	 
	
	@Bean
	public Properties HibernateProperties() {
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "none");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return prop;
	}
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {//
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {//EntityManagerFactory
		LocalContainerEntityManagerFactoryBean emfbean=new LocalContainerEntityManagerFactoryBean();
		emfbean.setDataSource(datasource);
		emfbean.setPackagesToScan("com.hiber.model");
		JpaVendorAdapter hibernateAdopter=new HibernateJpaVendorAdapter();
		emfbean.setJpaVendorAdapter(hibernateAdopter);
		emfbean.setJpaProperties(HibernateProperties());
		return emfbean;
		
	}
	
	
	
	
	
}

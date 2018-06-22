/*package com.hailong.config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//表明是一个配置类

@Configuration
@EnableTransactionManagement  //事务的管理操作
public class C3P0DataSourceConfig {
	
	//进行自动的映射配置

	private String password="123456";

	private String username="root";

	private String url="jdbc:mysql://127.0.0.1:3306/books";
	
	private String driverClassName="com.mysql.jdbc.Driver";
	
	@Bean
	public ComboPooledDataSource getC3P0DataSource(){
		ComboPooledDataSource dataSources=new ComboPooledDataSource();
		
		try {
			dataSources.setPassword(password);
			dataSources.setDriverClass(driverClassName);
			dataSources.setJdbcUrl(url);
			dataSources.setUser(username);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSources;
	}
	


}*/

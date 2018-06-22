/*package com.hailong.config;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ActivitiConfig {

	  @Autowired  
	  private DataSource dataSource;
	  
	  @Autowired
	  private PlatformTransactionManager transactionManager;
    
    @Bean
    public SpringProcessEngineConfiguration getSpringProcessEngineConfiguration(){
    	SpringProcessEngineConfiguration springProcessEngineConfiguration=new SpringProcessEngineConfiguration();
    	springProcessEngineConfiguration.setDataSource(dataSource);
    	springProcessEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    	
    	springProcessEngineConfiguration.setTransactionManager(transactionManager);
    	return springProcessEngineConfiguration;
    }
    
}*/

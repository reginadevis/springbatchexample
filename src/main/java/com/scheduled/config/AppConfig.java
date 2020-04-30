package com.scheduled.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.scheduled.pojo.ApplicationProperties;
 
	 
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	 Environment environment;
	 
	 @Bean
	ApplicationProperties appProperties() {
	    ApplicationProperties bean = new ApplicationProperties();
	    bean.setFileName(environment.getProperty("com.ouptut.filename"));
	    bean.setFilePath(environment.getProperty("com.ouptut.filepath"));
	    return bean;
	  }
	
}

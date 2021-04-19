package com.banking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("spring.datasource")
@Data
public class DatabaseProps {
	
	private String url;
	private String userName;
	private String password;
	private String driverClassName; 
	
	public DatabaseProps() {
		// TODO Auto-generated constructor stub
	}

}

package com.banking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
//@Component 
@ConfigurationProperties("app")
@Data
public class ApplicationProps {

	private String security;
	private String env;
	private String authentication;
	private String menu;
	
	public ApplicationProps() {
		// TODO Auto-generated constructor stub
	}

}

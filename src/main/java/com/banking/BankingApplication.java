package com.banking;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import com.banking.config.ApplicationProps;
//import com.banking.entities.TestStatic;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class BankingApplication {
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);
		
		List<String> beanList = Arrays.asList(context.getBeanDefinitionNames());
		//beanList.forEach(name->System.out.println("Load bean: "+name));
		beanList.stream().map(a->"Load bean: "+a).forEach(System.out::println);
		
	}

}

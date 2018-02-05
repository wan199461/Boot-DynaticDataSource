package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;  
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class  })  // datasourceinitializer 禁用,防止springboot自动装配数据源
public class BootDynaticDataSouceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDynaticDataSouceApplication.class, args);
	}
}

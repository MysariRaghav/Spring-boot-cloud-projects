package com.spring.cloud.dataservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring")
public class DataService1Application {

	public static void main(String[] args) {
		SpringApplication.run(DataService1Application.class, args);
	}
}

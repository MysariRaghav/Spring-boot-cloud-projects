package com.spring.cloud.dataservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring")
public class DataService2Application {

	public static void main(String[] args) {
		SpringApplication.run(DataService2Application.class, args);
	}
}

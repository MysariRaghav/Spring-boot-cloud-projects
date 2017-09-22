package com.spring.cloud.ribbontimeapp;

import com.spring.cloud.config.RibbonClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="time-service", configuration = RibbonClientConfiguration.class)
public class RibbonTimeAppWithoutSDApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppWithoutSDApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	@GetMapping
	public String time()
	{
		return restTemplate.getForEntity("http://time-service", String.class).getBody();
	}
}

package com.spring.cloud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerDetailResource {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate webTemplate;

	@RequestMapping(value="/customer/{cid}", method= RequestMethod.GET)
	public @ResponseBody
	String getCustomer(@PathVariable Integer cid) {

		ResponseEntity<String> contact = webTemplate.getForEntity("http://localhost:7081/fastpass/customer/"+cid+"/contactdetails", String.class);
		ResponseEntity<String> vehicle = webTemplate.getForEntity("http://localhost:7082/fastpass/customer/"+cid+"/vehicledetails", String.class);

		return contact.getBody() + " | " + vehicle.getBody();

	}
}

package com.spring.cloud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;


@RestController
public class VehicleDetailsResource {

	@Autowired
	private Tracer tracer;

	@RequestMapping(value="/customer/{cid}/vehicledetails", method= RequestMethod.GET)
	public @ResponseBody
	String getCustomerVehicleDetails(@PathVariable Integer cid)  throws InterruptedException {

		String result;

		Span s = this.tracer.createSpan("lookupvehicle");
		try {
			//add tags
			this.tracer.addTag("customerid", cid.toString());

			s.logEvent("DB query started");

			Thread.sleep(500);

			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

			result = vehicles.get(cid);

			s.logEvent("DB query completed");
	}
		finally {
			this.tracer.close(s);
		}

		return result;
	}
}

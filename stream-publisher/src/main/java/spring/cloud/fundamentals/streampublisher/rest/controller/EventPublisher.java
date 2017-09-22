package spring.cloud.fundamentals.streampublisher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import spring.cloud.fundamentals.streampublisher.CustomPublisherInterface;

import java.util.Random;

//@RestController
//@ComponentScan("spring.cloud")
public class EventPublisher {


	@Autowired
	CustomPublisherInterface source;

//	@RequestMapping(path = "/socialityCheck", method = RequestMethod.POST)
	public String socialityCheck(@RequestBody String person)
	{
		System.out.println(person);
		Random random= new Random();

		source.customChannel().send(MessageBuilder.withPayload(person).setHeader("friends", random.nextInt(30)).build());

		return "success";
	}
}

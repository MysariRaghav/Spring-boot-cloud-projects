package spring.cloud.fundamentals.streampublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@ComponentScan("spring.cloud")
public class EventPublisher {


	@Autowired
	CustomPublisherInterface customPublisherInterface;

	@RequestMapping(path = "/socialityCheck", method = RequestMethod.POST)
	public String socialityCheck(@RequestBody String person)
	{
		System.out.println(person);
		Random random= new Random();

		customPublisherInterface.customChannel().send(MessageBuilder.withPayload(person).setHeader("friends", random.nextInt(30)).build());

		return "success";
	}
}

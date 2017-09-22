package spring.cloud.fundamentals.streampublisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@ComponentScan("spring.cloud")
@Component
@EnableBinding(CustomPublisherInterface.class)
public class CustomPublisher {

	Random random= new Random();
/*	@Bean
	@InboundChannelAdapter(channel = CustomPublisherInterface.CUSTOM_FREQUENCY_CHANNEL, poller = @Poller(fixedDelay = "2000"))
	public MessageSource<Person> publishEveryOneSecond()
	{

		return ()-> MessageBuilder.withPayload(new Person("ragha", 25, "Barclay")).setHeader("friends", random.nextInt(30)).build();
	}*/

	@Bean
	@InboundChannelAdapter(channel = CustomPublisherInterface.CUSTOM_FREQUENCY_CHANNEL, poller = @Poller(fixedDelay = "2000"))
	public MessageSource<String> publishEveryOneSecond()
	{

		return ()-> MessageBuilder.withPayload(new Person("ragha", 25, "Barclay").toString()).setHeader("friends", random.nextInt(30)).build();
	}

	class Person{

		public String name;
		public int age;
		public String company;

		public Person(String name, int age, String company) {
			this.name = name;
			this.age = age;
			this.company = company;
		}
	}

}

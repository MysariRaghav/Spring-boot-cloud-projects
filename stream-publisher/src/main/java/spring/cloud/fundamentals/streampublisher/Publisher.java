package spring.cloud.fundamentals.streampublisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

//@EnableBinding(Source.class)
public class Publisher {

//	@InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedDelay = "4000"))
	public String publishEveryOneSecond()
	{
		return "Hello";
	}

}

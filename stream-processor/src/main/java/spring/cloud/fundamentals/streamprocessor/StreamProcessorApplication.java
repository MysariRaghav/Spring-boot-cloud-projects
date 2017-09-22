package spring.cloud.fundamentals.streamprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@ComponentScan("spring.cloud")
@EnableBinding(Processor.class)
public class StreamProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamProcessorApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String pollEveryMessage(String msg)
	{
		System.out.println(msg);
		return msg;
	}

}

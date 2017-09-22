package spring.cloud.fundamentals.streampublisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@ComponentScan("spring.cloud")
@Component
public interface CustomPublisherInterface {

	String CUSTOM_FREQUENCY_CHANNEL= "custom-frequency-channel";

	@Output("custom-frequency-channel")
	MessageChannel customFrequencyChannel();

	MessageChannel customChannel();
}

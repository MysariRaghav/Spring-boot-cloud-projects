package spring.cloud.fundamentals.streampublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("spring.cloud")
public class StreamPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamPublisherApplication.class, args);
	}
}

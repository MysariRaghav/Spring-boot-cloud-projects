package config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonClientConfiguration {

	@Bean
	public IRule iRule(){
		return new RandomRule();
	}

	@Bean
	public IPing iPing(){
		PingUrl pingUrl = new PingUrl();
		pingUrl.setExpectedContent("true");
		return pingUrl;
	}
}

package spring.cloud.fundamentals.streamintake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.ServiceActivator;

@SpringBootApplication
@ComponentScan("spring.cloud")
@EnableBinding(Sink.class)
public class StreamIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamIntakeApplication.class, args);
	}

	@StreamListener(value =  Sink.INPUT,condition = "headers['friends']<15")
//	@ServiceActivator(inputChannel = Sink.INPUT)
	public void pollNonSocialMessage(String msg)
	{
		System.out.println("Not social has less fiends "+ msg);
	}

	@StreamListener(value =  Sink.INPUT,condition = "headers['friends']>=15")
//	@ServiceActivator(inputChannel = Sink.INPUT)
	public void pollSocialMessage(String msg)
	{
		System.out.println(" great...!!! Social has less fiends "+ msg);
	}

/*	@StreamListener(Sink.INPUT)
//	@ServiceActivator(inputChannel = Sink.INPUT)
	public void pollEveryMessage(Person msg)
	{
		System.out.println(msg);
	}
*/
	class Person{

		public String name;
		public int age;
		public String company;

		public Person(String name, int age, String company) {
			this.name = name;
			this.age = age;
			this.company = company;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					", company='" + company + '\'' +
					'}';
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}
	}
}

package demo.myfirstexample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.boot.actuate.system.ApplicationPidFileWriter;

@SpringBootApplication
@EnableEurekaClient //or
//@EnableDiscoveryClient
public class SpringbootEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaClientApplication.class, args);
//		SpringApplication notificationMicroService = new SpringApplication(SpringbootEurekaClientApplication.class);
//		notificationMicroService.addListeners(new ApplicationPidFileWriter("notification-micro-service.pid"));
//		notificationMicroService.run(args);
	}


}

package demo.myfirstexample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEurekaServerApplication.class, args);
//		SpringApplication eurekaServer = new SpringApplication(SpringbootEurekaServerApplication.class);
//		eurekaServer.addListeners(new ApplicationPidFileWriter("eureka-server.pid"));
//		eurekaServer.run();
	}
}

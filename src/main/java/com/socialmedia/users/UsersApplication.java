package com.socialmedia.users;

import io.micrometer.observation.annotation.Observed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@LoadBalanced
	@Observed
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}

}

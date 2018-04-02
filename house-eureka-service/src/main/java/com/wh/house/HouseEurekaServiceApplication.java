package com.wh.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaServer
public class HouseEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseEurekaServiceApplication.class, args);
	}
}

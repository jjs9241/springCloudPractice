package com.springcloud.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(PracticeApplication.class);
		logger.info("logger test " + logger.getClass().getCanonicalName());

		SpringApplication.run(PracticeApplication.class, args);
	}

}

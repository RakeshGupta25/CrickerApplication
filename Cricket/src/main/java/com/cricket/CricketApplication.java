package com.cricket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CricketApplication {

	public static final Logger logger = LoggerFactory.getLogger(CricketApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);
		System.out.println("hi");
		
		logger.error("Message logged at ERROR level");
		logger.warn("Message logged at WARN level");
		logger.info("Message logged at INFO level");
		logger.debug("Message logged at DEBUG level");
		
	}

}

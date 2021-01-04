package com.project.omss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This the project for Online Medicine Shopping System
 * 
 * @author PrajwalChavan.
 *
 */
@SpringBootApplication
@ComponentScan({ "com.project.omss.controller", "com.project.omss.service" })
@EntityScan("com.project.omss.entity")
@EnableJpaRepositories("com.project.omss.repository")

public class OmssApplication {
	/**
	 * logger initialized.
	 */
	 static private final Logger LOGGER = LoggerFactory.getLogger(OmssApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application started");
		SpringApplication.run(OmssApplication.class, args);
	}

}

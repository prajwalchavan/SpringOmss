package com.project.omss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.project.omss.controller","com.project.omss.service"})
@EntityScan("com.project.omss.entity")
@EnableJpaRepositories("com.project.omss.repository")
public class OmssApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmssApplication.class, args);
	}

}

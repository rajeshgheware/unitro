package com.example.unitro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableIntegration
@EnableScheduling
@ImportResource({"classpath:/META-INF/gug/**/server.xml"})
public class UnitroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitroApplication.class, args);
	}
}

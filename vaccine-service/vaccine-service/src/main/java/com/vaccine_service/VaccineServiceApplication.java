package com.vaccine_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class VaccineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineServiceApplication.class, args);
	}

}

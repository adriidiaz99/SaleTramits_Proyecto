package com.salesianostriana.SalesTrami;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalesTramiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTramiApplication.class, args);
	}

	@Bean
	CommandLineRunner initData() {

		return args -> {

		};
	}
}

package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiCrudAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApiCrudAppApplication.class, args);
		System.out.println("REST API...");
	}

}

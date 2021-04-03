package com.eci.ieti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class BagTravBackendApp{

	public static void main(String[] args) {
		SpringApplication.run(BagTravBackendApp.class, args);
	}

}

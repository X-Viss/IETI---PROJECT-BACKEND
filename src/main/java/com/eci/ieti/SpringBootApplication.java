package com.eci.ieti;

import com.eci.ieti.model.User;
import com.eci.ieti.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

	@Autowired
	CustomRepository customRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("luisa", "123");
		customRepository.createUser(user);
		System.out.println("toteo");
	}
}

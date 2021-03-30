package com.eci.ieti;

import com.eci.ieti.model.User;
import com.eci.ieti.persistence.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BagTravBackendApp implements CommandLineRunner {

	@Autowired
	CustomRepository customRepository;

	public static void main(String[] args) {
		SpringApplication.run(BagTravBackendApp.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//createUser();
		getNameUser();
	}

	public void createUser(){
		User user = new User("luisa", "123");
		customRepository.createUser(user);
	}

	public void getNameUser() {
		User var = customRepository.getName("luisa");
		System.out.println(var.getpassword());
	}
}

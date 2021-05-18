package com.eci.ieti;

import com.eci.ieti.configuration.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BagTravBackendApp{




	public static void main(String[] args) {
		SpringApplication.run(BagTravBackendApp.class, args);
	}



}

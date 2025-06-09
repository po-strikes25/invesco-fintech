package com.invesco_fintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InvescoFintechApplication {

	@GetMapping("/")
	public String welcomeInvestors()
	{
		return "Welcome to the AWS Deployment of Invesco Fintech ... !!!";
	}

	public static void main(String[] args)
	{
		SpringApplication.run(InvescoFintechApplication.class, args);
	}

}

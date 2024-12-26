package com.project.logmanagementutilitytool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


import java.io.File;

@SpringBootApplication

public class LogManagementUtilityToolApplication {


	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(LogManagementUtilityToolApplication.class, args);
	}
}
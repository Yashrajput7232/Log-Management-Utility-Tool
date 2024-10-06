package com.project.logmanagementutilitytool;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication

public class LogManagementUtilityToolApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file
		File envFile = new File(".env");
		if (envFile.exists()){
			Dotenv dotenv = Dotenv.load();
			dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		}
		SpringApplication.run(LogManagementUtilityToolApplication.class, args);
	}
}
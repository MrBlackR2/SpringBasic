package com.employee.app;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmployeeMain {

	private static final Logger logger = LogManager.getLogger(EmployeeMain.class);


	public static void main(String[] args) {
		logger.info("---------Start of the Mail Program-------------");
		SpringApplication.run(EmployeeMain.class, args);
		logger.info("---------End of the Mail Program-------------");
	}
}

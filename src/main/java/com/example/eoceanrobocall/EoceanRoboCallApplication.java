package com.example.eoceanrobocall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EoceanRoboCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(EoceanRoboCallApplication.class, args);
	}

}

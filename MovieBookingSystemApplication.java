package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.service.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		System.out.println("Hello Spring Boot !!! ");




	}

	/**
	 * This is way to execute something in the very begining when application
	 * is starting up
	 * @param initService
	 * @return
	 */
	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			System.out.println("This will be executed as soon as the application is started");
			initService.init();
		};
	}


}

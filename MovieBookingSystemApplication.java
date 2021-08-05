package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.dao.CityDao;
import com.vishwa.movieBookingSystem.dao.MovieDao;
import com.vishwa.movieBookingSystem.dao.TheatreDao;
import com.vishwa.movieBookingSystem.entities.City;
import com.vishwa.movieBookingSystem.entities.Movie;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		System.out.println("Hello Spring Boot !!! ");

	}

}

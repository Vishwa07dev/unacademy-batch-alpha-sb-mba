package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.dao.MovieDao;
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

		MovieDao movieDao = ctx.getBean(MovieDao.class);

		Movie movie = new Movie();

		movie.setMovieName("Dhoom Again");
		movie.setMovieDescription("Another AB movie ");
		movie.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
		movie.setDuration(150);
		movie.setCoverPhotoUrl("cover-photo-url");
		movie.setTrailerUrl("trailer-url");

		System.out.println("Before Saving: " + movie);


		Movie savedMovie = movieDao.save(movie);
		System.out.println("After saving: " + savedMovie);

		Movie retrievedMovie = movieDao.findById(savedMovie.getMovieId()).orElse(null);
		System.out.println("After retrieving: " + retrievedMovie);

		movie.setDuration(160);
		Movie updatedMovie = movieDao.save(movie);
		System.out.println("After updating: " + updatedMovie);

		movieDao.delete(updatedMovie);
		System.out.println("After deleting: " + movieDao.findById(updatedMovie.getMovieId()));
	}

}

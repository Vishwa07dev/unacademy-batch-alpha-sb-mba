package com.vishwa.movieBookingSystem.service;

import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import java.util.List;


public interface MovieService {
  public Movie acceptMovieDetails(Movie movie);
  public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;
  public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;
  public boolean deleteMovie(int id) throws MovieDetailsNotFoundException ;
  public List<Movie> getAllMoviesDetails();
}

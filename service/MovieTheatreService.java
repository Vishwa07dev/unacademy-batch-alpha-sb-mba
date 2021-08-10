package com.vishwa.movieBookingSystem.service;

import com.vishwa.movieBookingSystem.entities.MovieTheatre;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import java.util.List;


public interface MovieTheatreService {
  public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
                                                                                  TheatreDetailsNotFoundException;
  public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
  public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
  public List<MovieTheatre> getAllMovieTheatreDetails();
}

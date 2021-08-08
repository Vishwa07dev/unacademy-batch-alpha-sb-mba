package com.vishwa.movieBookingSystem.service.impl;

import com.vishwa.movieBookingSystem.dao.MovieDao;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  public MovieDao movieDao;

  @Override
  public Movie acceptMovieDetails(Movie movie) {
    return movieDao.save(movie);
  }

  @Override
  public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {
    return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id: " + id));
  }

  @Override
  public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
    Movie savedMovie = getMovieDetails(id);

    if (isNotNullOrZero(movie.getMovieName())) {
      savedMovie.setMovieName(movie.getMovieName());
    }
    if (isNotNullOrZero(movie.getMovieDescription())) {
      savedMovie.setMovieDescription(movie.getMovieDescription());
    }
    if (isNotNullOrZero(movie.getReleaseDate())) {
      savedMovie.setReleaseDate(movie.getReleaseDate());
    }
    if (isNotNullOrZero(movie.getDuration())) {
      savedMovie.setDuration(movie.getDuration());
    }
    if (isNotNullOrZero(movie.getCoverPhotoUrl())) {
      savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
    }
    if (isNotNullOrZero(movie.getTrailerUrl())) {
      savedMovie.setTrailerUrl(movie.getTrailerUrl());
    }
    if (isNotNullOrZero(movie.getStatus())) {
      savedMovie.setStatus(movie.getStatus());
    }

    return movieDao.save(savedMovie);
  }

  private boolean isNotNullOrZero(Object obj) {
    return obj != null;
  }

  private boolean isNotNullOrZero(int val) {
    return val != 0;
  }

  @Override
  public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
    Movie savedMovie = getMovieDetails(id);
    movieDao.delete(savedMovie);
    return true;
  }

  @Override
  public List<Movie> getAllMoviesDetails() {
    return movieDao.findAll();
  }
}

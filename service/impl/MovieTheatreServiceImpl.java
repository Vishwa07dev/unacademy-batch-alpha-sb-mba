package com.vishwa.movieBookingSystem.service.impl;


import com.vishwa.movieBookingSystem.dao.MovieTheatreDao;
import com.vishwa.movieBookingSystem.entities.MovieTheatre;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.service.MovieService;
import com.vishwa.movieBookingSystem.service.MovieTheatreService;
import com.vishwa.movieBookingSystem.service.TheatreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {

  @Autowired
  private MovieTheatreDao movieTheatreDao;

  @Autowired
  private TheatreService theatreService;

  @Autowired
  private MovieService movieService;

  @Override
  public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre)
      throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
    movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
    theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
    return movieTheatreDao.save(movieTheatre);
  }

  @Override
  public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
    return movieTheatreDao.findById(id)
        .orElseThrow(
            () -> new MovieTheatreDetailsNotFoundException("MovieTheatre not found by id: " + id)
        );
  }

  @Override
  public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
    MovieTheatre movieTheatre = getMovieTheatreDetails(id);
    movieTheatreDao.delete(movieTheatre);
    return true;
  }

  @Override
  public List<MovieTheatre> getAllMovieTheatreDetails() {
    return movieTheatreDao.findAll();
  }
}

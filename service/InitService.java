package com.vishwa.movieBookingSystem.service;

import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.vishwa.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;


public interface InitService {
  public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException,
                            TheatreDetailsNotFoundException, MovieDetailsNotFoundException,
                            MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
}

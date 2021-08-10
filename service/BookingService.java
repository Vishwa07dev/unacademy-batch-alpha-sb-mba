package com.vishwa.movieBookingSystem.service;

import com.vishwa.movieBookingSystem.entities.Booking;
import com.vishwa.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import java.util.List;


public interface BookingService {

  public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
                                                              UserDetailsNotFoundException;
  public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
  public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
  public List<Booking> getAllBookingDetails();

}

package com.vishwa.movieBookingSystem.service.impl;

import com.vishwa.movieBookingSystem.dao.CityDao;
import com.vishwa.movieBookingSystem.dao.LanguageDao;
import com.vishwa.movieBookingSystem.dao.StatusDao;
import com.vishwa.movieBookingSystem.dao.UserTypeDao;
import com.vishwa.movieBookingSystem.entities.Booking;
import com.vishwa.movieBookingSystem.entities.City;
import com.vishwa.movieBookingSystem.entities.Language;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.entities.MovieTheatre;
import com.vishwa.movieBookingSystem.entities.Status;
import com.vishwa.movieBookingSystem.entities.Theatre;
import com.vishwa.movieBookingSystem.entities.User;
import com.vishwa.movieBookingSystem.entities.UserType;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.vishwa.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.vishwa.movieBookingSystem.service.BookingService;
import com.vishwa.movieBookingSystem.service.InitService;
import com.vishwa.movieBookingSystem.service.MovieService;
import com.vishwa.movieBookingSystem.service.MovieTheatreService;
import com.vishwa.movieBookingSystem.service.TheatreService;
import com.vishwa.movieBookingSystem.service.UserService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class InitServiceImpl implements InitService {
  @Autowired
  CityDao cityDao;

  @Autowired
  UserTypeDao userTypeDao;

  @Autowired
  LanguageDao languageDao;

  @Autowired
  StatusDao statusDao;

  @Autowired
  UserService customerService;

  @Autowired
  TheatreService theatreService;

  @Autowired
  MovieService movieService;

  @Autowired
  MovieTheatreService movieTheatreService;

  @Autowired
  BookingService bookingService;

  List<City> cities = Arrays.asList(new City("Patna"), new City("Mumbai"), new City("Kolkata"), new City("Bangalore"));
  List<UserType> userTypes = Arrays.asList(new UserType("Customer"), new UserType("Admin"));
  List<Language> languages = Arrays.asList(new Language("English"), new Language("Hindi"), new Language("Bengali"));
  List<Status> statuses = Arrays.asList(new Status("Upcoming"), new Status("Released"), new Status("Blocked"));

  User customer = new User();
  Theatre theatre1 = new Theatre();
  Theatre theatre2 = new Theatre();
  Movie movie1 = new Movie();
  Movie movie2 = new Movie();
  MovieTheatre movieTheatre1 = new MovieTheatre();

  public void addCustomer() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
    customer.setFirstName("Emma");
    customer.setLastName("Stone");
    customer.setUsername("emma123stone");
    customer.setPassword("emma@amme");
    customer.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));
    customer.setUserType(userTypes.get(0));
    customer.setLanguage(languages.get(0));
    customer = customerService.acceptUserDetails(customer);
  }

  public void addTheatres(){
    theatre1.setTheatreName("Urvashi Cinema");
    theatre1.setTicketPrice(500);
    theatre1.setCity(cities.get(0));
    theatre1 = theatreService.acceptTheatreDetails(theatre1);

    theatre2.setTheatreName("Cinepolis Multiplex");
    theatre2.setTicketPrice(600);
    theatre2.setCity(cities.get(1));
    theatre2 = theatreService.acceptTheatreDetails(theatre2);
  }

  public void addMovies(){
    movie1.setMovieName("Avengers: Infinity War");
    movie1.setMovieDescription("The Avengers must stop Thanos, an intergalactic warlord, " +
        "from getting his hands on all the infinity stones.");
    movie1.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
    movie1.setDuration(150);
    movie1.setCoverPhotoUrl("cover-photo-url");
    movie1.setTrailerUrl("trailer-url");
    movie1.setStatus(statuses.get(0));
    movie1 = movieService.acceptMovieDetails(movie1);

    movie2.setMovieName("Avengers: Endgame");
    movie2.setMovieDescription("After Thanos, an intergalactic warlord, disintegrates half of " +
        "the universe, the Avengers must reunite and assemble again to reinvigorate their " +
        "trounced allies and restore balance.");
    movie2.setReleaseDate(LocalDateTime.of(2019, 4, 26, 5, 30));
    movie2.setDuration(180);
    movie2.setCoverPhotoUrl("cover-photo-url");
    movie2.setTrailerUrl("trailer-url");
    movie2.setStatus(statuses.get(1));
    movie2 = movieService.acceptMovieDetails(movie2);
  }

  private void addMovieTheatre() throws TheatreDetailsNotFoundException, MovieDetailsNotFoundException {

    movieTheatre1.setMovie(movie1);
    movieTheatre1.setTheatre(theatre2);
    movieTheatreService.acceptMovieTheatreDetails(movieTheatre1);
  }

  private void addBooking() throws UserDetailsNotFoundException, MovieTheatreDetailsNotFoundException {
    Booking booking = new Booking();
    booking.setBookingDate(LocalDateTime.of(2019, 1, 8, 0, 10));
    booking.setUser(customer);
    booking.setNoOfSeats(150);
    booking.setMovieTheatre(movieTheatre1);
    bookingService.acceptBookingDetails(booking);
  }

  @Override
  public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException, TheatreDetailsNotFoundException, MovieDetailsNotFoundException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
    cities.forEach(city -> cityDao.save(city));
    userTypes.forEach(userType -> userTypeDao.save(userType));
    languages.forEach(language -> languageDao.save(language));
    statuses.forEach(status -> statusDao.save(status));
    addCustomer();
    addTheatres();
    addMovies();
    addMovieTheatre();
    addBooking();
  }

}

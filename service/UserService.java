package com.vishwa.movieBookingSystem.service;

import com.vishwa.movieBookingSystem.entities.User;
import com.vishwa.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.vishwa.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;


public interface UserService {

  public User acceptUserDetails(User user)
      throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

  public User getUserDetails(int id) throws UserDetailsNotFoundException;

  public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

  public User updateUserDetails(int id, User user)
      throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;
}

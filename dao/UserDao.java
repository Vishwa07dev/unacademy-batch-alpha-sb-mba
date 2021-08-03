package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {
  public Optional<User> findByUsername(String username);
}

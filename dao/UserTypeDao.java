package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.UserType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserTypeDao extends JpaRepository<UserType, Integer> {
  public Optional<UserType> findByUserTypeName(String userTypeName);
}

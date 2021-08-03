package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusDao extends JpaRepository<Status, Integer> {
  public Status findByStatusName(String statusName);
}

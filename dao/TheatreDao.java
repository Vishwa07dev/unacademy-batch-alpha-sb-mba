package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Theatre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TheatreDao extends JpaRepository<Theatre, Integer> {
  public List<Theatre> findByTheatreName(String theatreName);
  public List<Theatre> findByTicketPriceLessThan(float price);
  public List<Theatre> findByTheatreNameContaining(String theatreName);
}

package com.vishwa.movieBookingSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class City {
  @Id
  @GeneratedValue
  private int cityId;

  @Column(length = 20, nullable = false)
  private String cityName;

  @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
  @JsonBackReference
  private Set<Theatre> theatres;

  public City() {}


  public City(int cityId, String cityName) {
    this.cityId = cityId;
    this.cityName = cityName;
  }

  public City(String cityName) {
    this.cityName = cityName;
  }

  public Set<Theatre> getTheatres() {
    return theatres;
  }

  public void setTheatres(Set<Theatre> theatres) {
    this.theatres = theatres;
  }

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  @Override
  public String toString() {
    return "City{" + "cityId=" + cityId + ", cityName='" + cityName + '\'' + '}';
  }
}

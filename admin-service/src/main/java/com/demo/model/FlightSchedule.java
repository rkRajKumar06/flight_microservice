package com.demo.model;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FlightSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@ManyToOne(cascade = CascadeType.ALL)
    private FlightDetails flightDetails; //Reference to FlightDetails FK
    private String fromPlace;
    private String toPlace;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private double price;
    private String day;
    private boolean nonVeg=false;
    private boolean veg=false;
    private int availableBusinessClassSeats;
    private int availableEconomyClassSeats;
    private boolean blocked=false;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FlightDetails getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public boolean isNonVeg() {
		return nonVeg;
	}
	public void setNonVeg(boolean nonVeg) {
		this.nonVeg = nonVeg;
	}
	public boolean isVeg() {
		return veg;
	}
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	public int getAvailableBusinessClassSeats() {
		return availableBusinessClassSeats;
	}
	public void setAvailableBusinessClassSeats(int availableBusinessClassSeats) {
		this.availableBusinessClassSeats = availableBusinessClassSeats;
	}
	public int getAvailableEconomyClassSeats() {
		return availableEconomyClassSeats;
	}
	public void setAvailableEconomyClassSeats(int availableEconomyClassSeats) {
		this.availableEconomyClassSeats = availableEconomyClassSeats;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
    
}
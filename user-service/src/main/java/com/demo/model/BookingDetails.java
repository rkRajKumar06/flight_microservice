package com.demo.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookingDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pnr;
    private int flightDetails1; //Reference to FlightDetails 1 for oneway trip
    private int flightDetails2; //Reference to FlightDetails 1 for round trip
    private int noOfPersons;
    private double amount;  // to store with out discount
    private double totalAmount;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String email;
    private String fromPlace;
    private String toPlace;
    @OneToMany
    private List<Passengers> passengerList;  // Reference to Passengers List FK
    private boolean cancelled=false;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public int getFlightDetails1() {
		return flightDetails1;
	}
	public void setFlightDetails1(int flightDetails1) {
		this.flightDetails1 = flightDetails1;
	}
	public int getFlightDetails2() {
		return flightDetails2;
	}
	public void setFlightDetails2(int flightDetails2) {
		this.flightDetails2 = flightDetails2;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public List<Passengers> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passengers> passengerList) {
		this.passengerList = passengerList;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
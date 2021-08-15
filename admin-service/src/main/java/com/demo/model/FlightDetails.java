package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FlightDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Airlines airlines; //Reference to Airlines Foreign Key
    private String flightNo;
    private int businessClassSeats;
    private int economyClassSeats;
    private boolean blocked=false;
    
    @OneToMany(mappedBy = "flightDetails")
    private List<FlightSchedule> flightSchedules;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Airlines getAirlines() {
		return airlines;
	}
	public void setAirlines(Airlines airlines) {
		this.airlines = airlines;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public int getBusinessClassSeats() {
		return businessClassSeats;
	}
	public void setBusinessClassSeats(int businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}
	public int getEconomyClassSeats() {
		return economyClassSeats;
	}
	public void setEconomyClassSeats(int economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
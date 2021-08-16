package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details")
public class FlightDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private int airlines; //Reference to Airlines Foreign Key
    private String flightNo;
    private int businessClassSeats;
    private int economyClassSeats;
    private boolean blocked=false;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAirlines() {
		return airlines;
	}
	public void setAirlines(int airlines) {
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
	@Override
	public String toString() {
		return "FlightDetails [id=" + id + ", airlines=" + airlines + ", flightNo=" + flightNo + ", businessClassSeats="
				+ businessClassSeats + ", economyClassSeats=" + economyClassSeats + ", blocked=" + blocked
				+ "]";
	}
	
	
}
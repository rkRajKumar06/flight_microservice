package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airlines{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean blocked = false;
    
    @OneToMany(mappedBy = "airlines",cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
    	      CascadeType.REFRESH })
    private List<FlightDetails> flightDetails;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public List<FlightDetails> getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(List<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}
}
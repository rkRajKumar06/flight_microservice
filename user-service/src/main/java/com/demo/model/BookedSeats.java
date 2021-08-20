package com.demo.model;

public class BookedSeats {
	
	private int id;
	private int scheduleID;
	private int bookedSeats;
	private String classtype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public int getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
}

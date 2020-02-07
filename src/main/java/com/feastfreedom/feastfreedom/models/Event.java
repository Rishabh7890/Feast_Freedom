package com.feastfreedom.feastfreedom.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Events")
public class Event {


	private String id;
	private String EventName;
	private String StartDate;
	private String Duration;
	private String Place;
	private List<Users> ContrUsers;
	
	public List<Users> getContrUsers() {
		return ContrUsers;
	}
	public void setContrUsers(List<Users> contrUsers) {
		ContrUsers = contrUsers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}

	
}
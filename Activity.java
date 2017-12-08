package com.pluralsight.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private String Id;	
	private String Description;
	private int Duration;
	private User user;
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@XmlElement(name="desc")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	
	
}

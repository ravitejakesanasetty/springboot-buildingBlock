package com.stackSimplity.restServices.Hello;

public class userDetails {
   private String firstName;
   private String lastName;
   private String city;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public userDetails(String firstName, String lastName, String city) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.city = city;
}
public userDetails() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}

package com.example.SpringBoot.v1;

public class Name {

	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return "name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

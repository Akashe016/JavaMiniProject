package com.example.EmployeeManagement.model;

public class EmployeeDAO {

private int id;
private String name;
private String email;
private String username;


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public EmployeeDAO() {
	
	
}
public EmployeeDAO(int id,String name,String email,String username) {
	
	super();
	this.id=id;
	this.name=name;
	this.email=email;
	this.username=username;
	
}

@Override
public String toString() {
	return "EmployeeDAO [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username+"]";
}	
}

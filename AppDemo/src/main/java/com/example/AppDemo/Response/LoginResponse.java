package com.example.AppDemo.Response;

public class LoginResponse {

	String meassage;
	boolean status;
	
	public LoginResponse(String meassage, boolean status) {
		this.meassage = meassage;
		this.status = status;
	}
	public LoginResponse() {
	}
	
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [meassage=" + meassage + ", status=" + status + "]";
	}
}
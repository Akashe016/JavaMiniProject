package com.example.AccountDetails.response;


public class AccountResponse {

	private String message;
	private boolean status;
	
	public AccountResponse(String message, boolean status) {
	
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", status=" + status + "]";
	}
}

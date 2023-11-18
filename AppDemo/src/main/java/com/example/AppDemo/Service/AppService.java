package com.example.AppDemo.Service;

import com.example.AppDemo.DAO.AppDAO;
import com.example.AppDemo.DAO.LoginDAO;
import com.example.AppDemo.Response.LoginResponse;

public interface AppService {
	
	public String appView();
	String register(AppDAO appdao);
	LoginResponse loginEmployee(LoginDAO logindao);
	
}

package com.example.AppDemo.Service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.AppDemo.DAO.AppDAO;
import com.example.AppDemo.DAO.LoginDAO;
import com.example.AppDemo.Entity.AppEntity;
import com.example.AppDemo.Repository.AppRepository;
import com.example.AppDemo.Response.LoginResponse;
import com.example.AppDemo.Service.AppService;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	public AppRepository appRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	// This is demo method
	@Override
	public String appView() {
		
		return "View";
	}
	
	// This is register form
	@Override
	public String register(AppDAO appdao) {
	
		AppEntity app = new AppEntity();
			
		app.setEmail(appdao.getEmail());
		app.setPassword(appdao.getPassword());
		app.setConfirm_password(appdao.getConfirm_password());
		
		appRepository.save(app);
		
		return "Registered";
	}

	// This is login form 
	@Override
	public LoginResponse loginEmployee(LoginDAO logindao) {

		 AppEntity appEntity = appRepository.findByEmail(logindao.getEmail());// goto login class and get the email 
	        if(appEntity != null) { // if condition email is correct 
	        	
	        	String password = logindao.getPassword(); //  login password 
	            String encodedPassword = appEntity.getPassword(); // Entity password
	            
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);  // compare two password in boolean type
	            
	            if (isPwdRight) { // if condition is true then password is correct
	            	
	            	// goto repository class and check the email and password is correct then execute the condition
	            	// and then email or password is not correct so, login failed
	            	Optional<AppEntity> appOptional = appRepository.findOneByEmailAndPassword(logindao.getEmail(), encodedPassword);
	             
	                if (appOptional.isPresent()) { // if email and password is present then execute the if condition
	                    return new LoginResponse("Login Success", true);
	                    
	                } else {
	                    return new LoginResponse("Login Failed", false);
	                }
	            }
	            
	            else {
	 
	                return new LoginResponse("password Not Match", false);
	            }
	            
	        }else {
	            return new LoginResponse("Email not exits", false);
	        }
	}
}
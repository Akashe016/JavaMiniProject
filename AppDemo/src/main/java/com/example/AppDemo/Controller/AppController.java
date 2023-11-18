package com.example.AppDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.AppDemo.DAO.AppDAO;
import com.example.AppDemo.DAO.LoginDAO;
import com.example.AppDemo.Response.LoginResponse;
import com.example.AppDemo.Service.impl.AppServiceImpl;

@RestController
@RequestMapping("app")
public class AppController {

	@Autowired
	AppServiceImpl appServiceImpl;
	
	@GetMapping("/hello")
	public String view() {
		
		return appServiceImpl.appView();
		
	}	
	
	@PostMapping("/add")
	public String registererd(@RequestBody AppDAO appdao) {
		
		return appServiceImpl.register(appdao);
	}
	
	
	
	@PostMapping("/log")
	public ResponseEntity<?> loginform(@RequestBody LoginDAO logindao){
		
		LoginResponse loginResponse = appServiceImpl.loginEmployee(logindao);
		return ResponseEntity.ok(loginResponse);
			
	}
}
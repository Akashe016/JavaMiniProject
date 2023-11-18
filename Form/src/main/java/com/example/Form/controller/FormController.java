package com.example.Form.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Form.DAO.FormDAO;
import com.example.Form.entity.FormEntity;
import com.example.Form.service.impl.FormServiceImpl;

@RestController
@RequestMapping("api")
@CrossOrigin
public class FormController {
	
	@Autowired
	public FormServiceImpl formServiceImpl;
	
	@GetMapping("/view")
	public String form() {
		
		return formServiceImpl.view();
	}
	
	@PostMapping("/Register")
	public String register(@RequestBody FormDAO formdao) {

		return formServiceImpl.register(formdao);
	}
	/*
	@PostMapping("/Login")
	public String login(@RequestBody FormDAO formdao){
		
		return formServiceImpl.login(formdao);
	}
	*/
	
	@GetMapping("/email")
	public List<FormEntity> select(String email) {
		
		return formServiceImpl.findBymail(email);
	}
}

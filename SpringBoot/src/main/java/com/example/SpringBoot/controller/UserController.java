package com.example.SpringBoot.controller;

import java.net.URI;
import java.security.Provider.Service;
import java.util.List;
import java.util.Locale;

import org.aspectj.weaver.loadtime.DefaultMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.SpringBoot.bean.HelloBean;
import com.example.SpringBoot.bean.User;
import com.example.SpringBoot.service.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

	private UserService service;
	 
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		
		User saveUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/retriveAll")
	public List<User> findAlls() {
		
		return service.findAll();
	}
	 
	@GetMapping("/retrive/{id}")
	public User findById(@PathVariable int id){
	
		return service.findId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		
		service.delete(id); 
	}	
}
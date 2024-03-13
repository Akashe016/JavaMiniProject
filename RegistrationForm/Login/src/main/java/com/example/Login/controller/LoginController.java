package com.example.Login.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Login.entity.Form;
import com.example.Login.entity.User;
import com.example.Login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/account")
	public String account(@ModelAttribute("user") User user) {
		return "account";
	}

	@PostMapping("/account")
	public String accountCreate(@ModelAttribute("user") User user, Model model) {
		
        return loginService.singup(user,model);
	}
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("user") User user) {
	
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user,Model model) {
		
		return loginService.singIn(user,model);
	}
	
	@GetMapping("/form") 
	public String formpage(@ModelAttribute("form") Form form) { 
		  
		return "form"; 
	} 
	
	@PostMapping("/form")
	public String form(@ModelAttribute("form") Form form, Model model){
	
		return loginService.applicationForm(form,model);
	}
	
	@GetMapping("/email")
	public String emailpage(@ModelAttribute("user") User user) {
	
		return "email";
	}
	
	@PostMapping("/email")	
	public String sendemail(@ModelAttribute("user") User user) {
		
		loginService.sendemail(user);

		return "otp";
	}
	
	@PostMapping("/otp")
	public String otp(@ModelAttribute("user") User user, Model model) {
			
		return loginService.otp(user,model);
	}
	
	@GetMapping("/password")
	public String pass(@ModelAttribute("user") User user) {
		
		return "password";
	}
	
	@PostMapping("/password")
	public String password(@ModelAttribute("user") User user, Model model) {

		return loginService.password(user,model);
	}
	
	@GetMapping("/form/regno")
	public List<Form> findByReg(@RequestParam String regnumber) {
		
		return loginService.regno(regnumber);
	}
	
	@GetMapping("/allaccount")
	public List<User> allAccount() {
		
		return loginService.selectAll();
	}
	
	@DeleteMapping("/LogOut")
	public String deleteAccount(int id) {
		
		return loginService.logOut(id);
	}
}
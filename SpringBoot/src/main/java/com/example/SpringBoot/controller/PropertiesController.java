package com.example.SpringBoot.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {
	
	private MessageSource messageSource;

	public PropertiesController(MessageSource messageSource) { 
		  this.messageSource =messageSource; 
	}
	
	 @GetMapping("/properties") 
	 public String properties() {
	  
	 Locale locale = LocaleContextHolder.getLocale();
	  
	 return messageSource.getMessage("good.morning.message", null,"Default Message",locale); }
	 

}

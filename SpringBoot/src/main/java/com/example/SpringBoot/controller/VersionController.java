package com.example.SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.v1.Name;
import com.example.SpringBoot.v1.version1;
import com.example.SpringBoot.v1.version2;

@RestController
public class VersionController {

	@GetMapping("/name")
	public version1 name() {
		
		return new version1("Akash");
	}

	@GetMapping("/names")
	public version2 name1() {
		
		return new version2(new Name("E","Akash"));
	}
	
	@GetMapping(path = "/name", params = "version=1")
	public version1 nameParam() {
		
		return new version1("Akash");
	}
	
	@GetMapping(path = "/name", params = "version=2")
	public version2 nameParam1() {
		
		return new version2(new Name("E","Akash"));
	}
	
	@GetMapping(path = "/name/header", headers = "Api-header=1")
	public version1 nameHeader() {
		
		return new version1("Akash");
	}
	
	@GetMapping(path = "/name/header", headers = "Api-header=2")
	public version2 nameHeader1() {
		
		return new version2(new Name("E","Akash"));
	}
	
	@GetMapping(path = "/name/accept", produces = "application/vnd.company.app-v1+json")
	public version1 nameAccept() {
		
		return new version1("Akash");
	}
	
	@GetMapping(path = "/name/accept", produces = "application/vnd.company.app-v2+json")
	public version2 nameAccept1() {
		
		return new version2(new Name("E","Akash"));
	}
}
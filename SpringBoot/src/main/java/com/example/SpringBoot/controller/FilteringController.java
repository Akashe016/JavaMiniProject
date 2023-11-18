package com.example.SpringBoot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.bean.Bean;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public Bean method() {
	
		return new Bean("values1","values2","values3");
	}
	
	@GetMapping("/filter-list")
	public List<Bean> method1() {
	
		return Arrays.asList(new Bean("values1","values2","values3"), new Bean("values4","values5","value6"));
	}
}

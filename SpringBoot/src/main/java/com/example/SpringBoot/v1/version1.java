package com.example.SpringBoot.v1;

public class version1 {

	private String name;
	
	public version1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "version1 [name=" + name + "]";
	}	
}

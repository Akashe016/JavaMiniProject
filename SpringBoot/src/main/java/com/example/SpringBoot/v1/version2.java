package com.example.SpringBoot.v1;


public class version2 {
	
	private Name names;

	public version2(Name name) {
		this.names = name;
	}

	public Name getName() {
		return names;
	}

	@Override
	public String toString() {
		return "version2 [name=" + names + "]";
	}
}

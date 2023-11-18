package com.example.onetoonedemo.Service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onetoonedemo.Entity.Customer;
import com.example.onetoonedemo.Entity.User;
import com.example.onetoonedemo.Repository.CustomerRepository;
import com.example.onetoonedemo.Repository.UserRepository;
import com.example.onetoonedemo.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// save all the customer records 
	
	public Customer details(Customer customer) {
	
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        
	     // Format the date and time as a string
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	     String DateAndTime = currentDateTime.format(formatter);
	     customer.setDateAndTime(DateAndTime);
	        
		return customerRepository.save(customer);
		
	}
	
	// save all the service man records
	
	public User saveAll(User user) {
		
		return userRepository.save(user);
	}
	
	// update particular person by id
	@Override
	public void update(User user) {
		
		//userRepository.findById(user.getId());
		
		user.setId(user.getId());
		user.setName(user.getName());
		user.setMobile_no(user.getMobile_no());
		user.setWork(user.getWork());
		user.setAddress(user.getAddress());
		user.setCity(user.getCity());	
		user.setPincode(user.getPincode());
		
		userRepository.save(user);
	}

	// this method is used for show particular person by id;
	public Optional<User> findById(Long id) {
	    return userRepository.findById(id);
	  }
	
	// This method is delete the user record
	@Override
	public String delete(Long id) {
		
		userRepository.deleteById(id);
		return "Data deleted";
	}
	
	//	This method show the all records from the database
	public List<User> findAlls() {

		return userRepository.findAll();
	}
	
	//	This two methods has defined first one user enter the only pincode and show the details and 
	//	next one user the work type and pincode and show the details 
	
	@Override
	public List<User> findpincode(String pincode) {
		
		return userRepository.findByPincode(pincode);
	}
	
	public List<User> findId(String work,String pincode){
		
		List<User> users = userRepository.findByWorkAndPincode(work,pincode);
		
		return users;
	}
	
	// This method read the all record from any file and store the database
	public String savaAllData() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/excel.csv"));
		
		String line=reader.readLine();
		String next[] = line.split(".");
		
		while(line!=null) {
			
			String list[] = line.split(",");
			User user = new User();

			user.setName(list[0]);
			user.setMobile_no(list[1]);
			user.setWork(list[2]);
			user.setAddress(list[3]);
			user.setCity(list[4]);
			user.setPincode(list[5]);
		
			userRepository.save(user);
			line=reader.readLine();
		}
		return "Data upload successfully";
	}
	
/*
	@Override
	public String file(User user) throws IOException {
		
		File files = new File("/home/aakash/totow.txt");
		
		FileReader read = new FileReader(files);
		BufferedReader bread = new BufferedReader(read);
		
		String s = bread.readLine();
		
		while(s!=null) {
			
			String split[] = s.split("[,]");
			
			for(int i=0;i<split.length;i++) {
				
				int dot1 = split[i].lastIndexOf(":");
				String s1 = split[i].substring(dot1+1);
				
				if(split[i].equals(split)) {
					
					user.setName(split[i]);
				}
				else if(split[i].equals(split[i].length()==10)) {
					
					Long num =Long.parseLong(split[i]);
				
					user.setMobile_no(num);
				}
				else if(split[i].equals("chennai")) {
					user.setAddress(split[i]);
				}
				else if(split[i].equals(split[i].length()==6)) {
					
					int pin = Integer.parseInt(split[i]);
					user.setPincode(pin);
				}
			}
			userRepository.save(user);
			
			String split1[] = s.split("[.]");
			s = bread.readLine();	
		}
		return "uploadfile successfully";
	}*/
}
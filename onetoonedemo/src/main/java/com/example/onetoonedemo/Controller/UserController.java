package com.example.onetoonedemo.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.onetoonedemo.Entity.Customer;
import com.example.onetoonedemo.Entity.User;
import com.example.onetoonedemo.Service.impl.UserServiceImpl;

@RestController
@RequestMapping("/totow")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/customer")
	public Customer customerData(@RequestBody Customer customer) {
		
		return userServiceImpl.details(customer);
	}
	
	@PostMapping("/save")
	public User savedata(@RequestBody User user) {
		 
		return userServiceImpl.saveAll(user);
	}
	
	@PutMapping("/update")
	public void updatedata(@RequestBody User user) {
		
		 userServiceImpl.update(user);
	}
	
	@DeleteMapping("/delete")
	public String deletedata(@RequestParam Long id) {
		
		return userServiceImpl.delete(id);
	}
	
	 @PostMapping("/uploadfile")
	 public String data() throws IOException {
		 
		 return userServiceImpl.savaAllData();	 
	 }
	
	@GetMapping("/pincode")
	public List<User> selectWorkAndPincode(String work,String pincode){
		
		return userServiceImpl.findId(work,pincode);
	}
	
	@GetMapping("/pincodes")
	public List<User> selectpincode(String pincode){
		
		return userServiceImpl.findpincode(pincode);
	}
	
	
	@GetMapping("/selectall")
	public List<User> selectAll(){
		return userServiceImpl.findAlls();	
	}
	
	
	/*
	@PutMapping("/users/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
	    Optional<User> user = userServiceImpl.findById(id);
	    if (user.isPresent()) {
	      User updatedUser = userServiceImpl.saveAll(userDetails);
	      return ResponseEntity.ok(updatedUser);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }*/
	
	/*
	 @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] split = line.split(",");

	                User user = new User();
	                user.setName(fields[0]);
	                user.setMobile_no(Long.parseLong(fields[1]));
	                user.setAddress(fields[2]);
	                user.setPincode(Integer.parseInt(fields[4]));

	                User user = new User();
	                
	                for(int i=0;i<split.length;i++) {
	    				
	    				int dot1 = split[i].lastIndexOf(":");
	    				String s1 = split[i].substring(dot1+1);
	    				
	    				user.setName(split[0]);
	 	                user.setMobile_no(Long.parseLong(split[1]));
	 	                user.setAddress(split[2]);
	 	                user.setPincode(Integer.parseInt(split[4]));
	    				
	 	                
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
	    				
	    				//System.out.println(s1);
	    			}
	                userRepository.save(user);
	            }

	            reader.close();
	            return ResponseEntity.ok("File uploaded successfully");
	        } catch (IOException e) {
	           e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
	        }
	    }
	    */
}
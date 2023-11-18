package com.example.onetoonedemo.Service;

import java.util.List;
import com.example.onetoonedemo.Entity.Customer;
import com.example.onetoonedemo.Entity.User;

public interface UserService {
	
	public Customer details(Customer customer);
	public User saveAll(User user);
	public void update(User user);
	public String delete(Long id);
	public List<User> findAlls();
	public List<User> findpincode(String pincode);
	public List<User> findId(String work,String pincode);
	//public String file(User user) throws IOException;
}

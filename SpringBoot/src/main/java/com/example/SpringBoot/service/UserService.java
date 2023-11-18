package com.example.SpringBoot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import com.example.SpringBoot.bean.User;

@Component
public class UserService {

	private static List<User> users = new ArrayList<>();
	
	private static int count = 0;
	
	static {
		
		users.add(new User(++count, "akash", LocalDate.now().minusYears(30)));
		users.add(new User(++count, "sathyan", LocalDate.now().minusYears(30)));
		users.add(new User(++count, "vinth", LocalDate.now().minusYears(30)));
	}
	
	public User save(User user) {
		
		user.setId(++count);
		users.add(user);
		
		return user;
	}
	
	public List<User> findAll() {
	
		return users;
	}

	public User findId(int id) {
		
		Predicate<? super User> predicate = user -> String.valueOf(user.getId()).equals(id);
		
		return users.stream().filter(predicate).findFirst().get();
	}	
	
	public void delete(int id) {
		
		Predicate<? super User> predicate = user -> String.valueOf(user.getId()).equals(id);
		
		users.removeIf(predicate);

		
	}
}




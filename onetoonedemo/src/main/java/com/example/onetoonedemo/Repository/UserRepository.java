package com.example.onetoonedemo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.onetoonedemo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	List<User> findByPincode(String pincode);
	List<User> findByWorkAndPincode(String work,String pincode);

}
package com.example.Login.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.Login.entity.User;

@EnableJpaRepositories
@Repository
public interface LoginRepository extends JpaRepository<User, Integer>{


	List<User> findByUsername(String email);
	
	Optional<User> findByUsernameAndPassword(String email, String password);


}


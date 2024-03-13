package com.example.Login.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.Login.entity.Form;

@EnableJpaRepositories
@Repository
public interface FormRepository extends JpaRepository<Form, Integer>{
	
	List<Form> findByregnumber(String regnumber);
	
	List<Form> findByemail(String email);

}

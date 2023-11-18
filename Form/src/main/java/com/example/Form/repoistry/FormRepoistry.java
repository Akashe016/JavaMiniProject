package com.example.Form.repoistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.Form.entity.FormEntity;

@Repository
public interface FormRepoistry extends JpaRepository<FormEntity, Integer>{
	
	/*
	//@Query("select * from Form where email =:email")
	@Query("SELECT t FROM Form t WHERE t.email = 'email'")
	public List findByEmail();
	*/
	
	@Query("select * from form where email=email")
	public List findByEmail(@Param("mail") String email);
	@Query("select * from form where password='pass'")
	public List findByPassword(@Param("pass") String password);
	
}

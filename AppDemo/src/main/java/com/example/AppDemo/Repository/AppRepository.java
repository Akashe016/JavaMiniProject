package com.example.AppDemo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.AppDemo.Entity.AppEntity;

@EnableJpaRepositories
@Repository
public interface AppRepository extends JpaRepository<AppEntity, Integer>{

	Optional<AppEntity> findOneByEmailAndPassword(String email, String encodedPassword);
	AppEntity findByEmail(String email);
	
}

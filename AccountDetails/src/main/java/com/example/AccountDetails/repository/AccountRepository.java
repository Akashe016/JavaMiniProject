package com.example.AccountDetails.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.AccountDetails.model.AccountEntity;

@EnableJpaRepositories
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

	
	List<AccountEntity> findByPhoneNumber(Long phoneNumber);

	List<AccountEntity> findByPinNumberAndPhoneNumber(int pinNumber,Long phoneNumber);
	
	Optional<AccountEntity> findByPinNumber(int pinNumber);

}

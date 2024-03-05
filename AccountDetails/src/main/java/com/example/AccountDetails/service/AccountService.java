package com.example.AccountDetails.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AccountDetails.model.AccountEntity;
import com.example.AccountDetails.repository.AccountRepository;
import com.example.AccountDetails.response.AccountResponse;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public AccountResponse account(AccountEntity accountEntity) {
		
		accountEntity.setName(accountEntity.getName());
		accountEntity.setPinnumber(accountEntity.getPinnumber());
		accountEntity.setPhoneNumber(accountEntity.getPhoneNumber());
		accountEntity.setDeposite(accountEntity.getDeposite());
		accountEntity.setBalance(accountEntity.getDeposite());
		
		if(checkFindByPhoneNumber(accountEntity.getPhoneNumber())==true) {
			
			accountRepository.save(accountEntity);
			
			return new AccountResponse("Account create successfully", true);
		}
		else {
			
			return new AccountResponse("This phone number already registed! and Please try different phone number", false);
		}
	}	
	
	public List<AccountEntity> balance(int pinNumber,Long phoneNumber) {
		
		List<AccountEntity> user = accountRepository.findByPinNumberAndPhoneNumber(pinNumber,phoneNumber);

		return user;
	}
	
	public AccountResponse pinExchange(AccountEntity accountEntity) {
		
		if((checkFindByPinNumber(accountEntity.getPinnumber()))==true) {
			
						
			List<AccountEntity> user = accountRepository.findByPhoneNumber(accountEntity.getPhoneNumber());
			
			ArrayList al = new ArrayList<>();
			int count=0; 
			
			for(Object ob : user) {
			
				count++;
				al.add(ob);
			}
			String s2[] = new String[count];
			Object s = al.get(0);				
			String s1 = String.valueOf(s);
			
			String split[] = s1.split(",");
			String c[] = new String[split.length];
							
			for(int i=0;i<split.length;i++) {
			
				String a = split[i];	
				String split1[] = a.split("=");
				c[i]= split1[1];
			}				
			String id = c[0]; 
			String names = c[1];
			String amount = c[5]; 
			String bal = c[7];
			String draw = c[4]; 

			accountEntity.setId((long) Integer.parseInt(id));
			accountEntity.setName(names);
			accountEntity.setPinnumber(accountEntity.getPinChange());	
			accountEntity.setPhoneNumber(accountEntity.getPhoneNumber());
			accountEntity.setWithdraw((long) Integer.parseInt(draw));
			accountEntity.setDeposite((long) Integer.parseInt(amount));
			accountEntity.setPinChange(accountEntity.getPinChange());
			accountEntity.setBalance((long) Integer.parseInt(bal));
			
			accountRepository.save(accountEntity);
			
			return new AccountResponse("Pin Number changed", true);		 
		}
		else {
			
			return new AccountResponse("Pin Number doesn't find!", false);		
		}	
	}
	
	public AccountResponse withdraw(AccountEntity accountEntity) throws IOException {
		
		if(checkFindByPinNumber(accountEntity.getPinnumber())==true) {
			
			if(checkFindByPhoneNumber(accountEntity.getPhoneNumber())==true) {
								
				List<AccountEntity> user = accountRepository.findByPhoneNumber(accountEntity.getPhoneNumber());
				
				ArrayList al = new ArrayList<>();
				int count=0; 
				
				for(Object ob : user) {
				
					count++;
					al.add(ob);
				}
				String s2[] = new String[count];
				Object s = al.get(0);				
				String s1 = String.valueOf(s);
				
				String split[] = s1.split(",");
				String c[] = new String[split.length];
								
				for(int i=0;i<split.length;i++) {
				
					String a = split[i];	
					String split1[] = a.split("=");
					c[i]= split1[1];
				}				
				String id = c[0]; 
				String names = c[1];
				String amount = c[5]; 
				String bal = c[7];
				String pin = c[6]; 

				accountEntity.setId((long) Integer.parseInt(id));
				accountEntity.setName(names);
				accountEntity.setPinnumber(accountEntity.getPinnumber());	
				accountEntity.setPhoneNumber(accountEntity.getPhoneNumber());
				accountEntity.setWithdraw(accountEntity.getWithdraw());
				accountEntity.setDeposite((long) Integer.parseInt(amount));
				accountEntity.setPinChange(Integer.parseInt(pin));
				accountEntity.setBalance((long) Integer.parseInt(bal)-accountEntity.getWithdraw());
			
				accountRepository.save(accountEntity);
				
				return new AccountResponse("Amount withdraw successfully in your account", true);
			}
			else {
				
				return new AccountResponse("Failed! try again", false);
			}
		}
		else {
				return new AccountResponse("Pin number does't match", false);
		}
	}

	public AccountResponse deposit(AccountEntity accountEntity) {
		
		if(checkFindByPinNumber(accountEntity.getPinnumber())==true) {
			
			if(checkFindByPhoneNumber(accountEntity.getPhoneNumber())==true) {
								
				List<AccountEntity> user = accountRepository.findByPhoneNumber(accountEntity.getPhoneNumber());
				
				ArrayList al = new ArrayList<>();
				int count=0; 
				
				for(Object ob : user) {
				
					count++;
					al.add(ob);
				}
				String s2[] = new String[count];
				Object s = al.get(0);				
				String s1 = String.valueOf(s);
				
				String split[] = s1.split(",");
				String c[] = new String[split.length];
								
				for(int i=0;i<split.length;i++) {
				
					String a = split[i];	
					String split1[] = a.split("=");
					c[i]= split1[1];
				}				
				String id = c[0]; 
				String names = c[1];
				String amount = c[4]; 
				String bal = c[7];
				String pin = c[6]; 

				accountEntity.setId((long) Integer.parseInt(id));
				accountEntity.setName(names);
				accountEntity.setPinnumber(accountEntity.getPinnumber());	
				accountEntity.setPhoneNumber(accountEntity.getPhoneNumber());
				accountEntity.setWithdraw((long) Integer.parseInt(amount));
				accountEntity.setDeposite(accountEntity.getDeposite());
				accountEntity.setPinChange(Integer.parseInt(pin));
				accountEntity.setBalance(((long) Integer.parseInt(bal))+accountEntity.getDeposite());
			
				accountRepository.save(accountEntity);
				
				return new AccountResponse("Amount deposit successfully in your account", true);
			}
			else {
				
				return new AccountResponse("Failed! try again", false);
			}
		}
		else {
				return new AccountResponse("Pin number does't match", false);
		}
	}
	
	private boolean checkFindByPhoneNumber(Long phoneNumber) {
		// TODO Auto-generated method stub
		
		List<AccountEntity> user = accountRepository.findByPhoneNumber(phoneNumber);
		
		if(user.contains(phoneNumber)) {

			return false;
		}
		else {
			
			return true;
		}
	}
	
	private boolean checkFindByPinNumber(int pinExchange) {
		// TODO Auto-generated method stub

		Optional<AccountEntity> user = accountRepository.findByPinNumber(pinExchange);

		if(user.isPresent()) {
			
			return true;
		}
		else {
			return false;
		}
	}
}

package com.example.Form.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Form.DAO.FormDAO;
import com.example.Form.entity.FormEntity;
import com.example.Form.repoistry.FormRepoistry;
import com.example.Form.service.FormService;

@Service
public class FormServiceImpl implements FormService {
	
	//private static HashMap<String, String> hm = new HashMap<>();
	
	@Autowired
	FormRepoistry formRepoistry;
	
	@Override
	public String view() {
		
		return "view";
	}

	//@Override
	//public String register(FormDAO formdao) {
		
		//FormEntity user = new FormEntity();
		
		
		/*
		user.setEmail(formdao.getEmail());
		user.setPassword(formdao.getPassword());
		user.setConfirm_password(formdao.getConfirm_password());
		
		if(user.getPassword().equals(user.getConfirm_password())) {
			
			formRepoistry.save(user);
			return "Registered Successfully";
		}
		else {
			
			return "Error, Please check the password";
		}	
	}
	*/
		/*
	@Override
	public String login(FormDAO formdao) {
		
		FormEntity user = new FormEntity();
		
		user.setEmail(formdao.getEmail());
		user.setPassword(formdao.getPassword());
		
			return "Login Successfully";
		
		//return "Incorrect email or password";
	}
*/
	/*@Override
	public List<FormEntity> findBymail(String email) {
		// TODO Auto-generated method stub
		return formRepoistry.findByEmail(email);
	}*/

	/*@Override
	public boolean selectAll(String email,String password) {
		
		 
			formRepoistry.findByEmail(email);
			if(hm.containsKey(email)) {
			  	String strongPassword = hm.get(email);
				if(password.equals(strongPassword)) {
		   			return true;
				}
			}
		 return false;	 
	}
	*/
	
	public String register(FormDAO formdao) {
		
		FormEntity user = new FormEntity();
		
		user.setEmail(formdao.getEmail());
		user.setPassword(formdao.getPassword());
		user.setConfirm_password(formdao.getConfirm_password());
		
		if(user.getPassword().equals(user.getConfirm_password())) {
			
			if(!formRepoistry.findByEmail(user.getEmail()).equals(user.getEmail())) {
				
				formRepoistry.save(user);
				
				return "registed successfully";
			}
		}
		return "You are already registed";
	}

	@Override
	public List<FormEntity> findBymail(String email) {
		
		return formRepoistry.findByEmail(email);
	}

	@Override
	public List<FormEntity> findByPassword(String password) {
		
		return formRepoistry.findByPassword(password);
	}
}

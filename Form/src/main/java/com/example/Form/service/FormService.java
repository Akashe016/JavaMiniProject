package com.example.Form.service;

import java.util.List;
import com.example.Form.entity.FormEntity;

public interface FormService {
	
	public String view();
	//public String register(FormDAO formdao);
	//public String login(FormDAO formdao);
	
	List<FormEntity>findBymail(String email);
	List<FormEntity>findByPassword(String password);
	
}

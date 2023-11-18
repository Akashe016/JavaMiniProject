package com.example.EmployeeManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.EmployeeManagement.entity.EmployeeEntity;
import com.example.EmployeeManagement.model.EmployeeDAO;
import com.example.EmployeeManagement.repoistry.EmployeeRepoistry;
import com.example.EmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

		
		 @Autowired
		 EmployeeRepoistry employeeRepoistry;

		@Override
		public String view() {
			// TODO Auto-generated method stub
			return "View";
		}

		@Override
		public String insert(EmployeeDAO employeedao) {
			
			EmployeeEntity user = new EmployeeEntity();
			
			user.setUsername(employeedao.getUsername());
			//user.setId(employeedao.getId());
			user.setName(employeedao.getName());
			user.setEmail(employeedao.getEmail());
			
			employeeRepoistry.save(user);
			return "insert successfully";
		}

		@Override
		public String update(EmployeeDAO employeedao) {
				
			EmployeeEntity user = new EmployeeEntity();
			
			user.setUsername(employeedao.getUsername());
			user.setId(employeedao.getId());
			user.setName(employeedao.getName());
			user.setEmail(employeedao.getEmail());
			employeeRepoistry.save(user);
			
			return "Update successfully";
		}

		@Override
		public String delete(@RequestParam int id) {
			
			employeeRepoistry.deleteById(id);	
			return "delete Successfully";
		}

		/*
		 * @Override public String select() {
		 * 
		 * employeeRepoistry.findAll();
		 * 
		 * return "Select successfully"; }
		 */

		@Override
		public List<EmployeeEntity> selectAll() {
			
			
			return employeeRepoistry.findAll();
		}
}

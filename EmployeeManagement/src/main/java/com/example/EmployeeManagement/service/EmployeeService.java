package com.example.EmployeeManagement.service;

import java.util.List;

import com.example.EmployeeManagement.entity.EmployeeEntity;
import com.example.EmployeeManagement.model.EmployeeDAO;

public interface EmployeeService {
	
	public String view();
	
	String insert(EmployeeDAO employeedao);
	String update(EmployeeDAO employeeDAO);
	String delete(int id);
	//String select();
	List<EmployeeEntity> selectAll();

}

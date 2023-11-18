package com.example.EmployeeManagement.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagement.entity.EmployeeEntity;
import com.example.EmployeeManagement.model.EmployeeDAO;
import com.example.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {

	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/view")
	public String view(){
		
		return employeeService.view();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody  EmployeeDAO employeeDAO) {
		 
		return employeeService.insert(employeeDAO);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody EmployeeDAO employeeDAO) {
		
		return employeeService.update(employeeDAO);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		
		return employeeService.delete(id);
	}
	
	@GetMapping("/selectAll")
	public List<EmployeeEntity> select() {
		
		return employeeService.selectAll();
	}
	
}
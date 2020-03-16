package com.hiber.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hiber.dao.EmployeeDAO;
import com.hiber.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO empdao;
	
	@GetMapping("/AllEmployees")
	public Optional<Optional<List<Employee>>> getAllemp(){
		
		Optional<List<Employee>> lstofemp=empdao.getAllemp();
		
		return Optional.of(lstofemp);
	}
	
	@GetMapping("/getempById/{eid}")
	public Optional<Optional<Employee>> getempById(@PathVariable("eid")Long eid){
		Optional<Employee> empbyId=empdao.getempById(eid);
		return Optional.of(empbyId);
	}
	
	
	
	
	
}

package com.employee.microservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.entity.EmployeeDetails;

public interface EmployeeDetailsRepoService {
	
	public Employee addEmployee(Employee e);
	public List<EmployeeDetails> addAllEmployees(List<EmployeeDetails> e);
	
	public List<EmployeeDetails> getAllEmployees();
	public EmployeeDetails getEmployeeById(String id);
	public List<EmployeeDetails> getEmployeeByName(String name);
	public List<EmployeeDetails> getEmployeeByManager(String manager);
	
	public String deleteEmployee(String id);
	
	
	public EmployeeDetails updateEmployee(EmployeeDetails e);
	

}

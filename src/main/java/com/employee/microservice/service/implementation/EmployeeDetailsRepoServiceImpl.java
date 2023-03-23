package com.employee.microservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.entity.EmployeeDetails;
import com.employee.microservice.repository.EmployeeDetailsRepo;
import com.employee.microservice.repository.EmployeeLeaveRepo;
import com.employee.microservice.repository.EmployeeLoginRepo;
import com.employee.microservice.service.EmployeeDetailsRepoService;

@Service
public class EmployeeDetailsRepoServiceImpl implements EmployeeDetailsRepoService {

	@Autowired
	EmployeeDetailsRepo employeeRepo;

	@Autowired
	EmployeeLoginRepo emploginRepo;

	@Autowired
	EmployeeLeaveRepo empleaveRepo;

	public Employee addEmployee(Employee e) {
		emploginRepo.save(e.getEmplogin());
		employeeRepo.save(e.getEmpdetails());
		empleaveRepo.saveAll(e.getEmpleave());
		return e;

	}

	@Override
	public List<EmployeeDetails> addAllEmployees(List<EmployeeDetails> e) {
		List<EmployeeDetails> emp = employeeRepo.saveAll(e);
		return emp;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public EmployeeDetails getEmployeeById(String id) {

		return employeeRepo.getById(id);
	}

	@Override
	public List<EmployeeDetails> getEmployeeByName(String name) {

		return employeeRepo.findByName(name);
	}

	@Override
	public List<EmployeeDetails> getEmployeeByManager(String manager) {

		return employeeRepo.findByManager(manager);
	}

	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails e) {

		return employeeRepo.save(e);
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepo.deleteById(id);
		return "Employee with Id" + " " + id + " " + "Deleted";
	}

}

package com.employee.microservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.EmployeeLogin;
import com.employee.microservice.repository.EmployeeLoginRepo;
import com.employee.microservice.security.EmployeeLoginDetails;
import com.employee.microservice.service.EmployeeLoginRepoService;


@Service
public class EmployeeLoginRepoServiceImpl implements EmployeeLoginRepoService {
	@Autowired
	EmployeeLoginRepo employeeLoginRepo;

	@Override
	public EmployeeLogin getEmpLoginDetails(String id) {
		// TODO Auto-generated method stub
		return employeeLoginRepo.findById(id).get();
	}

}

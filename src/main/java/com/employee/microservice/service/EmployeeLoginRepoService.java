package com.employee.microservice.service;

import com.employee.microservice.entity.EmployeeLogin;


public interface EmployeeLoginRepoService {

	public EmployeeLogin getEmpLoginDetails(String id);

}

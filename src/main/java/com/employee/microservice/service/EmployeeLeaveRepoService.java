package com.employee.microservice.service;

import java.util.List;

import com.employee.microservice.entity.EmployeeLeave;

public interface EmployeeLeaveRepoService {
	public List<EmployeeLeave> getEmpLeaveByEmail(String email);

}

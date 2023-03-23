package com.employee.microservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.EmployeeLeave;
import com.employee.microservice.repository.EmployeeLeaveRepo;
import com.employee.microservice.service.EmployeeLeaveRepoService;
@Service
public class EmployeeLeaveRepoServiceImpl  implements EmployeeLeaveRepoService{
	@Autowired
	EmployeeLeaveRepo employeeLeaveRepo;

	@Override
	public List<EmployeeLeave> getEmpLeaveByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeLeaveRepo.getEmpLeaveByEmail(email);
	}

}

package com.employee.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.microservice.entity.EmployeeLeave;

public interface EmployeeLeaveRepo extends JpaRepository<EmployeeLeave,String> {
	
	@Query(value="SELECT * FROM employee_leave WHERE email=?",nativeQuery=true)
	public List<EmployeeLeave> getEmpLeaveByEmail(String email);

}

package com.employee.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.employee.microservice.entity.EmployeeTask;

import jakarta.transaction.Transactional;

public interface EmployeeTaskRepo extends JpaRepository<EmployeeTask, String> {
	
	 @Query(value="SELECT * FROM employee_task where id=?",nativeQuery = true) 
		public List<EmployeeTask> getTaskByEmpId(String id);
	 @Modifying
	 @Transactional
	 @Query(value="UPDATE employee_task SET task_updates=? WHERE task_id=?",nativeQuery = true)
	 public void updateTaskById(String status,String id);

}

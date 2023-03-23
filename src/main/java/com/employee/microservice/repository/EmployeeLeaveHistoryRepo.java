package com.employee.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.employee.microservice.entity.EmployeeLeaveHistory;

import jakarta.transaction.Transactional;

public interface EmployeeLeaveHistoryRepo  extends JpaRepository<EmployeeLeaveHistory,String>{
    @Query(value="SELECT * FROM employee_leave_history where id=?",nativeQuery = true) 
	public List<EmployeeLeaveHistory> getLeaveHistoryByEmpId(String id);
    
    @Modifying
    @Transactional
    @Query(value="UPDATE employee_leave_history SET status=? WHERE leave_history_id=?",nativeQuery = true)
    void updateLeaveStatus(String status,String id);
    
}

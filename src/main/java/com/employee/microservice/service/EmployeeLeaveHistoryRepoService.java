package com.employee.microservice.service;

import java.util.List;

import com.employee.microservice.entity.EmployeeLeaveHistory;

public interface EmployeeLeaveHistoryRepoService {
	
	public String addLeave(EmployeeLeaveHistory empleavehistory);
	public List<EmployeeLeaveHistory> getLeaveHistory(String id);
	public String updateLeaveStatus(String status,String id);

}

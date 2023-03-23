package com.employee.microservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.EmployeeLeaveHistory;
import com.employee.microservice.repository.EmployeeLeaveHistoryRepo;
import com.employee.microservice.service.EmployeeLeaveHistoryRepoService;


@Service
public class EmployeeLeaveHistoryRepoServiceImpl implements EmployeeLeaveHistoryRepoService {

	@Autowired
	EmployeeLeaveHistoryRepo empleavehistoryrepo;
	@Override
	public String addLeave(EmployeeLeaveHistory empleavehistory) {
		empleavehistoryrepo.save(empleavehistory);
		return "LEAVE APPLIED";
	}

	@Override
	public List<EmployeeLeaveHistory> getLeaveHistory(String id) {
		
		List<EmployeeLeaveHistory> employeeLeaveHistories=empleavehistoryrepo.getLeaveHistoryByEmpId(id);
		return employeeLeaveHistories;
	}

	@Override
	public String updateLeaveStatus(String status, String id) {
         empleavehistoryrepo.updateLeaveStatus(status, id);
		return "LEAVE HISTORY UPDATED";
	}

}

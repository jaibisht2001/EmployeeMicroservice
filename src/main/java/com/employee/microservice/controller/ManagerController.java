package com.employee.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.microservice.entity.EmployeeDetails;
import com.employee.microservice.entity.EmployeeTask;
import com.employee.microservice.repository.EmployeeDetailsRepo;
import com.employee.microservice.repository.EmployeeLeaveHistoryRepo;
import com.employee.microservice.service.implementation.EmployeeDetailsRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeLeaveHistoryRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeTaskRepoServiceImpl;

@RestController
@RequestMapping("api/v1/manager")
public class ManagerController {
	@Autowired
	EmployeeDetailsRepoServiceImpl empreposerviceimpl;
	@Autowired
	EmployeeDetailsRepo employeeRepo;
	@Autowired
	EmployeeTaskRepoServiceImpl  emptaskreposerviceimpl;
	
	@Autowired
	EmployeeLeaveHistoryRepo empleavehistoryrepo;
	@Autowired
	EmployeeLeaveHistoryRepoServiceImpl empleavehistoryserviceimpl;
	
	@GetMapping("/get/{manager}")
	public List<EmployeeDetails> getEmployeeByManager(@PathVariable("manager") String manager) {
		List<EmployeeDetails> empman = empreposerviceimpl.getEmployeeByManager(manager);
		return empman;
	}
	
	@PostMapping("/task/add")
	public String addTask(@RequestBody EmployeeTask emptask)
	{
		return emptaskreposerviceimpl.addTask(emptask);
	
	}
	

	@GetMapping("/task/get/alltask")
	public List<EmployeeTask> getAllTask()
	{
		return emptaskreposerviceimpl.getAllTask();
	}
	
	@PutMapping("/leave/update/{status}/{id}")
	public String updateLeaveStatus(@PathVariable("status") String status,@PathVariable("id") String id)
	{
		return empleavehistoryserviceimpl.updateLeaveStatus(status, id);
	}
	
	@GetMapping("/task/get/taskid/{taskId}")
	public EmployeeTask getTaskByTaskId(@PathVariable("taskId") String taskId)
	{
		return emptaskreposerviceimpl.getTaskByTaskId(taskId);
	}
	
	@GetMapping("/task/get/empid/{id}")
	public List<EmployeeTask> getTaskByEmpId(@PathVariable("id") String id)
	{
		return emptaskreposerviceimpl.getTaskByEmpId(id);
	}

}

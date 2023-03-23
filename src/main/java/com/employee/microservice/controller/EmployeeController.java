package com.employee.microservice.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.entity.EmployeeDetails;
import com.employee.microservice.entity.EmployeeLeave;
import com.employee.microservice.entity.EmployeeLeaveHistory;
import com.employee.microservice.entity.EmployeeLogin;
import com.employee.microservice.entity.EmployeeTask;
import com.employee.microservice.jwt.JwtUtils;
import com.employee.microservice.repository.EmployeeDetailsRepo;
import com.employee.microservice.repository.EmployeeLeaveHistoryRepo;
import com.employee.microservice.security.EmployeeLoginDetails;
import com.employee.microservice.security.EmployeeLoginDetailsService;
import com.employee.microservice.service.implementation.EmployeeDetailsRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeLeaveHistoryRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeLeaveRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeLoginRepoServiceImpl;
import com.employee.microservice.service.implementation.EmployeeTaskRepoServiceImpl;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired
	EmployeeDetailsRepoServiceImpl empreposerviceimpl;
	@Autowired
	EmployeeDetailsRepo employeeRepo;
	
	@Autowired
	EmployeeLoginRepoServiceImpl employeeLoginRepoServiceImpl;
	
	@Autowired
	EmployeeLeaveRepoServiceImpl employeeLeaveRepoServiceImpl;
	
	@Autowired
	EmployeeLeaveHistoryRepo empleavehistoryrepo;
	@Autowired
	EmployeeLeaveHistoryRepoServiceImpl empleavehistoryserviceimpl;
	
	@Autowired
	EmployeeTaskRepoServiceImpl emptaskreposerviceimpl;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@Autowired
	JwtUtils jwtutils;
	
	@Autowired
	EmployeeLoginDetailsService emplogindetailsservice;
	
	@Autowired
	EmployeeLeaveRepoServiceImpl empleaveserviceimpl;

	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody EmployeeLogin emplogin)
	{
		String TOKEN=null;
		try {
		Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(emplogin.getId(), emplogin.getPassword()));
		 if(auth.isAuthenticated())
		 {
			 EmployeeLoginDetails emplogindetails=(EmployeeLoginDetails) emplogindetailsservice.loadUserByUsername(emplogin.getId()) ;
			  TOKEN =jwtutils.generateJwtToken(emplogindetails);
			 
		 }
		 return TOKEN;
		
		}catch(Exception e) {
			return "AUTHENTICATION FAILED";
		}
		
	}
	


	@PostMapping("/add/allemployee")
	public List<EmployeeDetails> addAllEmployee(@RequestBody List<EmployeeDetails> e) {
		empreposerviceimpl.addAllEmployees(e);
		return e;
	}

	@GetMapping("/get/allemployee")
	public List<EmployeeDetails> getAllEmployees()

	{
		List<EmployeeDetails> allemp = empreposerviceimpl.getAllEmployees();
		return allemp;

	}

	@GetMapping("/get/id/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		EmployeeDetails emp = empreposerviceimpl.getEmployeeById(id);
		EmployeeLogin emplogiDetails=employeeLoginRepoServiceImpl.getEmpLoginDetails(id);
		List<EmployeeLeave> empleave=employeeLeaveRepoServiceImpl.getEmpLeaveByEmail(emp.getEmail());
		List<EmployeeLeaveHistory> empleavehistory=empleavehistoryserviceimpl.getLeaveHistory(id);
		
		return new Employee(emp,emplogiDetails,empleave,empleavehistory);

	}

	@GetMapping("/get/name/{name}")
	public List<EmployeeDetails> getEmployeeByName(@PathVariable("name") String name) {
		List<EmployeeDetails> empname = empreposerviceimpl.getEmployeeByName(name);
		return empname;
	}

	

	@PutMapping("/update")
	public EmployeeDetails updateEmployee(@RequestBody EmployeeDetails e) {
		return empreposerviceimpl.updateEmployee(e);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") String id) {
		return empreposerviceimpl.deleteEmployee(id);

	}
	@PostMapping("leave/add")
	public String addLeave(@RequestBody EmployeeLeaveHistory empleavehistory)
	{
		return empleavehistoryserviceimpl.addLeave(empleavehistory);
		
	}
	
	@GetMapping("/leavehistory/get/{id}")
	public List<EmployeeLeaveHistory> getLeaveHistory(@PathVariable ("id") String id)
	{
		return empleavehistoryserviceimpl.getLeaveHistory(id);
	}
	
	@GetMapping("/leave/get/{id}")
	public List<EmployeeLeave> getEmpLeaveByEmail(@PathVariable ("id") String id)
	{
		EmployeeDetails emp=empreposerviceimpl.getEmployeeById(id);
		System.out.println(emp.getEmail());
		return empleaveserviceimpl.getEmpLeaveByEmail(emp.getEmail());
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
	
	@PutMapping("/task/update/{status}/{id}")
	public String updateTask(@PathVariable("status") String status,@PathVariable("id") String id)
	{
	
		emptaskreposerviceimpl.updateTask(status,id);
		return "TASK UPDATED";
	}
	
	
	
}



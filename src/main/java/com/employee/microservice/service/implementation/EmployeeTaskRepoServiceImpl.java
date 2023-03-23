package com.employee.microservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.microservice.entity.EmployeeTask;
import com.employee.microservice.repository.EmployeeTaskRepo;
import com.employee.microservice.service.EmployeeTaskRepoService;


@Service
public class EmployeeTaskRepoServiceImpl implements EmployeeTaskRepoService{
	
	@Autowired
	EmployeeTaskRepo emptaskrepo;

	@Override
	public String addTask(EmployeeTask emptask) {
		
		emptaskrepo.save(emptask);
		return "TASK ADDED";
	}

	@Override
	public EmployeeTask getTaskByTaskId(String taskId) {
       
		return emptaskrepo.findById(taskId).get();
	}

	@Override
	public List<EmployeeTask> getTaskByEmpId(String id) {
	List<EmployeeTask> employeeTasks=emptaskrepo.getTaskByEmpId(id);
		return employeeTasks;
	}

	@Override
	public void updateTask(String status,String id) {
		
		emptaskrepo.updateTaskById(status, id);
		 
				
	}

	@Override
	public List<EmployeeTask> getAllTask() {
		
		return emptaskrepo.findAll();
	}

}

package com.employee.microservice.service;

import java.util.List;

import com.employee.microservice.entity.EmployeeTask;

public interface EmployeeTaskRepoService {
	
        public String addTask(EmployeeTask emptask);
        public EmployeeTask getTaskByTaskId(String taskId);
        public List<EmployeeTask> getTaskByEmpId(String id);
        public List<EmployeeTask> getAllTask();
        
        public void updateTask(String status,String id);
   
        
        

}

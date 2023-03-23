package com.employee.microservice.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private EmployeeDetails empdetails;
	private EmployeeLogin emplogin;
	private List<EmployeeLeave>  empleave=new ArrayList<EmployeeLeave>();
	private List<EmployeeLeaveHistory> empleavehistory=new ArrayList<EmployeeLeaveHistory>();
	
	
	
	
	public Employee(EmployeeDetails empdetails, EmployeeLogin emplogin, List<EmployeeLeave> empleave,
			List<EmployeeLeaveHistory> empleavehistory) {
		super();
		this.empdetails = empdetails;
		this.emplogin = emplogin;
		this.empleave = empleave;
		this.empleavehistory = empleavehistory;
	}
	public Employee() {
		
	}
	public EmployeeDetails getEmpdetails() {
		return empdetails;
	}
	public void setEmpdetails(EmployeeDetails empdetails) {
		this.empdetails = empdetails;
	}
	public EmployeeLogin getEmplogin() {
		return emplogin;
	}
	public void setEmplogin(EmployeeLogin emplogin) {
		this.emplogin = emplogin;
	}
	
	
	public List<EmployeeLeave> getEmpleave() {
		return empleave;
	}
	public void setEmpleave(ArrayList<EmployeeLeave> empleave) {
		this.empleave = empleave;
	}
	public List<EmployeeLeaveHistory> getEmpleavehistory() {
		return empleavehistory;
	}
	public void setEmpleavehistory(ArrayList<EmployeeLeaveHistory> empleavehistory) {
		this.empleavehistory = empleavehistory;
	}
	@Override
	public String toString() {
		return "Employee [empdetails=" + empdetails + ", emplogin=" + emplogin + ", empleave=" + empleave
				+ ", empleavehistory=" + empleavehistory + "]";
	}
	
	
	
	

}

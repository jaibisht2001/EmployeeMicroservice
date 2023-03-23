package com.employee.microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_task")
public class EmployeeTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskId")
	private int taskId;

	@Column(name = "id")
	private String id;

	@Column(name = "taskName")
	private String taskName;

	@Column(name = "taskCompletionDate")
	private String taskCompletionDate;

	@Column(name = "taskUpdates")
	private String taskUpdates;

	@Column(name = "managerId")
	private String managerId;

	public EmployeeTask(int taskId, String id, String taskName, String taskCompletionDate, String taskUpdates,
			String managerId) {
		super();
		this.taskId = taskId;
		this.id = id;
		this.taskName = taskName;
		this.taskCompletionDate = taskCompletionDate;
		this.taskUpdates = taskUpdates;
		this.managerId = managerId;
	}

	public EmployeeTask() {
		super();
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCompletionDate() {
		return taskCompletionDate;
	}

	public void setTaskCompletionDate(String taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	public String getTaskUpdates() {
		return taskUpdates;
	}

	public void setTaskUpdates(String taskUpdates) {
		this.taskUpdates = taskUpdates;
	}


	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	

	@Override
	public String toString() {
		return "EmployeeTask [taskId=" + taskId + ", id=" + id + ", taskName=" + taskName + ", taskCompletionDate="
				+ taskCompletionDate + ", taskUpdates=" + taskUpdates + ", managerId=" + managerId + "]";
	}

	

}

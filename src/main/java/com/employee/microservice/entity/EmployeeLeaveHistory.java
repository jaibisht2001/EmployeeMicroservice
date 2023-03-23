package com.employee.microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_leave_history")
public class EmployeeLeaveHistory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="leaveHistoryId")
	private int leaveHistoryId;
    
    @Column(name="id")
	private String id;
    @Column(name="email")
	private String email;
	@Column(name="leaveType")
	private String leaveType;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="status")
	private String status;

	public int getLeaveHistoryId() {
		return leaveHistoryId;
	}

	public void setLeaveHistoryId(int leaveHistoryId) {
		this.leaveHistoryId = leaveHistoryId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployeeLeaveHistory(int leaveHistoryId, String id, String email, String leaveType, String fromDate,
			String toDate, String reason, String status) {
		super();
		this.leaveHistoryId = leaveHistoryId;
		this.id = id;
		this.email = email;
		this.leaveType = leaveType;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
	}

	public EmployeeLeaveHistory() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeLeaveHistory [leaveHistoryId=" + leaveHistoryId + ", id=" + id + ", email=" + email
				+ ", leaveType=" + leaveType + ", fromDate=" + fromDate + ", toDate=" + toDate + ", reason=" + reason
				+ ", status=" + status + "]";
	}

	
	
}

package com.example.timesheet.response;

import com.example.timesheet.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
	
	
	private Long id;
	private String employeeName;
	private String phone;
	private String email;
	private String address;
	private String username;
	private String role;
	
	public EmployeeResponse(Employee employee) {
		this.id=employee.getId();
		this.employeeName=employee.getEmployeeName();
		this.phone=employee.getPhone();
		this.email=employee.getEmail();
		this.address=employee.getAddress();
		this.username=employee.getUsername();
		this.role=employee.getRole();
	}

}

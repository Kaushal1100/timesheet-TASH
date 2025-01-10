package com.example.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.entity.Employee;
import com.example.timesheet.repository.EmployeeRepository;
import com.example.timesheet.request.EmployeeRequest;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllemployee() {
		return employeeRepository.findAll();
	}
	
	
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee employee=new Employee();
		employee.setEmployeeName(employeeRequest.getEmployeeName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setPhone(employeeRequest.getPhone());
		employee.setAddress(employeeRequest.getAddress());
		
		employee=employeeRepository.save(employee);
		
		return employee;
	}

}

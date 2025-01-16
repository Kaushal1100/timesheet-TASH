package com.example.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.timesheet.entity.Employee;
import com.example.timesheet.repository.EmployeeRepository;
import com.example.timesheet.request.EmployeeRequest;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	public List<Employee> getAllemployee() {
		return employeeRepository.findAll();
	}
	
	
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee employee=new Employee();
		employee.setEmployeeName(employeeRequest.getEmployeeName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setPhone(employeeRequest.getPhone());
		employee.setAddress(employeeRequest.getAddress());
		employee.setPassword(employeeRequest.getPassword());
		
		employee=employeeRepository.save(employee);
		
		return employee;
	}


	public Employee registerEmployee(EmployeeRequest employeeRequest) {
			if(employeeRepository.findByUsername(employeeRequest.getEmployeeName()).isPresent()) {
				throw new RuntimeException("Username already exists");
			}
			Employee employee=new Employee();
			employee.setEmployeeName(employeeRequest.getEmployeeName());
			employee.setEmail(employeeRequest.getEmail());
			employee.setPhone(employeeRequest.getPhone());
			employee.setAddress(employeeRequest.getAddress());
		    employee.setUsername(employeeRequest.getUsername());
		    employee.setPassword(employeeRequest.getPassword());
		    employee.setRole(employeeRequest.getRole());
		    return employeeRepository.save(employee);

	}
	
	public boolean validateLogin(String username, String password) {
	    Optional<Employee> employeeOptional = employeeRepository.findByUsername(username);
	    if (employeeOptional.isPresent()) {
	        Employee employee = employeeOptional.get();
	        return password.equals(employee.getPassword());
	    }
	    return false;
	}


}

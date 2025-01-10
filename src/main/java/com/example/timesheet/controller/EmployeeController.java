package com.example.timesheet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.timesheet.entity.Employee;
import com.example.timesheet.request.EmployeeRequest;
import com.example.timesheet.response.EmployeeResponse;
import com.example.timesheet.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	// Can be done with Autowired as well
	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;

	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
		List<Employee> employeeList=employeeService.getAllemployee();
		
		List<EmployeeResponse> employeeResponseList=new ArrayList<>();
		
		 employeeList.stream().forEach(employee -> {
		        employeeResponseList.add(new EmployeeResponse(employee));
		    });
		return ResponseEntity.ok(employeeResponseList);
	}
	
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
		Employee employee=employeeService.createEmployee(employeeRequest);
		EmployeeResponse employeeResponse= new EmployeeResponse(employee);
		
		return new ResponseEntity<>(employeeResponse,HttpStatus.CREATED);
		
	}
	
}

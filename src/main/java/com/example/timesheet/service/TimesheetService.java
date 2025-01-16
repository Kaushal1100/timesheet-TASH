package com.example.timesheet.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timesheet.entity.Employee;
import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.repository.EmployeeRepository;
import com.example.timesheet.repository.TimesheetRepository;
import com.example.timesheet.request.TimesheetRequest;
import com.example.timesheet.response.TimesheetResponse;

@Service
public class TimesheetService {
	@Autowired
	private TimesheetRepository timesheetRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public Timesheet saveTimesheet(TimesheetRequest timesheetRequest) {

		Employee employee = employeeRepository.findById(timesheetRequest.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee Not Found"));
		Timesheet timesheet = new Timesheet();

		timesheet.setEmployee(employee);
		timesheet.setProjectName(timesheetRequest.getProjectName());
		timesheet.setMondayHours(timesheetRequest.getMondayHours());
		timesheet.setTuesdayHours(timesheetRequest.getTuesdayHours());
		timesheet.setWednesdayHours(timesheetRequest.getWednesdayHours());
		timesheet.setThursdayHours(timesheetRequest.getThursdayHours());
		timesheet.setFridayHours(timesheetRequest.getFridayHours());
		timesheet.setSaturdayHours(timesheetRequest.getSaturdayHours());
		timesheet.setSundayHours(timesheetRequest.getSundayHours());
		timesheet.setHourlyRate(timesheetRequest.getHourlyRate());
		
		float totalHours = (timesheetRequest.getMondayHours() + timesheetRequest.getTuesdayHours()
				+ timesheetRequest.getWednesdayHours() + timesheetRequest.getThursdayHours()
				+ timesheetRequest.getFridayHours() + timesheetRequest.getSaturdayHours()
				+ timesheetRequest.getSundayHours());
		timesheet.setTotalHours(totalHours);
		timesheet.setTotalPay(totalHours * timesheetRequest.getHourlyRate());
		timesheet = timesheetRepository.save(timesheet);

		return timesheet;
	}

	public List<Timesheet> alltimeSheet(){
		return timesheetRepository.findAll();
	}

	public List<Timesheet> timesheetById(long employeeId) {
		return timesheetRepository.findByEmployeeId(employeeId);

	}

}

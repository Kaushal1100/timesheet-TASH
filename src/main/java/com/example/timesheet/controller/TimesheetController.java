package com.example.timesheet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.request.TimesheetRequest;
import com.example.timesheet.response.TimesheetResponse;
import com.example.timesheet.service.TimesheetService;
@CrossOrigin("*")
@RestController
public class TimesheetController {

	@Autowired
	private TimesheetService timesheetService;

	@PostMapping("/timesheet")
	public ResponseEntity<TimesheetResponse> createTimesheet(@RequestBody TimesheetRequest timesheetRequest) {
		Timesheet timesheet = timesheetService.saveTimesheet(timesheetRequest);
		TimesheetResponse timesheetResponse = new TimesheetResponse(timesheet);
		return new ResponseEntity<>(timesheetResponse, HttpStatus.CREATED);

	}
	
	@GetMapping("/alltimesheet")
	public ResponseEntity<List<TimesheetResponse>> getTimesheet() {
		
		List<Timesheet> timesheetList=timesheetService.alltimeSheet();
		List<TimesheetResponse> timesheetResponseList = new ArrayList<>();
		timesheetList.forEach(timesheet -> timesheetResponseList.add(new TimesheetResponse(timesheet)));

		return ResponseEntity.ok(timesheetResponseList);

	}

	@GetMapping("/alltimesheet/{employeeId}")
	public ResponseEntity<List<TimesheetResponse>> getTimesheetById(@PathVariable("employeeId") long employeeId) {
		List<Timesheet> timesheets=timesheetService.alltimeSheet();
		List<TimesheetResponse> timesheetResponseList=new ArrayList<>();
		timesheetResponseList=timesheets.stream().map(TimesheetResponse::new).collect(Collectors.toList());
		
		return ResponseEntity.ok(timesheetResponseList);

	}

}

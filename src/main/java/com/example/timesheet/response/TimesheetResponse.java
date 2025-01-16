package com.example.timesheet.response;

import com.example.timesheet.entity.Timesheet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetResponse {
	
	private Long id;
	private String projectName;
	private String employeeName;
	private float totalHours;
	private float totalPay;
	
	public TimesheetResponse(Timesheet timesheet) {
		    this.id = timesheet.getEmployee().getId();
		    this.projectName = timesheet.getProjectName();
	        this.totalHours = timesheet.getTotalHours();
	        this.totalPay = timesheet.getTotalPay();
	        this.employeeName=timesheet.getEmployee().getEmployeeName();
	}
	public TimesheetResponse() {
      
    }
}

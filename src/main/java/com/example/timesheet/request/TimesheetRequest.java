package com.example.timesheet.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetRequest {

	private Long employeeId;
    private String projectName;
    private float mondayHours;
    private float tuesdayHours;
    private float wednesdayHours;
    private float thursdayHours;
    private float fridayHours;
    private float saturdayHours;
    private float sundayHours;

    private float hourlyRate;

}

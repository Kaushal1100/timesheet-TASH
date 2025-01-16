package com.example.timesheet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name="timesheetdetails")
public class Timesheet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "monday_hours")
	private float mondayHours;
	
	@Column(name = "tuesday_hours")
	private float tuesdayHours;
	
	@Column(name = "wednesday_hours")
	private float wednesdayHours;
	
	@Column(name = "thursday_hours")
	private float thursdayHours;
	
	@Column(name = "friday_hours")
	private float fridayHours;
	
	@Column(name = "saturday_hours")
	private float saturdayHours;
	
	@Column(name = "sunday_hours")
	private float sundayHours;

	@Column(name="total_pay")
	private float totalPay;
	
	@Column(name="hourly_rate")
	private float hourlyRate;
	
	@Column(name="total_hours")
	private float totalHours;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;


}

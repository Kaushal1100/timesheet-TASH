package com.example.timesheet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Timesheet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "projectname")
	private String projectName;
	
	@Column(name = "mondayHours")
	private int mondayHours;
	
	@Column(name = "tuesdayHours")
	private int tuesdayHours;
	
	@Column(name = "wednesdayHours")
	private int wednesdayHours;
	
	@Column(name = "thursdayHours")
	private int thursdayHours;
	
	@Column(name = "fridayHours")
	private int fridayHours;
	
	@Column(name = "saturdayHours")
	private int saturdayHours;
	
	@Column(name = "sundayHours")
	private int sundayHours;


}

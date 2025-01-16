package com.example.timesheet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet,Long>{
	 // Method to find timesheets by employeeId
	List<Timesheet> findByEmployeeId(long employeeId);
	

}

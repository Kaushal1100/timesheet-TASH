package com.example.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

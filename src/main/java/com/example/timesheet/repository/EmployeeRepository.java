package com.example.timesheet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timesheet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	Optional<Employee> findByUsername(String username);

}

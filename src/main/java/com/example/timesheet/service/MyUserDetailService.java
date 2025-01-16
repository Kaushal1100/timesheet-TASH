package com.example.timesheet.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.timesheet.entity.Employee;
import com.example.timesheet.repository.EmployeeRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		 return User.builder()
	                .username(employee.getUsername())
	                .password("{noop}"+employee.getPassword())
	                .roles(getRoles(employee))
	                .build();
	    }
		
	private String[] getRoles(Employee user) {
		if(user.getRole()==null) {
			return new String[] {"USER"};
		}
		return user.getRole().split(",");
	}
}
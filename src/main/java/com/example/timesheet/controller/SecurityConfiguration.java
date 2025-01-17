package com.example.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	@Autowired
	private UserDetailsService userDetailService;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		return httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry->{
						registry.requestMatchers("/register","/register/**").permitAll();
						registry.requestMatchers("/admin/**").hasRole("ADMIN");
						registry.requestMatchers("/user/**").hasRole("USER"); 
						registry.requestMatchers("/login","/register").permitAll();
						registry.requestMatchers("/custom-login").permitAll();
						registry.requestMatchers("/alltimesheet").authenticated();
						registry.requestMatchers("/success.html").hasAnyRole("USER","ADMIN");
						registry.anyRequest().authenticated(); 
				})
				.formLogin(form -> form
		                .loginPage("/login") // Custom login page URL
		                .permitAll()) // Allow all to access the login page
		            .build();
//						.formLogin(httpSecurityFormLoginConfigurer ->{
//							httpSecurityFormLoginConfigurer
//							.loginPage("/login")
//							 .defaultSuccessUrl("/success.html", true)
//							.permitAll();
//						})
//						.logout(httpSecurityLogoutConfigurer -> {
//			                httpSecurityLogoutConfigurer
//			                        .logoutUrl("/logout")
//			                        .logoutSuccessUrl("/")
//			                        .permitAll();
//			            })
//						.build();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
//		return 
//	}
	
	
	public UserDetailsService userDetailService() {
		return userDetailService;
	}
	
//	@Bean 
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailService);
////		provider.setPasswordEncoder(passwordEncoder());
//		return provider;
//	}
	
	
}

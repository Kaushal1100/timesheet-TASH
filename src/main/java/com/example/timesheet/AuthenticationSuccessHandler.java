package com.example.timesheet;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        // Check if a saved request exists (for bookmarked URLs or pre-login redirection)
        String targetUrl = getDefaultTargetUrl();
        //Check Which User is logged In 
    	//How does the ROLE validating flows??
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN")); //Comparing with the Role of the user: Format has ROLE in the front

        boolean isUser = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")); // Check if user has ROLE_USER

        // Determine target URL based on role
        if (isAdmin) {
            targetUrl = "/admin/home";
        } else if (isUser) {
            targetUrl = "/user/home";
        }

        // Check for saved request and override target URL if present
        if (request.getSession(false) != null && request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST") != null) {
            targetUrl = request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST").toString();
        }

        setDefaultTargetUrl(targetUrl); // Set the final target URL
        super.onAuthenticationSuccess(request, response, authentication); // Delegate to the parent class
    }
}
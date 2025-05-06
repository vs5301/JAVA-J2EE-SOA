package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implements class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter{
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		if(email.isEmpty() && password.isEmpty()) {
			response.setContentType("text/html");
			String htmlResponse = "<html><body><center>Filter: Invalid Data Sent</center></body></html>";
			
			PrintWriter out = response.getWriter();
			out.print(htmlResponse); // This will be sent back to Client
		}else {
			// pass the request along the filter chain -> attached Servlet will be executed
			chain.doFilter(request, response);
		}
	}
	
	public void init (FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

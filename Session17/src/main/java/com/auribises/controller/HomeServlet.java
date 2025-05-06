package com.auribises.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.auribises.model.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({ "/HomeServlet", "/Home" })
public class HomeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
//		Read the data from URL
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
		
		/*
		String name = "", email = "";
		
		// Read All the Cookies from the Browser available for your app
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("keyName")) {
					name = cookie.getValue();
				}
				
				if(cookie.getName().equals("keyEmail")) {
					email = cookie.getValue();
				}
			}
		}*/
		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("keyUser");
		
		String htmlResponse = "<html><body><center>Welcome to Home Page<br/>"+
				"<h3>"+user.name+"</h3>"+
				"<h4>"+user.email+"</h4>"+
				"</center></body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
		
	}

}

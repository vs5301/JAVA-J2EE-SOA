package com.auribises.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import com.auribises.dao.DB;
import com.auribises.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	
	DB db;

	public void init(ServletConfig config) throws ServletException {
		db = new DB();
	}

//	doPost can handle only post request from the client
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}*/
	
//	any http request
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
//		1. Capture data from client which is available in HttpServletRequest
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println(user);
//		Till here we have a temporary user in the RAM of the server
			
//		2. Save the data in database permanently
		boolean status = false; // db.fetchUser(user);
		
		String message = "";	
		
//		Navigation from Servlet One to Servlet Two
		String url = "Home";
		
		if(status) {
			
		} else {
			message = "Invalid credentials";
		}
		
//		3. Send back some HTML response to client
		response.setContentType("text/html");
		String htmlResponse = "<html><body><center>Response: "+message+"</center></body></html>";
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);	// This will be sent back to client
		
	};

}

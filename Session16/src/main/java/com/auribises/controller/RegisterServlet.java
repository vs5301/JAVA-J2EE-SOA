package com.auribises.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.auribises.dao.DB;
import com.auribises.model.User;

@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet {

	DB db;
	
//	When object of RegisterServlet will be created by Web Server, init will be executed
//	it is executed only once
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Register Servlet - init executed");
		db = new DB();
		db.createConnection();
	}

//	When object of RegisterServlet will be deleted by Web Server, destroy will be executed
//	it is executed only once
	public void destroy() {
		System.out.println("Regsiter Servlet - destroy executed");
		db.closeConnection();
	}

//	Service is executed for any request coming from the client
//	if, object is already existing, this same function will by executed again
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register Servlet - service executed");
		
		User user = new User();
		
//		1. Capture data from client which is available in HttpServletRequest
		user.name = request.getParameter("txtName");
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println(user);
//		Till here we have a temporary user in the RAM of the server
			
//		2. Save the data in database permanently
		String message = db.registerUser(user);
		System.out.println(message);
		
//		3. Send back some HTML response to client
		response.setContentType("text/html");
		String htmlResponse = "<html><body><center>Response: "+message+"</center></body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);	// This will be sent back to client
		
	}

}

// Servlet is a java class, which will be managed by Web Server i.e., its object construction and destruction is managed by Web Server
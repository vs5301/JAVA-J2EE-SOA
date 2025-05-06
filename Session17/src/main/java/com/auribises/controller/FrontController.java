package com.auribises.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({ "/FrontController", "/Front", "/App" })
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("txtType");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String message = "Welcome to LMS App";
		
		if (type.equals("login")) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Login");	//Login -> url pattern of LoginServlet
			RequestDispatcher dispatcher = request.getRequestDispatcher("Awesome");
			dispatcher.forward(request, response);
 		} else if (type.equals("register")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register");	//Register -> url pattern of RegisterService
			dispatcher.include(request, response);
		} else {
			message = "Invalid request";
		}
		
		String htmlResponse = "<html><body>Response: "+message+"</body></html>";
		out.print(htmlResponse);
		
	}

}

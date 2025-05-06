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
		db.createConnection();
	}

	public void destroy() {
		db.closeConnection();
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
		boolean status = db.loginUser(user);
		
		String message = "";	
		
//		Navigation from Servlet One to Servlet Two
		String url = "Home";
		
		if(status) {
//			1. Session Tracking - URL writing -> Write the data in URL [Query String]
			/* url = "'Home?name="+user.name+"&email="+user.email+"'"; 
			String linkToHome = "<br/><a href="+url+">Click to Enter Home</a><br/>";
			message = user.name+" Login Success"+ linkToHome; */
			
//			2. Session Tracking - Hidden Form Field
			/*String form = "<form action='Welcome' method='post'>"
					+ "<input type='hidden' name='name' value='"+user.name+"'/>"
					+ "<input type='hidden' name='email' value='"+user.email+"'/>"
					+ "<input type='submit' value='Click to Enter Home'/>"
					+ "</form>";
			
			message = user.name+" Login Success <br/>"+form;*/
			
			// 3. Cookies -> Stores the Data as HashMap on the Browser
			// PS: in Cookies, we need to save the data always as Strings
			// For Special Symbols and characters, cookie will throw error 
			// We must encode them -> URLEncoder
			//Cookie cookie1 = new Cookie("keyName", "john");
			//Cookie cookie2 = new Cookie("keyEmail", "john123");
			
//			cookie1.setMaxAge(60);
			
			//response.addCookie(cookie1);
			//response.addCookie(cookie2);
	
			// 4. Session Tracking - HttpSession API
			HttpSession session = request.getSession();
			session.setAttribute("keyUser", user);
			String linkToHome = "<br/><a href="+url+">Click to Enter Home</a><br/>";
			message = user.name+" Login Success "+linkToHome;
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

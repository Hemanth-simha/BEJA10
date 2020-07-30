package com.jspiders.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet{

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	String method = req.getMethod();
	StringBuffer url = req.getRequestURL();
	String	protocol=  req.getProtocol();
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	
	PrintWriter  out = resp.getWriter();
	out.println("HTTP Method : "+method);
	out.println("URL : "+url);
	out.println("Protocol : "+protocol);
	out.println("Username : "+username);
	out.println("Password : "+password);
}	
	
	
}

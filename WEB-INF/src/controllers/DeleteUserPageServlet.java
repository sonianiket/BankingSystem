package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.User;

public class DeleteUserPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		ArrayList<User> inactive = User.getInactiveUsers(); 
		session.setAttribute("inactive",inactive);
		request.getRequestDispatcher("deleteuser.jsp").forward(request,response);
	}	
} 
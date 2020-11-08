package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.Pending;

public class AddUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		ArrayList<Pending> pending = Pending.getAllUsers();
		
		session.setAttribute("pending",pending);

		request.getRequestDispatcher("adduser.jsp").forward(request,response);
	}
}
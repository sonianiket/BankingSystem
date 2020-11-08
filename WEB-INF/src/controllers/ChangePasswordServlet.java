package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class ChangePasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String resp = "failed";
		System.out.println(email+"Emial and Password "+password);
		if(User.changePassword(email,password)){
			resp = "password changed";
		}

		response.getWriter().write(resp);
	}
}
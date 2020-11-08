package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.User;

public class HomeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		System.out.println("Data Fetched");
		HttpSession session = request.getSession();
		ArrayList<User> useral = User.getEmailPassword();
			for(User u: useral){
				System.out.println(u.getEmail()+ "++++++++++++++++++++" + u.getPassword());
			}
		System.out.println(useral+"5555555555555555555555555555555555555555555555555555");
		session.setAttribute("useral",useral);
		session.removeAttribute("userlogin");
		
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
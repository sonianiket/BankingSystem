package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.User;

public class ActivateAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		//request.getRequestDispatcher("signup.jsp").forward(request,response);
		String email = request.getParameter("email");
		String activationCode = request.getParameter("activation_code");
	
		String nextPage = "failed.jsp";

		
		if(User.updateStatus(email,activationCode)){
			/*ArrayList<User> useral = User.getEmailPassword();
			for(User u: useral){
				System.out.println(u.getEmail()+ "++++++++++++++++++++" + u.getPassword());
			}
			System.out.println(useral+"5555555555555555555555555555555555555555555555555555");
			session.setAttribute("useral",useral);*/
			nextPage = "index.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}
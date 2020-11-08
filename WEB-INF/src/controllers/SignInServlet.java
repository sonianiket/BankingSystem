package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.jasypt.util.password.StrongPasswordEncryptor;

import java.io.IOException;

import java.util.ArrayList;

import models.Admin;
import models.User;
import models.Account;

public class SignInServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		System.out.println("MEthod Start");
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
	
		HttpSession session = request.getSession();	
		//ServletContext context = request.getServletContext();

		ArrayList<User> user = (ArrayList<User>)session.getAttribute("useral");
		//ArrayList<User> user = (ArrayList<User>)context.getAttribute("init");

		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
	
		String nextPage = "signin.jsp";

				Admin admin2 = new Admin(userName,password);
				if(admin2.adminLogin()){
					nextPage = "admin.jsp";
				}

		System.out.println(user);
		if(user!=null){
			System.out.println("inside IF");
			for(User u : user){
				System.out.println("inside FOR");
				if(u.getEmail().equals(userName)&&spe.checkPassword(password,u.getPassword())){
					User us = new User(userName,u.getPassword());
					if(us.userLogin()){
						
						session.setAttribute("userlogin",us);
						Account ac = new Account();
						
						if(ac.getDetails(us.getUserId())){
							session.setAttribute("account",ac);
						}
						nextPage = "userScreen.jsp";
					}else{	
						nextPage = "failed.jsp";
					}
				}else{
					request.setAttribute("alert","please enter correct username and passsword");
					Admin admin = new Admin(userName,password);
					if(admin.adminLogin()){
						session.setAttribute("adminlogin",admin);
						nextPage = "admin.jsp";
					}
				}
			}
		}else{
			System.out.println("Admin Login");
			Admin admin1 = new Admin(userName,password);
				if(admin1.adminLogin()){
					nextPage = "admin.jsp";
				}
		}
		
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}
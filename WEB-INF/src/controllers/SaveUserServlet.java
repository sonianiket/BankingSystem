package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Pending;

public class SaveUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();

		int bankId = Integer.parseInt(request.getParameter("bank_id"));
		String email = request.getParameter("email");
		Pending user = new Pending();	
		if(user.getUser(bankId,email)){
			session.setAttribute("user",user);
			request.getRequestDispatcher("saveuser.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("failed.jsp").forward(request,response);
		}
		
		//request.getRequestDispatcher("saveuser.jsp").forward(request,response);
	}
}
package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.Bank;

public class SignUpPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		ArrayList<Bank> bank = Bank.collectIFSCCode();

		session.setAttribute("bank",bank);
		
		request.getRequestDispatcher("signup.jsp").forward(request,response);
	}
}
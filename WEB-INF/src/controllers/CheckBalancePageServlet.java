package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Deposit;
import models.Account;

public class CheckBalancePageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("account");
		System.out.println("Account  Id  first= "+acc.getAccountId());
		Deposit deposit = Deposit.getBalance(acc.getAccountId());
		
		if(deposit!=null){
			System.out.println("Set Attribute(Deposit)");
			session.setAttribute("balance",deposit);
		}
		

		request.getRequestDispatcher("checkbalance.jsp").forward(request,response);
	}
}
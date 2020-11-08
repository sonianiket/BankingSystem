package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Account;
import models.Deposit;

public class WithDrawlServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Account ac = (Account)session.getAttribute("account");
		
		String nextPage = null;

		Deposit d = (Deposit)session.getAttribute("balance");

		String accountNumber = request.getParameter("account_number");
		double withdrawlMoney = Double.parseDouble(request.getParameter("withdrawl_money"));
		
		
		Deposit deposit = new Deposit();
		if(deposit.withdrawlMoney(ac.getAccountId(),withdrawlMoney,d.getBalance())){
			nextPage = "userScreen.jsp";
		}else{
			System.out.println("WithDrawl Failed");
			
		}
		
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}
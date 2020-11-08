package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Account;
import models.Deposit;
import models.User;

import utils.TextLocalSMS;

public class DepositServlet extends HttpServlet{	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Account ac =(Account)session.getAttribute("account");
		User user = (User)session.getAttribute("userlogin");
		
		String accountNumber = request.getParameter("account_number");
		
		Deposit d = (Deposit)session.getAttribute("balance");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Seesion Attribute balance = "+ d.getBalance());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		double money = Double.parseDouble(request.getParameter("money"));
		
		
		Deposit deposit = new Deposit();
		
		double balance = deposit.depositMoney(ac.getAccountId(),money,d.getBalance());
		
		
		System.out.println("###########################################################");
		System.out.println("balance = "+balance);
		System.out.println("###########################################################");
		System.out.println(balance+ " After Depositing Money");
		System.out.println("###########################################################");
		

////////////////// SMS Sending ////////////////////////////////////

		TextLocalSMS.sendSms(money,user.getMobile(),balance);

///////////////////////////////////////////////////////////////////
		
		request.getRequestDispatcher("userScreen.jsp").forward(request,response);
	}
}
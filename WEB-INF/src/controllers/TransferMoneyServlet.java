package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.Deposit;
import models.Account;
import models.Transaction;

public class TransferMoneyServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Account ac = (Account)session.getAttribute("account");
		String fromAcc = request.getParameter("frm_acc_num");
		double money = Double.parseDouble(request.getParameter("money"));
		int toAccId = Integer.parseInt(request.getParameter("acc_id"));
		
		System.out.println(toAccId+" TO ACCOUNT ID "+ " MONEY "+ money);

		Deposit d = (Deposit)session.getAttribute("balance");
		
		Deposit deposit = new Deposit();
		System.out.println(ac.getAccountId()+"&&&&&&&&&&&&&&&&&&&&&&& WITHDRAWL FROM ACCOUNT ID &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		if(deposit.withdrawlMoney(ac.getAccountId(),money,d.getBalance())){
			System.out.println("DEPOSIT ID = "+ deposit.getDepositId()+"ddddddddddddddddddddddddddddddddddddddddddd AAA");
			
			int wdId = deposit.getDepositId();
			
			System.out.println(toAccId+" DEPOSIT TO ACCOUNT ID ");

			System.out.println(deposit.depositMoney(toAccId,money,Deposit.getBalance(toAccId).getBalance()));
			
			int dpstId = deposit.getDepositId();

//////////////////////////////////////////// Transaction Save Code ///////////////////////////////////
			
			Transaction transaction = new Transaction();
			transaction.saveTransaction(wdId,dpstId,money);

//////////////////////////////////////////// Transaction History Code ///////////////////////////////////

			ArrayList<Transaction> tr = transaction.getAllTransaction();
			session.setAttribute("transaction",tr);
/////////////////////////////////////////////////////////////////////////////////////////////////////////
			request.getRequestDispatcher("userScreen.jsp").forward(request,response);
		}
		
		
	}
}
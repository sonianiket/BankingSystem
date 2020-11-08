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

public class HistoryServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("account");
		System.out.println(acc.getAccountId());
		ArrayList<Deposit> d = Deposit.getHistory(acc.getAccountId());

		session.setAttribute("al",d);
		
		request.getRequestDispatcher("history.jsp").forward(request,response);
	}
}
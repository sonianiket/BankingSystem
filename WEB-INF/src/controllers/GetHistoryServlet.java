package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.Deposit;

public class GetHistoryServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String resp = "failed";
		int accountId = Integer.parseInt(request.getParameter("account_id"));
		System.out.println(accountId+"ACCOUNTID ++++++++++++++++++++++++++ //////////////////////////////////////");

		ArrayList<Deposit> depositAl = Deposit.getHistory(accountId);
		System.out.println(depositAl+"DEPOSIT ARRAYLIST/////////////////////////////////");
		if(depositAl!=null){
			resp = "done";
		}
		session.setAttribute("depositAl",depositAl);

		response.getWriter().write(resp);
	}
}
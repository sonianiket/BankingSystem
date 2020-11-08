package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Bank;

import com.google.gson.Gson;

public class GetIFSCCodeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String resp = "failed";
		int bankId = Integer.parseInt(request.getParameter("bank_id"));
		System.out.println(bankId+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		Bank bank = new Bank();

		if(bank.getIFSCCode(bankId)){
			//session.setAttribute("banks",bank);
			resp = new Gson().toJson(bank);
		}
		response.getWriter().write(resp);
	}
}
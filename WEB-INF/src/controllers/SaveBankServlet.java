package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Bank;

public class SaveBankServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String resp = "failed";
		
		String bankName = request.getParameter("bank_name");
		String ifscCode = request.getParameter("ifsc_code");

		System.out.println(bankName+"**************************************************"+ ifscCode);

		if(Bank.saveBank(bankName,ifscCode)){
			resp = "done";
		}

		response.getWriter().write(resp);
	}
}
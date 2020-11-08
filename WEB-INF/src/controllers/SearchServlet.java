package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import com.google.gson.Gson;

import java.util.ArrayList;

import models.Account;

public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String firstChar = null;
		String tmpChar = request.getParameter("first_char");
		if(tmpChar.length()!=0){
			firstChar = tmpChar;
		}

		
		String resp = null;
		ArrayList<Account> accounts = Account.getAccountNumber(firstChar);
		
		if(accounts.size()!=0){
			resp = new Gson().toJson(accounts);
		}else{
			resp = "not found";
		}
		
		response.getWriter().write(resp);
	}
}
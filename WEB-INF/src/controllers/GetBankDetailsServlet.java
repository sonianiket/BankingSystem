package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.Bank;

import com.google.gson.Gson;

public class GetBankDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String resp = "fail";
		ArrayList<Bank> bank = Bank.GetDetails();
		resp = new Gson().toJson(bank);

		response.getWriter().write(resp);
	}
}
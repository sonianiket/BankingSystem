package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.Bank;
import models.Pending;
import models.Account;

import utils.EmailSender;

public class SaveServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

		HttpSession session = request.getSession();
		Pending p = (Pending)session.getAttribute("user");

		
		int pendingId = p.getPendingId();
		

		int bankId = Integer.parseInt(request.getParameter("hidden"));
		String accountName = request.getParameter("account_name");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String activationCode = request.getParameter("activation_code");
		String fileName = request.getParameter("file_name");



		User user = new User();
		user.setBank(new Bank(bankId));
		user.setAccountName(accountName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setAddress(address);
		user.setDOB(dob);
		user.setGender(gender);
		user.setFileName(fileName);

		//Account account = new Account();
		if(user.saveUser(activationCode)){
			
			//int accountId = account.saveAccount(bankId,user.getUserId());
			Account.saveAccount(bankId,user.getUserId());
			//System.out.println(accountId+"  7989548544578888888888888888888888888888888885555555555555555555555555544444444445525");
			
			//user.saveAccountId(accountId,activationCode);

			if(Pending.delete(pendingId)){
				
				EmailSender.sendEmail(firstName,email,activationCode);
				request.getRequestDispatcher("admin.jsp").forward(request,response);
			}else{
				System.out.println("Sending Email Failed");
			}
		}else{
			System.out.println("User Not Saved");
		}


		//request.getRequestDispatcher("signup.jsp").forward(request,response);
	}
}
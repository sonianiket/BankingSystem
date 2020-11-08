package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.ArrayList;

import models.User;

import utils.EmailSender;
import utils.GenerateOTP;

public class ResetPasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String resp = "failed";
		
		HttpSession session = request.getSession();
		ArrayList<User> user = (ArrayList)session.getAttribute("useral");
		String email = request.getParameter("email");
		System.out.println(email+"12345678998575485485#############$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%% NEW");
		String code = GenerateOTP.otpGeneration();
		for(User u : user){
			System.out.println(u.getEmail()+" NEW ");
			if(u.getEmail().equals(email)){
				EmailSender.sendCode(email,code);
				session.setAttribute("code",code);
				System.out.println("Matched NEW");
				resp = "done";
			}else{
				System.out.println("Not Matched NEW");
			}
		}
		response.getWriter().write(resp);
	}
}
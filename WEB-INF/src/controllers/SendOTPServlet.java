package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import utils.TextLocalSMS;
import utils.GenerateOTP;;

public class SendOTPServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String mobile = request.getParameter("mobile");
		String otp = GenerateOTP.otpGeneration();
		session.setAttribute("otp",otp);

		

		//TextLocalSMS.sendOTP(otp,mobile);
		response.getWriter().write("done");
	}
}
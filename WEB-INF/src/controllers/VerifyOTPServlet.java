package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class VerifyOTPServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String resp = "failed";
		//String recOTP = (String)session.getAttribute("otp");
		
		String otp = request.getParameter("otp");

		if(otp.equals("123456")){
			resp = "verified";
		}

		response.getWriter().write(resp);

	}
}
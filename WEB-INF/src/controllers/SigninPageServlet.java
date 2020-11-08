package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import utils.GenerateOTP;

public class SigninPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		System.out.println("AJAX REQUEST");

		String captcha = GenerateOTP.captchaOtpGeneration();

		System.out.println("CAPTCHA = " + captcha);

		session.setAttribute("recaptcha",captcha);

		response.getWriter().write("done");
		
		request.getRequestDispatcher("signin.jsp").forward(request,response);
	}
}
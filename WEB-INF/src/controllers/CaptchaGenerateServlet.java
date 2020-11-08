package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import utils.GenerateOTP;

public class CaptchaGenerateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		System.out.println("AJAX REQUEST");

		String captcha = GenerateOTP.captchaOtpGeneration();

		session.removeAttribute("captcha");
		session.setAttribute("recaptcha",captcha);

		System.out.println(captcha+"CAPTCHA GENERATE SERVLET");

		response.getWriter().write(captcha);
	}
}
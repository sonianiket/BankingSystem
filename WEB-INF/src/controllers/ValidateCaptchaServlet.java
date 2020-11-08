package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class ValidateCaptchaServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String resp = "failed";
		String captcha = request.getParameter("captcha");
		System.out.println(captcha+"********************************************");

		String recaptcha = (String)session.getAttribute("recaptcha");

		System.out.println(recaptcha+" RECAPTCHA");
		
		System.out.println(captcha.equals(recaptcha)+"TEST PERFORMED");

		if(captcha.equals(recaptcha)){
			resp = "match";
		}

		response.getWriter().write(resp);
	}
}
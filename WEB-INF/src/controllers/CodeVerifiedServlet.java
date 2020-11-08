package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public class CodeVerifiedServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String recCode = (String)session.getAttribute("code");
		String code = request.getParameter("code");

		String resp = "failed";
		System.out.println(recCode+"NEW");
		if(code.equals(recCode)){
			resp = "verified";
		}
		response.getWriter().write(resp);
	}
}
package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.regex.Pattern;

public class PasswordValidateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		Pattern pm = Pattern.compile("^([a-zA-Z0-9@*#]{8,15})$");
		String resp = null;
		String tmpPass = request.getParameter("pass");
		
		if(pm.matcher(tmpPass).matches()){
			String password = tmpPass;
			String confPassword = request.getParameter("conf_pass");
			if(password.length()==confPassword.length()){
				if(password.equals(confPassword)){
					resp = "success";	
				}
			}else{
				resp = "failed";
			}
			
		}
		response.getWriter().write(resp);
	}
}
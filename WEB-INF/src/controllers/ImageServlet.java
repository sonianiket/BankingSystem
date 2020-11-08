package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import models.User;

public class ImageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		OutputStream os = response.getOutputStream();
		
		User u = (User)session.getAttribute("userlogin");

		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+u.getEmail() +"/"+u.getFileName());
		
		System.out.println("IMAGE LOADING");

		byte[] arr = new byte[1024];
		int x = 0;
		while((x=is.read(arr))!=-1){
			os.write(arr);
		}

		os.flush();
		os.close();
	}
}
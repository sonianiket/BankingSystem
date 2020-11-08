package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.Account;

public class DeleteUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String resp = "failed";
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		System.out.println("User Id to Be Deleted" + userId);
		if(Account.delete(userId)){
			if(User.deleteUser(userId)){
				System.out.println("Deleted");
				resp = "success";
				//request.getRequestDispatcher("deleteuser.jsp").forward(request,response);
			}else{
				System.out.println("Not Deleted");
			}
		}else{
			System.out.println("Not Deleted From Account Table");
		}
		
		response.getWriter().write(resp);
	}
}
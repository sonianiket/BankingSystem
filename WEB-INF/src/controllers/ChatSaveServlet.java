package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.Chat;

import com.google.gson.Gson;

public class ChatSaveServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		String resp = "failed";
		
		String mainMessage = request.getParameter("msg");
		System.out.println(mainMessage+"Main Message");
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println(userId+"usersiddddddddddddddddddddddddddd");
		Chat chat = new Chat();
		if(chat.saveMsg(mainMessage,userId)){
			System.out.println("SAVED");
			chat.getMsg();
			System.out.println("GOTED");
			resp = new Gson().toJson(chat);
		}
		/*else{
			if(chat.updateMsg(mainMessage)){
				chat.getMsg();
				resp = new Gson().toJson(chat);
			}
		}*/
		

		response.getWriter().write(resp);
		
	}
}
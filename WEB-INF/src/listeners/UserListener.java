package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import java.util.ArrayList;

import models.User;

public class UserListener implements ServletContextListener{
	public void contextDestroyed(ServletContextEvent ev){
		
	}

	public void contextInitialized(ServletContextEvent ev){
		ServletContext context = ev.getServletContext();
		ArrayList<User> useral = User.getEmailPassword();
		for(User u: useral){
			System.out.println(u.getEmail()+ "++++++++++++++++++++" + u.getPassword());
		}
		System.out.println(useral+"5555555555555555555555555555555555555555555555555555");
		//context.setAttribute("init",useral);
		//context.setAttribute("useral",useral);
	}
}
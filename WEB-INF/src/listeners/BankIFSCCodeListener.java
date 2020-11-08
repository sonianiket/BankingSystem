package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import java.util.ArrayList;

import models.Bank;

public class BankIFSCCodeListener implements ServletContextListener{
	public void	contextDestroyed(ServletContextEvent e){
		System.out.println("destroyed");
	}	

	public void contextInitialized(ServletContextEvent e){
		/*ServletContext context = e.getServletContext();

		ArrayList<Bank> bank = Bank.collectIFSCCode();

		context.setAttribute("bank",bank);*/
		
	}
}
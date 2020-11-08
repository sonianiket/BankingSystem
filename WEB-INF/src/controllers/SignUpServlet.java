package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;


import java.util.regex.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Random;

import models.Pending;
import models.Bank;


public class SignUpServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		if(ServletFileUpload.isMultipartContent(request)){
			
			DiskFileItemFactory dff = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dff);
			List<FileItem> list = null;
			try{
				list = sfu.parseRequest(request);

			}catch(FileUploadException e){
				e.printStackTrace();
			}
			Pending pending = new Pending();
			String nm = null;
			for(FileItem fi :list){
				if(fi.isFormField()){
					String name = fi.getFieldName();
					String value = fi.getString();
					System.out.println(name +"~~~~~~~~~~~~~~~~~~~" + value);
					if(name.equals("bank_name")){
						int bankId = Integer.parseInt(value);
						pending.setBank(new Bank(bankId));
					}else if(name.equals("account_name")){
						pending.setAccountName(value);
					}else if(name.equals("first_name")){
						pending.setFirstName(value);
					}else if(name.equals("last_name")){
						pending.setLastName(value);
					}else if(name.equals("email")){
						pending.setEmail(value);
					}else if(name.equals("password")){
						//pending.setPassword(value);
						
						nm = value;
					}else if(name.equals("confirm_password")){
						
						if(value.equals(nm)){
							pending.setPassword(value);
						}else{
							request.setAttribute("err","Please Enter correct Password");
							request.getRequestDispatcher("signup.jsp").forward(request,response);
							return;
						}
	
					}
					else if(name.equals("mobile")){
						
						String num = value.trim();
						if(num.length()==10){
							System.out.println("true");
							pending.setMobile(value);	
						}else{
							
							request.setAttribute("mob_err","Mobile No. must be 10  Digits Long");
							request.getRequestDispatcher("signup.jsp").forward(request,response);
							return;
						}
						
					}else if(name.equals("address")){
						pending.setAddress(value);
					}else if(name.equals("dob")){
						pending.setDOB(value);
					}else if(name.equals("gender")){
						pending.setGender(value);
					}
				}else{
					String fileName = fi.getName();
					String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+pending.getEmail());
					File f1 = new File(uploadPath);
					f1.mkdir();

					File f2 = new File(f1,fileName);
					try{
						fi.write(f2);
						pending.setFileName(fileName);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			Random random = new Random();
			String a1 = Long.toString(random.nextLong());
			String a2 = Long.toString(new Date().getTime());

			String activationCode = a1 + a2;

			if(pending.saveData(activationCode)){
					request.getRequestDispatcher("welcome.jsp").forward(request,response);	
				}
		}
				
	}
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Pattern pm = Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+(?:[a-zA-Z]{2}|aero|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel)$");
		String email = null;

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");

		if(password.equals(confirmPassword)){
			int bankId = Integer.parseInt(request.getParameter("bank_name"));
			String IFSCCode = request.getParameter("ifsc_code");	
			String accountName = request.getParameter("account_name");
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");

			String tmpEmail = request.getParameter("email");
			
			if(pm.matcher(tmpEmail).matches()){
				email = tmpEmail;
			}else{
				System.out.println("invalid Email");
			}
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String date = request.getParameter("dob");
			String gender = request.getParameter("gender");
			
				
			Pending p = new Pending();
			p.setBank(new Bank(bankId));
			p.setAccountName(accountName);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setEmail(email);
			System.out.println(email);
			p.setPassword(password);
			p.setMobile(mobile);
			p.setAddress(address);
			p.setDOB(date);
			p.setGender(gender);

			if(p.saveData()){
				request.getRequestDispatcher("welcome.jsp").forward(request,response);	
			}
		}else{
			request.setAttribute("err","Please Enter correct Password");
			request.getRequestDispatcher("signup.jsp").forward(request,response);
			
		}*/

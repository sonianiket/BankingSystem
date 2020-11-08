package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;

import java.util.List;


import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class Image2Servlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		if(ServletFileUpload.isMultipartContent(request)){

			DiskFileItemFactory df = new DiskFileItemFactory();
			ServletFileUpload sf = new ServletFileUpload(df);

			List<FileItem> list = null;
			try{
				 list = sf.parseRequest(request);
				 System.out.println("list");

			}catch(FileUploadException f){
				f.printStackTrace();
			}

			for(FileItem fi : list){
				
				if(fi.isFormField()){
					System.out.println("if");
					String name = fi.getFieldName();
					
					String value = fi.getString();
				
				}else{
					
					String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads");
					File  file = new File(uploadPath,fi.getName());
					try{
						fi.write(file);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}

		}
	}
}
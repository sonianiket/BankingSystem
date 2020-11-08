<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Pending" %>


<!doctype html>
<html lang="en">
 <head>
  <title>Add User</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/admin.css">
  <link rel="stylesheet" type="text/css" href="css/adduser.css">

	<style>
		#add_user{
			background-color:orange;
			font-weight:bold;
		}
	</style>
 </head>
 <body>
	<%@ include file="adminheader.jsp" %>

		<div class="container">
			<table border="1" class="center" cellspacing="5">
				<tr>
				
				<% 
					ArrayList<Pending> al = (ArrayList)session.getAttribute("pending");
					int count = 0;
				%>

				<%
					for(Pending pen : al){
						if(count%4==0){ %>
							<tr>
								
							</tr>
						<%}%>
						
						<td>
							<a href="saveuser.do?bank_id=<%= pen.getBank().getBankId() %>&email=<%= pen.getEmail() %>">
								<span class="name"><%= pen.getFirstName() %></span><br><br>
							</a>
						</td>

					<%  
						count++;
			
					} %>

				

				<!--
					<c:forEach var="data" items="${pending}">
						<td>
							<a href="saveuser.do?bank_id=${data.bank.bankId}&email=${data.email}">
								<span class="name">${data.firstName}</span>
							</a>
						</td>
					</c:forEach>
				-->
				</tr>
			</table>
		</div>

	<%@ include file="adminfooter.jsp" %>

 </body>
</html>



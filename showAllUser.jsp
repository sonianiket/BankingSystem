<%@ page import="java.util.ArrayList"%>
<%@ page import="models.User"%>

<!doctype html>
<html lang="en">
 <head>
  <title>All Users</title>
  <%@ include file="imports.jsp"%>
  <style>
	#status{
		background-color:green;
		color:white;
		font-weight:bold;
	}

	#all_user{
		background-color:orange;
		font-weight:bold;
	}
  </style>
 </head>
 <body>
	<%@ include file="adminheader.jsp"%>
	<table class="highlight responsive-table" width="80%">
		<tr>
			<th>UserId</th>
			<th>AccountName</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th class="center">Bank Name</th>
			<th>Account Number</th>
			<th class="center">Email</th>
			<th>Mobile No.</th>
			<th class="center">DOB</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		
	<%
		ArrayList<User> user = (ArrayList)session.getAttribute("useral");
		int count = 0;
		if(user!=null){
			for(User u: user){ 
					System.out.println(user.size()+"#########################################");
				%>
				<tr>
					<td class="center"><%= u.getUserId() %></td>
					<td class="center"><%= u.getAccountName() %></td>
					<td class="center"><%= u.getFirstName() %></td>
					<td class="center"><%= u.getLastName() %></td>
					<td><%= u.getBank().getBankName() %></td>
					<td class="blue-text" style="letter-spacing:1px;"><b><%= u.getAccount().getAccountNumber() %></b></td>
					<td><%= u.getEmail() %></td>
					<td><%= u.getMobile() %></td>
					<td><%= u.getDOB() %></td>
					<td class="center"><%= u.getGender() %></td>
					<%
						if(u.getStatus().getStatus().equals("Active")){ %>
							<td id="status"><%= u.getStatus().getStatus()%></td>
						<%}else{%>
							<td class="red white-text"><%= u.getStatus().getStatus()%></td>
						<% }	%>
		
					<td><button class="btn" value=<%= u.getAccount().getAccountId() %> id="hist_btn">History</button></td>
				</tr>
				
			<% 
			}
				count++;
			System.out.println(count);
		} %>
		
	</table>
	<%@ include file="adminfooter.jsp"%>

	<script src="js/showAllUser.js"></script>
 </body>
</html>

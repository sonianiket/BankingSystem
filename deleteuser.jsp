<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
 <head>
  <title>Delete User</title>
  <%@ include file="imports.jsp"%>
  <style>
		#delete_user{
			background-color:orange;
			font-weight:bold;
		}
	</style>
 </head>
 <body>
	<%
		int count = 1;
	%>
	<%@ include file="adminheader.jsp"%>
		<table class="centered responsive-table highlight">
			<tr>
				<th class="center">S.No</th>
				<th class="center">FirstName</th>
				<th class="center">LastName</th>
				<th class="center">Email</th>
				<th class="center">BankName</th>
				<th class="center">Mobile</th>
				<th class="center">Gender</th>
				<th class="center">DOB</th>
				<th class="center">Status</th>
				<th class="center">Action</th>
			</tr>
			<c:forEach var="data" items="${inactive}">
				<tr>
					<td><%= count++%></td>
					<td>${data.firstName}</td>
					<td>${data.lastName}</td>
					<td>${data.email}</td>
					<td>${data.bank.bankName}</td>
					<td>${data.mobile}</td>
					<td>${data.gender}</td>
					<td>${data.DOB}</td>
					<td>${data.status.status}</td>
					<td>
						<input type="hidden" value="${data.userId}" id="del_id">
						<button class="btn" value="${data.userId}" id="del_btn" onclick="deleteUser(${data.userId})">Delete</button>
					</td>
				</tr>
			</c:forEach>
		<table>
	<%@ include file="adminfooter.jsp"%>

	<script src="js/delete.js"></script>
 </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
  <%@ include file="imports.jsp"%>
  <style>
	table{
		font-weight:Bold;
		background-color:#7B8788;
		margin-bottom:2%;
	}
	
	table th{
		color:Orange;
		font-size:15px;
		text-transform:uppercase;
		letter-spacing:1px;
	}

	table td{
		color:white;
		letter-spacing:1px;
	}
  </style>
 </head>
 <body>
	<%@ include file="header.jsp"%>

	<%
		int i=1;
	%>

	<table class="highlight responsive-table">
		<tr>
			<th class="center">Id</th>
			<th class="center">Deposit</th>
			<th class="center">WithDrawl</th>
			<th class="center">Balance</th>
			<th class="center">Date</th>
		</tr>
			<c:forEach var="deposit" items="${al}">
			<tr>
				<td class="center"><%= i++%></td>
				<td class="center">${deposit.deposit}</td>
				<td class="center">${deposit.withDrawl}</td>
				<td class="center">${deposit.balance}</td>
				<td class="center">${deposit.time}</td>
			</tr>	
			</c:forEach>
		
	</table>

	<%@ include file="footer.jsp"%>
 </body>
</html>

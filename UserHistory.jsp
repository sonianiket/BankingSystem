<%@ page import="java.util.ArrayList"%>
<%@ page import="models.Deposit"%>

<!doctype html>
<html lang="en">
 <head>
  <title>History</title>
  <%@ include file="imports.jsp"%>
 </head>
 <body>
	 <h3 class="center orange white-text">HISTORY</h3>
		<div class="container">
		<table class="highlight responsive-table" width="80%">
			<tr>
				<th class="center">Deposit</th>
				<th class="center">Withdrawl</th>
				<th class="center">Balance</th>
				<th class="center">Time</th>
			</tr>
			
	<%
		ArrayList<Deposit> deposit = (ArrayList)session.getAttribute("depositAl");
		if(deposit!=null){
			for(Deposit u : deposit){ %>
				<tr>
				<td class="center"><%=u.getDeposit()%></td>
				<td class="center"><%=u.getWithDrawl()%></td>
				<td class="center"><%=u.getBalance()%></td>
				<td class="center"><%=u.getTime()%></td>
				</tr>
			
				
		<%	}
		}
	%>
		</table>
		</div>
	
 </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
 <head>
  <title>Transaction</title>
  <%@ include file="imports.jsp"%>
 </head>
 <body>
	<%@ include file="header.jsp"%>
	<%
		int i = 1;
	%>

	<table class="centered highlight responsive-table">
		<tr>
			<th class="center">Transaction ID</th>
			<th class="center">AccountNumber</th>
			<th class="center">Money</th>
			<th class="center">Time</th>
		</tr>
		
		
			<c:forEach var="t" items="${transaction}">
			<tr>
				<td>
					<%= i++%>
				</td>
				<td>
					${t.account.accountNumber}
				</td>
				<td>
					${t.balance}
				</td>
				<td>
					${t.time}
				</td>

			</tr>
			</c:forEach>
		
	</table>
	<%@ include file="footer.jsp"%>
 </body>
</html>

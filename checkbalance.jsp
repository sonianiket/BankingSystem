<%@ page import="models.Deposit"%>

<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
  <%@ include file="imports.jsp"%>
  <style>
	span{
		color:orange;
		display:block;
		font-size:30px;
		font-weight:bold;
	}
	h4{
		margin-top:15%;
	}
  </style>
 </head>
 <body>
	<%@ include file="header.jsp"%>
	<h4 class="center">Your Current Account Balance is</h4>
	<span class="center">Rs. ${balance.balance}</span>
	<%@ include file="footer.jsp"%>
 </body>
</html>

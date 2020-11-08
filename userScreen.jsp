<!doctype html>
<html lang="en">
 <head>
  <title>UserScreen</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/userScreen.css">
 </head>
 <body>
	<%@ include file="header.jsp"%>
	<h6 class="right" id="wlcm">Welcome <span>${userlogin.firstName}</span></h6>
	<div class="container">
		<div class="row center">
			<div class="col s12 m4">
				<a href="depositpage.do"><button class="btn">Deposit</button></a>
			</div>
			<div class="col s12 m4">
				<a href="withdrawlpage.do"><button class="btn">WithDrawl</button></a>
			</div>
			<div class="col s12 m4">
				<a href="transferpage.do"><button class="btn">Transfer</button></a>
			</div>
		</div>
		<div class="row center">
			<div class="col s12 m4">
				<a href="checkbalance.do"><button class="btn">Check Balance</button></a>
			</div>
			
			<div class="col s12 m4">
				<a href="history.do"><button class="btn">History</button></a>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
	<script>
		$(document).ready(function(){
			$('.sidenav').sidenav();
		});
	</script>
 </body>
</html>

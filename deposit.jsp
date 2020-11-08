<!doctype html>
<html lang="en">
 <head>
  <title>Deposit</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/deposit.css">
 </head>
 <body>
	<%@ include file="header.jsp"%>
		<div class="container">
			<div class="col s12 m6 center">
				<form action="deposit.do" method="post" id="form">
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<input type="text" value="${account.accountNumber}" name="account_number" placeholder="Enter Account Number"/>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<input type="text" name="money" placeholder="Enter Money"/>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m6 offset-m3">
							<button class="btn left  offset-m3">Deposit</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>

	<%@ include file="footer.jsp"%>
 </body>
</html>

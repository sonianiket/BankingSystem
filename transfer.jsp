<!doctype html>
<html lang="en">
 <head>
  <title>Transfer</title>
  
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/transfer.css" >
 </head>
 <body>
	<%@ include file="header.jsp"%>
	<h5 class="center orange-text">Transfer Money</h5>
	<div class="container center">
		<form action="transfermoney.do" method="post">
			<div class="row">
				<div class="col s12 m4 input-field">
					<label>From Account Number</label>
					<input type="text" value="${account.accountNumber}" name="frm_acc_num" />
				</div>
				<div class="col s12 m4 input-field">
					<label>Money</label>
					<input type="text" name="money"/>
				</div>
				<div class="col s12 m4 input-field">
					<label>To Account Number</label>
					<input type="number" id="srch_input" name="to_acc_num" autocomplete="off"/>
					<div id="search_div"></div>
				</div>
			</div>
			<div class="row">
				<button class="btn">Transfer</button>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
	<script src="js/transfer.js"></script>
 </body>
</html>

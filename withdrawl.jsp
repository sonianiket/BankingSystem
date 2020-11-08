<!doctype html>
<html lang="en">
 <head>
  <title>WithDrawl</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/deposit.css">
  <link rel="stylesheet" type="text/css" href="css/withdrawl.css">
  <script src="js/withdrawl.js"></script>
 </head>
 <body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="col s12 m6">
			<form action="withdrawl.do" method="post" id="form">
				<div class="row">
					<div class="input-field col s12 m5 offset-m3">
						<input type="text" value="${account.accountNumber}" name="account_number">
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m5 offset-m3">
						<input type="text" name="withdrawl_money" placeholder="Enter money" autocomplete="off" required>
					</div>
				</div>
				<div class="row" >
					<div class="input-field col s12 m3 offset-m3">
						<input type="text" id="mobile_no" value="${userlogin.mobile}" name="mobile" placeholder="enter mobile number">
					</div>
					<!--<button class="btn" id="otp_btn">Send OTP</button>-->
					<input type="button" class="otp white-text" id="otp_btn" value="Send OTP" />
				</div>
				<div class="row">
					<div class="input-field col s12 m3 offset-m3">
						<input type="text" name="verify_otp" placeholder="enter OTP" autocomplete="off"  id="enter_otp" required>
					</div>
					<input type="button" class="otp white-text green" id="otp_verify_btn" value="Verify OTP" />
				</div>

				<button class="btn" id="wd_btn">WithDrawl</button>
			</form> 
		</div>
	</div>
	<%@ include file="footer.jsp"%>
 </body>
</html>

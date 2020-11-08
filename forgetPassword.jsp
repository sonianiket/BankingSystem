<!doctype html>
<html lang="en">
 <head>
  <title>Forget Password</title>
  <%@ include file="imports.jsp"%>
  <style>
	.container{
		width:50%;
		padding-top:20px;
		margin-top:5%;
	}

	#no,#new_pass,#conf_pass{
		border:1px solid black;
		border-radius:10px;
		padding-left:5px;
		margin-top:5px;
	}

	#code{
		border:1px solid black;
		border-radius:10px;
		padding-left:5px;
		margin-top:5px;
	}

	#box2,#box3{
		display:none;
	}

	h5{
		margin-left:28%;
		margin-top:10%;
	}

	#spn_r1,#spn3{
		color:red;
		font-size:12px;
	}

	#send_btn{
		font-family: 'Orbitron', sans-serif;
		width:100px;
		border-radius:10px;
	}

	#send_btn1,#send_btn2{
		font-family: 'Orbitron', sans-serif;
		width:100px;
		border-radius:10px;
	}

  </style>
 </head>
 <body>
	<%@ include file="header.jsp"%>
	
	<div class="container">
		<div id="box1">
			<h5>Please Enter Your Mail</h5>
			<div class="row" >
				<div class="col s12 m6 offset-m3" id="r1">
					<input class="in" type="text" name="num" id="no" placeholder="for example abc@gmail.com" required>
					<span id="spn_r1"></span>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6 offset-m5">
					<button class="btn orange waves-effect waves-light" id="send_btn">Send</button>
				</div>
			</div>
		</div>
		<div id="box2">
			<h5>Please Enter The Code</h5>
			<div class="row" >
				<div class="col s12 m6 offset-m3" id="r1">
					<input type="text" name="code" id="code" maxlength="6" required>
					<span></span>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6 offset-m5">
					<button class="btn orange waves-effect waves-light" id="send_btn1">Send</button>
				</div>
			</div>
		</div>
		<div id="box3">
			<h5>Enter New Password</h5>
			<div class="row" >
				<div class="col s12 m6 offset-m3" id="r1">
					<label class="black-text">Password</label>
					<input type="text" name="new_pass" id="new_pass" maxlength="15" required>
					<span id="spn3"></span>
				</div>
			</div>
			<div class="row" >
				<div class="col s12 m6 offset-m3" id="r1">
					<label class="black-text">Retype Password</label>
					<input type="text" name="conf_pass" id="conf_pass" maxlength="15" required>
					<span></span>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6 offset-m5">
					<button class="btn orange waves-effect waves-light" id="send_btn2">Save</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script src="js/forgetpass.js"></script>
 </body>
</html>

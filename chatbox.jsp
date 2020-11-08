<!doctype html>
<html lang="en">
 <head>
  <title>Chat Box</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/chatbox.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 </head>
 <body bgcolor="#A4B0BD">	
	
	<div class="container">
		<div class="row">
			<div class="col s6 m6">
				<h4 class="center orange-text">CHATBOX</h4>
			</div>
			<div class="col s6 m6">
				<i class="medium material-icons" id="logo">chat</i>
			</div>
		</div>
		<div class="b1_left">
			<textarea class="materialize-textarea" name="send_msg" id="send_msg" readonly>
			</textarea>
		</div>
		<div class="b2_right">
			<textarea id="receive_msg" class="materialize-textarea" name="receive_msg" readonly></textarea>
		</div>
		
		<div class="footer" id="foot">
			<div id="main_box">
				<textarea id="main_msg" class="materialize-textarea" placeholder="enter your message here" ></textarea>
				<input type="hidden" value="${userlogin.userId}" id="userId">
				<button class="btn" id="send_btn">Send</button>
			</div>
		</div>
		
	</div>

	<script src="js/chatbox.js"></script>
 </body>
</html>
		<!--<div class="row">
			<div class="col s12 m6">
				<div id="main_box">
					<textarea id="textarea1" class="materialize-textarea" placeholder="enter your message here"></textarea>
				</div>
			</div>
			<div class="col s12 m6"></div>
		</div>-->
<!doctype html>
<html lang="en">
 <head>
  <title>Sign In</title>
  <link rel="stylesheet" type="text/css" href="css/signin.css"/>
  <%@ include file="imports.jsp"%>
 </head>
 <body>
		
	<%
		String msg = (String)request.getAttribute("alert");
	%>

	<%@ include file="header.jsp"%>
		<div class="container">
			<div class="box">
				<form action="signin.do" method="post" id="form">
					<div class="row">
						<div class="col s12 m6 offset-m5">
							<span id="head">login</span>						
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<label>User Name</label>
							<input type="text" name="user_name" required/>
							<%
								if(msg!=null){%>
									<span id="err"><%=msg%></span>
								<%}%>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<label>Password</label>
							<input type="password" name="password" required/>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6 m3 offset-m3">
							<input class="center" type="text" name="captcha_text" maxlength="6" id="captcha_text" placeholder="enter captcha" required autocomplete="off"/>
						</div>
						<div class="input-field col s6 m3">
							<input type="button" value="Validate" id="validate_captcha"/>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6 m3" id="captcha">
							<input style="text-decoration-line: line-through;letter-spacing:4px;" class="center" type="text" name="captcha" value="${recaptcha}" id="captcha_box" readonly/>
						</div>
						<div class="col s6 m3">
							<img src="images/loader.png" width="40px" id="loader">
						</div>
					</div>
					<div class="row">
						<div class="col s6 m6 offset-m3">
							<button class="btn left  offset-m3 orange" id="sg_btn" disabled>SignIn</button>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m6 offset-m3">
							<a href="forget.do" class="green-text">forget Password</a>
						</div>
					</div>
				</form>
			</div>
		</div>



		<!--<div class="container">
			<div class="col s12 m6 center">
				<form action="signin.do" method="post" id="form">
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<label class="white-text">User Name</label>
							<input type="text" name="user_name"/>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m6 offset-m3">
							<label class="white-text">Password</label>
							<input type="password" name="password"/>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m6 offset-m3">
							<button class="btn left  offset-m3">SignIn</button>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m6 offset-m1">
							<a href="#">forget Password</a>
						</div>
					</div>
				</form>
			</div>
		</div>-->

	<%@ include file="footer.jsp"%>

	<script src="js/signin.js"></script>
 </body>
</html>

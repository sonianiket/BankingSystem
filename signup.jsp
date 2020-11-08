<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
 <head>
  <title>SignUp</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/signup.css">
 </head>
 <body>

	<%@ include file="header.jsp"%>	

	<div class="container" id="form-container">
		<h6 class="orange-text"><u>Bank Details</u></h6>
		<form action="signup.do" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="input-field col s6">
				<select name="bank_name" id="banks">
					<option value="0">Select</option>
					<c:forEach var="banks" items="${bank}">
						<option value="${banks.bankId}">${banks.bankName}</option>
					</c:forEach>
				</select>
				<label>Bank Name</label>
			</div>	
			<div class="input-field col s6">
				<label>IFSC Code</label>
				<input type="text" name="ifsc_code" id="ifsc_code" placeholder="IFSC Code" readonly>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input type="text" name="account_name">
				<label>Account Name</label>
			</div>
		</div>

		<div class="row">
			<h6 class="orange-text"><u>User Details</u></h6>
			<div class="input-field col s6">
				<input type="text" name="first_name">
				<label>First Name</label>
			</div>
			<div class="input-field col s6">
				<input type="text" name="last_name">
				<label>Last Name</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input type="email" name="email" placeholder="ex. xyz@gmail.com">
				<label>Email</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input type="password" name="password" id="password">
				<label>Password</label>
				<span id="info">Password should contain alphanumeric,predefined wild characters eg.(0-9,a-z,A-Z,@,*,#)</span>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12" id="pass_div">
				<input type="password" name="confirm_password" id="conf_password"> 
				<label>Confirm Password</label>
				<span id="info_spn"></span>
				<%
				String err = (String)request.getAttribute("err");
				if(err!=null){%>
				<span style="color:red; font-size:12px;" id="err_show"><%= err %></span>
				<% } %>

			</div>
		</div>

		<div class="row">
			<h6 class="orange-text"><u>Personal Details</u></h6>
			<div class="input-field col s12">
				<input type="text" name="mobile" id="mobile" data-length="10" maxlength="10">
				<label>Mobile No.</label>
				<span id="mob_spn"></span>
				<%
					String mobErr = (String)request.getAttribute("mob_err");
					if(mobErr!=null){%>
					<span style="color:red; font-size:12px;"><%= mobErr %></span>
				<% } %>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<textarea name="address"  class="materialize-textarea"></textarea>
				<label>Address</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input type="text" name="dob" class="datepicker">
				<label>DOB</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<label>Gender</label><br><br>
				<p>
				<label>
					<input class="with-gap" type="radio" name="gender" value="male" checked><span>Male</span>
				</label>
				<label>
					<input class="with-gap" type="radio" name="gender" value="female"><span>Female</span>
				</label>
				</p>
			</div>
		</div>
		<div class="row">
		  <div class="custom-file">
			  <input type="file" name="file" id="fille"> 
		  </div>
		</div>
		<input type="submit" value="submit" id="btn" disabled>
	<form>
	</div>

	
	

  <%@ include file="footer.jsp"%>

	<script>
		$(document).ready(function(){
			$('select').formSelect();

			$('input#mobile').characterCounter();

			$('.datepicker').datepicker();
		  });
	</script>

	 <script src="js/passwordValidate.js"></script>
 </body>
</html>

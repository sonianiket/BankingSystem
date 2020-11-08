<!doctype html>
<html lang="en">
  <head>
	<%@ include file="imports.jsp"%>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" + integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Save User</title>
	<style>
		label{
			color:#3498DB;
			font-weight:bold;
			letter-spacing:1px;
		}
		.form-control{
			color:white;
		}
		#btn{
			margin-bottom:3%;
		}
		#box{
			margin-top:2%;
		}
		
	</style>
  </head>
  <body class="bg-dark">
	<div class="container" id="box">
		<form action="save.do" method="post">
			<div class="row orange-text">
				<h6><u>Bank Details</u></h6>
			</div>
		  <div class="form-row">
			<div class="form-group col-md-6">
			  <label for="inputEmail4">Bank Name</label>
			  <input type="text" class="form-control" name="bank_name" value="${user.bankName}" >
			</div>
			<input type="hidden" name="hidden" value="${user.id}">
			<input type="hidden" name="hidden" value="${user.pendingId}">
			<div class="form-group col-md-6">
			  <label for="inputPassword4">IFSC Code</label>
			  <input type="text" class="form-control" name="ifsc_code" value="${user.IFSCCode}" id="inputPassword4">
			</div>
		  </div>
		  <div class="form-group">
			<label for="inputAddress">Account Name</label>
			<input type="text" class="form-control" name="account_name" value="${user.accountName}" id="inputAddress">
		  </div>
		  <div class="row orange-text">
			<h6><u>User Details</u></h6>
		  </div>
		  <div class="form-group">
			<label for="inputAddress2">First Name</label>
			<input type="text" class="form-control" name="first_name" value="${user.firstName}" id="inputAddress2">
		  </div>
		  
		  <div class="form-group">
			  <label for="inputCity">Last Name</label>
			  <input type="text" class="form-control" name="last_name" value="${user.lastName}" id="inputCity">
		  </div>
		  
		  <div class="form-group">
			<label for="inputAddress2">Email</label>
			<input type="email" class="form-control" name="email" value="${user.email}" id="inputAddress2">
		  </div>

		   <div class="form-group">
			<label for="inputAddress2">Password</label>
			<input type="password" class="form-control" name="password" value="${user.password}" id="inputAddress2">
		  </div>

		  <div class="row orange-text">
			<h6><u>Personal Details</u></h6>
		  </div>

		  <div class="form-group">
			<label for="inputAddress2">Mobile No.</label>
			<input type="text" class="form-control" name="mobile" value="${user.mobile}" id="inputAddress2">
		  </div>

		  <div class="form-group">
			<label for="inputAddress2">Address</label>
			<input type="text" class="form-control" name="address" value="${user.address}" id="inputAddress2">
		  </div>

		  <div class="form-group">
			<label for="inputAddress2">DOB</label>
			<input type="text" class="form-control" name="dob" value="${user.DOB}" id="inputAddress2">
		  </div>
		 
		  <div class="row">
			<div class="input-field col s12">
				<label class="text-primary">Gender</label><br><br>
				<p>
				<label>
					<input class="with-gap" type="radio" name="gender" value="male" checked><span class="white-text">Male</span>
				</label>
				<label>
					<input class="with-gap" type="radio" name="gender" value="female"><span class="white-text">Female</span>
				</label>
				</p>
			</div>
		</div>

		<div class="form-group">
			<label for="inputAddress2">Activation Code</label>
			<input type="text" class="form-control" name="activation_code" value="${user.activationCode}" id="inputAddress2">
		  </div>

		<div class="form-group">
			<label for="inputAddress2">File Name</label>
			<input type="text" class="form-control" name="file_name" value="${user.fileName}" id="inputAddress2">
		 </div>

		  
		 
		  <button type="submit" class="btn btn-primary" id="btn">Save</button>
	</form>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
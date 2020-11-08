<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/admin.css">
  
	<style>
		#home{
			background-color:orange;
			font-weight:bold;
		}
	</style>

 </head>
 <body>
	<%@ include file="adminheader.jsp"%>
		<input type="hidden" value="${adminlogin.adminId}" id="userId">
		<h6 class="green-text right">Welcome Admin</h6>
		<div class="row">
			<div class="col s3 m2" id="lft">
				<button id="add_btn">Add Bank</button><br><br>
				<button id="view_btn">View Banks</button>
			</div>
			<div class="col s9 m10">
				<div id="add_bank">
					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="bank_name" id="bank_name" placeholder="enter bank name"/>
							<label>Bank Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="ifsc_code" id="ifsc_code" placeholder="enter IFSC Code"/>
							<label>IFSC Code</label>
						</div>
					</div>
					<button id="save_btn">Save</button>
				</div>
			</div>

			<div class="col s9 m10">
				<div id="view_bank">
					<table id="view_bank_tbl">
						<tr>
							<th class="center">BankId</th>
							<th class="center">Bank Name</th>
							<th class="center">IFSC Code</th>
						</tr>
					</table>
				</div>
			</div>
		</div>
	<%@ include file="adminfooter.jsp"%>
	
	<script src="js/admin.js"></script>
 </body>
</html>

<!doctype html>
<html lang="en">
 <head>
  <title>Profile</title>
  <%@ include file="imports.jsp"%>
  <link rel="stylesheet" type="text/css" href="css/profile.css">
 </head>
 <body>
	<%@ include file="header.jsp"%>
		<div class="col s12 m6">
			<table id="table1">
				<tr>
					<td width="40%">
						<img src="image.do" class="materialboxed" id="prof_img">
					</td>
					<td id="rht_td">
						<table id="table2">
							<tr>
								<th>First Name : <th>
								<td>${userlogin.firstName}</td>
							</tr>
							<tr>
								<th>Last Name : <th>
								<td>${userlogin.lastName}</td>
							</tr>
							<tr>
								<th>Bank : <th>
								<td>${userlogin.bank.bankName}</td>
							</tr>
							<tr>
								<th>IFSC Code : <th>
								<td>${userlogin.bank.IFSCCode}</td>
							</tr>
							<tr>
								<th>Account Number : <th>
								<td>${userlogin.account.accountNumber}</td>
							</tr>
							<tr>
								<th>Email : <th>
								<td>${userlogin.email}</td>
							</tr>
							<tr>
								<th>Address : <th>
								<td>${userlogin.address}</td>
							</tr>
							<tr>
								<th>Mobile No. : <th>
								<td>${userlogin.mobile}</td>
							</tr>
							<tr>
								<th>DOB : <th>
								<td>${userlogin.DOB}</td>
							</tr>
						</table>
					</td>
				</tr>
			<table>
		</div>
	
	
		<%@ include file="footer.jsp"%>
		
	<script>
		$(document).ready(function(){
		$('.materialboxed').materialbox();
			$('.sidenav').sidenav();
	  });
	</script>
	
 </body>

</html>

<!doctype html>
<html lang="en">
 <head>
  
  <title>Welcome</title>
  <%@ include file="imports.jsp"%>

  <style>
	#welcome{
		background-color:#25CCF7;
		height:150px;
		border:1 px solid black;
		border-radius:5px;
		color:white;
	}
  </style>
 </head>
 <body>
	<div class="container">
	<div id="welcome">
		<h1 class="center">Welcome</h1>
		<h5 class="center">Your Form has been submitted and waiting for approval from admin<h5>
	</div>
	</div>
	 <%@ include file="footer.jsp"%>

	 <a href="index.jsp" class="right" style="margin-right:15%; margin-top:6%; font-size:17px;">Home</a>
 </body>
</html>

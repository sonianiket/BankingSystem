<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<nav class="blue lighten-2">
		<div class="nav-wrapper">
		  <a href="#!" class="brand-logo" id="logo_title">Banking System</a>
		  <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
		  <ul class="right hide-on-med-and-down">
		  <c:choose>
			<c:when test="${userlogin==null}">
				<li><a href="index.do"  class="menu">Home</a></li>
				<li><a href="signuppage.do" class="menu">SignUp</a></li>
				<li><a href="mobile.html" class="menu">About Us</a></li>
				<li><a href="mobile.html" class="menu">Contact Us</a></li>
				<!-- Modal Trigger -->
				<li><a class="waves-effect waves-light btn modal-trigger" href="signinpage.do">SignIn</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="userScreen.do"  class="menu">Home</a></li>
				<li><a href="profile.do" class="menu">
					<div class="chip">
						<img src="image.do" alt="Contact Person">
						${userlogin.firstName}
					</div>
				</a></li>
			<!--	<li><a href="chatboxpage.do" class="menu">ChatBox</a></li> -->
				<li><a href="index.do" class="menu">LogOut</a></li>
			</c:otherwise>
		  </c:choose>
		  </ul>

		</div>
	</nav>

	

	

	
	  <ul class="sidenav" id="mobile-demo">
	  <c:choose>
		<c:when test="${userlogin!=null}">
			<li><a href="userScreen.do">Home</a></li>
			<li><a href="profile.do">Profile</a></li>
			<li><a href="index.do">LogOut</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="index.do">Home</a></li>
			<li><a href="signuppage.do">SignUp</a></li>
			<li><a href="signin.jsp">SignIn</a></li>
			<li><a href="mobile.html">About Us</a></li>
		</c:otherwise>
	  </c:choose>
	  </ul>


	 
<!doctype html>
<html lang="en">
 <head>
  <title>Index Page</title>
  <%@ include file="imports.jsp"%>
 </head>
 <body>

<!--//////////////////////////////// Navbaar ///////////////////////////////////-->
	<%@ include file="header.jsp"%>
	
	  <div class="row">
		<div class="col s12 m6" id="lft_div">
			<h2>Welcome</h2>
			<h5>To Bank Management</h5>
		</div>
		<div class="col s12 m6">
			<img src="images/digi.jpg" id="body_img">
		</div>
	  </div>
 
 <!--/////////////////////////////// Modal Structure ////////////////////////////////////////////-->

  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4 class="center-align">SignIn</h4>
      <div class="row">
        <div class="col l6 m7">
      <div class="row">
    <form action="signin.do" method="post" class="col s12 offset-l6">
      <div class="row">
        <div class="input-field col s12">
          <input id="first_name" name="user_name" type="text" class="validate">
          <label for="first_name">User Name</label>
        </div>
      </div>  
      <div class="row">
        <div class="input-field col s12">
          <input id="password" name="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>  

  <button class="btn waves-effect waves-light" type="submit" name="action"><a onclick="M.toast({html: 'I am a toast'})"  class="white-text">Submit</a>
    <i class="material-icons right">send</i>
  </button>
        <br><br>
	<span class="blue-text">forget Password</span>

    </form>
		</div>
	</div>
   </div>
  </div>
 </div>
    

<!--///////////////////////////////// Footer ///////////////////////////-->

		<%@ include file="footer.jsp" %>


<!-- Script For JQuery -->
	  <script>
		$(document).ready(function(){
			$('.sidenav').sidenav();

			$('.modal').modal();
		});
	  </script>
 </body>
</html>

window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var no,r1;
var send_btn,send_btn1,send_btn2;
var spn_r1;
var box1,box2,box3;
var code;
var new_pass,conf_pass;
var spn3;
function getAllElements(){
	no = document.getElementById("no");
	send_btn = document.getElementById("send_btn");
	send_btn1 = document.getElementById("send_btn1");
	send_btn2 = document.getElementById("send_btn2");
	r1 = document.getElementById("r1");
	spn_r1 = document.getElementById("spn_r1");
	box1 = document.getElementById("box1");
	box2 = document.getElementById("box2");
	box3 = document.getElementById("box3");
	code = document.getElementById("code");
	new_pass = document.getElementById("new_pass");
	conf_pass = document.getElementById("conf_pass");
	spn3 = document.getElementById("spn3");
}

function setAllActions(){
	send_btn.onclick = sendEmail;
	send_btn1.onclick = verifyCode;
	send_btn2.onclick = changePassword;
}

//////////////////////////////////////// Email Verify ///////////////////////////////////////////////////
var send_req;
var email;
function sendEmail(){
	email = no.value;
	send_req = new XMLHttpRequest();
	send_req.open('get','resetpass.do?email='+no.value,false);
	send_req.onreadystatechange = passwordReset;
	send_req.send();
}

function passwordReset(){
	if(send_req.readyState==4&&send_req.status==200){
		if(send_req.responseText=="done"){
			alert("password Changed");
			box1.style.display = "none";
			box2.style.display = "inline";
			code.focus();
		}else{
			alert("failed");
			no.focus();
			no.value = "";
			spn_r1.innerHTML = "please enter correct email";
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////// Code Verify //////////////////////////////////////////////////////

var vrfy_req;
function verifyCode(){
	vrfy_req = new XMLHttpRequest();
	vrfy_req.open('get','verifycode.do?code='+code.value,false);
	vrfy_req.onreadystatechange = verified;
	vrfy_req.send();
}

function verified(){
	if(vrfy_req.readyState==4&&vrfy_req.status==200){
		if(vrfy_req.responseText=="verified"){
			alert("verified");
			box2.style.display = "none";
			box3.style.display = "inline";
		}else{
			alert("wrong");
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////// Change Password //////////////////////////////////////////////////
	var pass,repass;
	var chng_req;
	function changePassword(){
		//alert(new_pass.value+" Password "+conf_pass.value);
		
		pass = new_pass.value;
		repass = conf_pass.value;

		if(pass.length<8){
			spn3.innerHTML = "Password length should be more than 8 characters long";
			new_pass.focus();
			new_pass.value = "";
		}else if(repass!=pass){
				alert("Password Not Matched");
				conf_pass.focus();
				conf_pass.value = "";
		}else{
			spn3.innerHTML = "";
			alert("Matched");
			chng_req = new XMLHttpRequest();
			chng_req.open('get','changepassword.do?password='+repass+'&email='+email,false);
			chng_req.onreadystatechange = changedPass;
			chng_req.send();
			alert("send");
		}
		
		/*if(new_pass.value.length<8){
			spn3.innerHTML = "Password length should be more than 8 characters long";
			new_pass.focus();
			new_pass.value = "";
			if(conf_pass.value!=new_pass.value){
				alert("matched");
			}else{
				alert("password should be matched");
			}
		}else{
			alert("done");
		}*/
	}

	function changedPass(){
		if(chng_req.readyState==4&&chng_req.status==200){
			if(chng_req.responseText=="password changed"){
				alert("Successfully Changed");
				window.location = "index.do";
			}else{
				alert("Password Changed Failed");
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
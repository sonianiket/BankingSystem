window.onload = initAll();

var password,conf_password;
var info;
var pass_div;
var btn;
var info_spn;
var mobile,mob_spn;
var banks,ifsc_code;
function initAll(){
	getAllElements();
	setAllActions();
}

function getAllElements(){
	password = document.getElementById("password");
	conf_password = document.getElementById("conf_password");
	info = document.getElementById("info");
	pass_div = document.getElementById("pass_div");
	btn = document.getElementById("btn");
	info_spn = document.getElementById("info_spn");
	mobile = document.getElementById("mobile");
	mob_spn = document.getElementById("mob_spn");
	banks = document.getElementById("banks");
	ifsc_code = document.getElementById("ifsc_code");
}

function setAllActions(){
	password.onblur = checkPassworrd;
	conf_password.onblur = confirmPassword;
	mobile.onblur = countNumber;
	banks.onchange = selectIFSCCode;
}

///////////////////////////// Password Validation ///////////////////////////////////////////////////////////////

function checkPassworrd(){
	if(password.value.length<8){
		password.focus();
		password.value = "";
		info.innerHTML = "password should be 8 characters long.";
		info.style.color = "red";
	}else{
		info.innerHTML = "Password should contain alphanumeric,predefined wild characters eg.(0-9,a-z,A-Z,@,*,#)";
		info.style.color = "green";
	}
}

var req1;
//var spn;
function confirmPassword(){
	if(password.value==conf_password.value){
		info_spn.innerHTML = "";
		req1 = new XMLHttpRequest();
		req1.open('get','validate.do?pass='+password.value+"&conf_pass="+conf_password.value,true);
		req1.onreadystatechange = validateResponse;
		req1.send();
	}if(password.value!=conf_password.value){
		//spn = document.createElement("span");
		//spn.id = "conf_spn";
		info_spn.innerHTML = "please enter correct password";
		//pass_div.appendChild(spn);
		conf_password.focus();
		conf_password.value = "";
		//conf_password.onblur = function(){ spn.innerHTML = ""; }
	}
}

function validateResponse(){
	if(req1.readyState==4&&req1.status==200){
		if(req1.responseText=="success"){
			alert("Validate Successfull");	
			btn.disabled = false;
		}else{
			alert("Please enter correct password");
			
		}	
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////// Mobile Number Validation /////////////////////////////////////////////////////////////////

	function countNumber(){
		if(mobile.value.length!=10){
			mob_spn.innerHTML = "mobile number must contain 10 numbers";
			mobile.focus();
			mobile.value = "";
		}else{
			mob_spn.innerHTML = "";
		}
	}	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var ifsc_req;
function selectIFSCCode(){
	ifsc_req = new XMLHttpRequest();
	ifsc_req.open('get','getIFSCCode.do?bank_id='+banks.value,false);
	ifsc_req.onreadystatechange = ifscResponse;
	ifsc_req.send();
}

function ifscResponse(){
	if(ifsc_req.readyState==4&&ifsc_req.status==200){
		//alert("hello");
		//alert(ifsc_req.responseText);
		//var bank = eval(ifsc_req.responseText);
		var bank = JSON.parse(ifsc_req.responseText);	
		//alert(bank.IFSCCode);
		ifsc_code.value = bank.IFSCCode;
	}else{
		alert("Failed");
	}
}

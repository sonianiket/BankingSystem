window.onload = initAll;

function initAll(){
	getAllElements();
	setAllActions();
}

var otp_btn,otp_verify_btn,wd_btn;
var mobile;
var enter_otp;
function getAllElements(){
	otp_btn = document.getElementById("otp_btn");
	mobile = document.getElementById("mobile_no");
	otp_verify_btn = document.getElementById("otp_verify_btn");
	enter_otp = document.getElementById("enter_otp");
	wd_btn = document.getElementById("wd_btn");
}

function setAllActions(){
	otp_btn.onclick = sendOTP;
	otp_verify_btn.onclick = verifyOTP;
}

//////////////////////////// Send OTP //////////////////////////////////////////////////
var otp_req;
function sendOTP(){
	//alert(mobile.value);
	otp_req = new XMLHttpRequest();
	otp_req.open("get","sendotp.do?mobile="+mobile.value,true);
	otp_req.onreadystatechange = returnOTP;
	otp_req.send();
}

function returnOTP(){
	if(otp_req.readyState==4&&otp_req.status==200){
		if(otp_req.responseText=='done'){
			wd_btn.disabled = true;
			otp_btn.style.visibility = "hidden";
			otp_verify_btn.style.visibility = "visible";
			alert("successful");
		}	
	}
}
//////////////////////////////////////////////////////////////////////////////////////////

var vrfy_req;
function verifyOTP(){
	//alert(enter_otp.value);
	vrfy_req = new XMLHttpRequest();
	vrfy_req.open("get","verify.do?otp="+enter_otp.value,true);
	vrfy_req.onreadystatechange = verifyResult;
	vrfy_req.send();
}

function verifyResult(){
	
	if(vrfy_req.readyState==4&&vrfy_req.status==200){
		if(vrfy_req.responseText=='verified'){
			alert("Verified");
			otp_verify_btn.style.visibility = "hidden";
			wd_btn.disabled = false;
		}else{
			alert("wrong");
		}
	}
}



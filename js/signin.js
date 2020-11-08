window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var loader,captcha_box;
var validate_captcha;
var sg_btn;
function getAllElements(){
	loader = document.getElementById("loader");
	captcha_box = document.getElementById("captcha_box");
	validate_captcha = document.getElementById("validate_captcha");
	captcha_text = document.getElementById("captcha_text");
	sg_btn = document.getElementById("sg_btn");
}

function setAllActions(){
	loader.onclick = reloadCaptcha;	
	validate_captcha.onclick = validateCaptcha;
}

//////////////////////////////////////////////////////////////////////////////////////////

var captcha_req;
function reloadCaptcha(){
	loader.src = "images/loader.gif";
	captcha_req = new XMLHttpRequest();
	captcha_req.open('get','captchagenerate.do',true);
	captcha_req.onreadystatechange = foundCaptcha;
	captcha_req.send();
}

function foundCaptcha(){
	if(captcha_req.readyState==4&&captcha_req.status==200){
		loader.src = "images/loader.png";
		var captcha = captcha_req.responseText;
		captcha_box.value = captcha;
	}
}

///////////////////////////////////////////////////////////////////////////////////////////

var validate_req;
function validateCaptcha(){
	if(captcha_text.value.length!=0){
		validate_req = new XMLHttpRequest();
		validate_req.open('get','validatecaptcha.do?captcha='+captcha_text.value,false);
		validate_req.onreadystatechange = captchaResult;
		validate_req.send();
	}else{
		alert("null");
	}
}

function captchaResult(){
	if(validate_req.readyState==4&&validate_req.status==200){
		if(validate_req.responseText=="match"){
			validate_captcha.style.display = "none";
			loader.style.display = "none";
			sg_btn.disabled = false;
		}else{
			alert("not matched");
			validate_captcha.style.display = "block";
			captcha_text.value = "";
			reloadCaptcha();
		}	
	}
}
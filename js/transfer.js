window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var srch_input,search_div;
function getAllElements(){
	srch_input = document.getElementById("srch_input");
	search_div = document.getElementById("search_div");
}

function setAllActions(){
	srch_input.onkeyup = getData;
}

var data_req;
function getData(){
	data_req = new XMLHttpRequest();
	data_req.open('get','search.do?first_char='+srch_input.value,'value');
	data_req.onreadystatechange = getResult;
	data_req.send();
}
var spn;
function getResult(){
	if(data_req.readyState==4&&data_req.status==200){
		if(data_req.responseText!="not found"){
			//alert(data_req.responseText);
			var users = eval(data_req.responseText);
			search_div.style.visibility = "visible";
			spn = document.createElement("h6");
			spn.className = "spn_div";
			spn.innerHTML = users[0].accountNumber;
			var input = document.createElement("input");
			input.type = "hidden";
			input.name = "acc_id";
			spn.onclick = function(){ 
										srch_input.value = 	users[0].accountNumber;
										input.value = users[0].accountId;
										search_div.style.visibility = "hidden";
									};
			search_div.appendChild(input);
			search_div.appendChild(spn);
			
		}else{
			spn.innerHTML = "";
			search_div.style.visibility = "hidden";
		}
	}
}
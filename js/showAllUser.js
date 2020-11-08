window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var histBtn;
function getAllElements(){
	histBtn = document.getElementById("hist_btn");
}

function setAllActions(){
	histBtn.onclick = getHistory;
}

var his_req;
function getHistory(){
	his_req = new XMLHttpRequest();
	his_req.open('get','getHistory.do?account_id='+histBtn.value,false);
	his_req.onreadystatechange = HistoryAcknowledge;
	his_req.send();
}

function HistoryAcknowledge(){
	if(his_req.readyState==4&&his_req.status==200){
		if(his_req.responseText=="done"){
			window.location = "UserHistory.jsp";
		}else{
			alert("Failed");
		}
	}
}
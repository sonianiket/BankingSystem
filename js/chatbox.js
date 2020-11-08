window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var send_btn;
var userId;
var send_msg,main_msg,receive_msg;
function getAllElements(){
	send_btn = document.getElementById("send_btn");
	userId = document.getElementById("userId");
	send_msg = document.getElementById("send_msg");
	main_msg = document.getElementById("main_msg");
	receive_msg = document.getElementById("receive_msg");
}

function setAllActions(){
	send_btn.onclick = saveChat;
}

////////////////////////////////// Save Chat //////////////////////////////////////////////////////

var send_req1;
function saveChat(){
	send_req1 = new XMLHttpRequest();
	send_req1.open('get','chatsave.do?id='+userId.value+'&msg='+main_msg.value,true);
	send_req1.onreadystatechange = getChat;
	send_req1.send();
	main_msg.value = "";
}

var chat;
function getChat(){
	if(send_req1.readyState==4&&send_req1.status==200){
		alert(send_req1.responseText);
		chat = JSON.parse(send_req1.responseText);
		send_msg.value = chat.receiveChat;
		receive_msg.value = chat.sendChat;
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

var del_req;
function deleteUser(i){
	del_req = new XMLHttpRequest();
	del_req.open('get','deleteuser.do?user_id='+i,'true');
	del_req.onreadystatechange = deleteResponse;
	del_req.send();
}

function deleteResponse(){
	if(del_req.readyState==4&&del_req.status==200){
		if(del_req.responseText=="success"){
			alert("done");
			window.location = "deleteuserpage.do";
		}else{
			alert("failed");
		}
	}
}
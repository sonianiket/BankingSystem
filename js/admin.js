window.onload = initAll();

function initAll(){
	getAllElements();
	setAllActions();
}

var addBtn,saveBtn,viewBtn;
var addBank,viewBank,viewBankTbl;
var bankName,ifscCode;
var banks;
function getAllElements(){
	addBtn = document.getElementById("add_btn");
	saveBtn = document.getElementById("save_btn");
	addBank = document.getElementById("add_bank");
	bankName = document.getElementById("bank_name");
	ifscCode = document.getElementById("ifsc_code");
	viewBtn = document.getElementById("view_btn");
	viewBank = document.getElementById("view_bank");
	viewBankTbl = document.getElementById("view_bank_tbl");
}

function setAllActions(){
	addBtn.onclick = FormVisible;
	saveBtn.onclick = SaveBankDetails;
	viewBtn.onclick = TableVisible;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

function FormVisible(){
	addBank.style.display = "block";
	viewBank.style.display = "none";
	viewBtn.disabled = false;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var save_req;
function SaveBankDetails(){
	save_req = new XMLHttpRequest();
	save_req.open('get','saveBank.do?bank_name='+bankName.value+'&ifsc_code='+ifscCode.value,true);
	save_req.onreadystatechange = SaveResponse;
	save_req.send();
}

function SaveResponse(){
	if(save_req.readyState==4&&save_req.status==200){
		if(save_req.responseText=="done"){
			alert("Saved");
		}else{
			alert("not saved");
		}
	}
}

//////////////////////////////////////////////////////////////////////////////////

var get_req;
function TableVisible(){
	addBank.style.display = "none";
	viewBank.style.display = "block";
	
	get_req = new XMLHttpRequest();
	get_req.open('get','getBankDetails.do',false);
	get_req.onreadystatechange = BankDetails;
	get_req.send();
}

var row,col;
function BankDetails(){
	if(get_req.readyState==4&&get_req.status==200){
		viewBtn.disabled = true;
		banks = JSON.parse(get_req.responseText);
		for(i=0; i<banks.length; i++){
			row = document.createElement('tr');
			col1 = document.createElement('td');
			col2 = document.createElement('td');
			col3 = document.createElement('td');
			col1.className = "center";
			col2.className = "center";
			col3.className = "center";
			col1.innerHTML = banks[i].bankId;
			col2.innerHTML = banks[i].bankName;
			col3.innerHTML = banks[i].IFSCCode;
			row.appendChild(col1);
			row.appendChild(col2);
			row.appendChild(col3);
			viewBankTbl.appendChild(row);
		}
		
	}
}

////////////////////////////////////////////////////////////////
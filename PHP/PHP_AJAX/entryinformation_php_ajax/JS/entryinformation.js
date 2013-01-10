function set_foreign_key(key){
	document.getElementById('triptitle').value =key;
}
function show_entry(name,ngrad,nmin,nsec,egrad,emin,esec,cog,sog,btm,dtm,fahrtnach,manoever,vorsegel,grosssegel,notes,datum,triptitle){
	document.getElementById('triptitle').value=triptitle;
	document.getElementById('name').value=name;
	document.getElementById('ngrad').value=ngrad;
	document.getElementById('nmin').value=nmin;
	document.getElementById('nsec').value=nsec;
	document.getElementById('egrad').value=egrad;
	document.getElementById('emin').value=emin;
	document.getElementById('esec').value=esec;
	document.getElementById('cog').value=cog;
	document.getElementById('sog').value=sog;
	document.getElementById('btm').value=btm;
	document.getElementById('dtm').value=dtm;
	document.getElementById('fahrtnach').selectedIndex = fahrtnach;
	document.getElementById('manoever').selectedIndex = manoever;
	document.getElementById('vorsegel').selectedIndex = vorsegel;
	document.getElementById('grosssegel').selectedIndex = grosssegel;
	document.getElementById('notes').value=notes;
	document.getElementById('time').innerHTML=datum;
}

function edit_Node(regex, input, helpId){
	
	if(regex.test(input)|| input == ""){
		helpId.style.backgroundColor = "#FFFFFF"; 
		return true;
	}else{
		helpId.style.backgroundColor = "#FF0000"; 
		return false;
	}
  
}

function regEx1(inputField, helpId) {			
	return edit_Node(/^([A-Za-z'\-\s]{2,30})$/, inputField.value, helpId);
}
function regEx2(inputField, helpId) {			
	return edit_Node(/^([\d]{3,3})$/, inputField.value, helpId);
}
function regEx3(inputField, helpId) {			
	return edit_Node(/^([\d]{2,2})$/, inputField.value, helpId);
}
function regEx4(inputField, helpId) {			
	return edit_Node(/^([\d]{1,3}\.[\d]{1,1})$/, inputField.value, helpId);
}
function regEx5(inputField, helpId) {			
	return edit_Node(/^([\d]{1,4}\.[\d]{1,1})$/, inputField.value, helpId);
}
function regEx6(inputField, helpId) {			
	return edit_Node(/^([\d]{4,4})$/, inputField.value, helpId);
}
function regEx7(inputField, helpId) {			
	return edit_Node(/^([\d]{1,1}\.[\d]{4,4})$/, inputField.value, helpId);
}

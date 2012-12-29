function set_foreign_key(key){
	document.getElementById('triptitle').value =key;
}
function show_entry(name,ngrad,nmin,nsec,egrad,emin,esec,cog,sog,btm,dtm,notes,triptitle){
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
	document.getElementById('notes').value=notes;
}
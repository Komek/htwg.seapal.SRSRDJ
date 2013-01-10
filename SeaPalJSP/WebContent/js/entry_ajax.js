$(document).ready(function() {
	//HOLE WERT AUS HTTP GET REQUEST
	HTTP_GET_VARS=new Array();
	strGET=document.location.search.substr(1,document.location.search.length);
	if(strGET!=''){
	   gArr=strGET.split('&');
		 for(i=0;i<gArr.length;++i){
				v='';vArr=gArr[i].split('=');
			if(vArr.length>1){v=vArr[1];}
			HTTP_GET_VARS[unescape(vArr[0])]=unescape(v);
		}
	}
	function GET(v){
		if(!HTTP_GET_VARS[v]){
			return 'undefined';
		}
		return HTTP_GET_VARS[v];
	}
	

if(GET('triptitle')!=='undefined'){
	$("#form").keyup(function(e) {
		if(e.keyCode==13){
			document.getElementById('triptitle').value = GET('triptitle');
			entry = new Array(document.getElementById('name').value,
					document.getElementById('ngrad').value,
					document.getElementById('nmin').value,
					document.getElementById('nsec').value,
					document.getElementById('egrad').value,
					document.getElementById('emin').value,
					document.getElementById('esec').value,
					document.getElementById('cog').value,
					document.getElementById('sog').value,
					document.getElementById('btm').value,
					document.getElementById('dtm').value,
					document.getElementById('fahrtnach').options[fahrtnach.selectedIndex].value,
					document.getElementById('manoever').options[manoever.selectedIndex].value,
					document.getElementById('vorsegel').options[vorsegel.selectedIndex].value,
					document.getElementById('grosssegel').options[grosssegel.selectedIndex].value,
					document.getElementById('notes').value,
					document.getElementById('triptitle').value
			);
			ajax_entry();
		}
	});	
}else {

	$.ajax({
		type: 'GET',
		url : "http://localhost:8080/SeaPalJSP/Servlet_entryinfo?key="+GET('name'),
		dataType : "json",
		success : function(json) {
			$.each(json.Entry, function() {
				document.getElementById('grosssegel').selectedIndex = this['grosssegel'];
				document.getElementById('nsec').value=this['nsec'];
				document.getElementById('vorsegel').selectedIndex = this['vorsegel'];
				document.getElementById('esec').value=this['esec'];
				document.getElementById('triptitle').value = this['triptitle'];
				document.getElementById('time').innerHTML=this['time'];
				document.getElementById('sog').value=this['sog'];
				document.getElementById('dtm').value=this['dtm'];
				document.getElementById('nmin').value=this['nmin'];
				document.getElementById('btm').value=this['btm'];
				document.getElementById('ngrad').value=this['ngrad'];
				document.getElementById('name').value=this['name'];
				document.getElementById('cog').value=this['cog'];
				document.getElementById('egrad').value=this['egrad'];
				document.getElementById('fahrtnach').selectedIndex = this['fahrtNach'];
				document.getElementById('manoever').selectedIndex = this['manoever'];
				document.getElementById('notes').value=this['notes'];
				document.getElementById('emin').value=this['emin'];				
			});			
		}
	});
	
	$("#form").keyup(function(e) {
		if(e.keyCode==13){
			entry = new Array(document.getElementById('name').value,
					document.getElementById('ngrad').value,
					document.getElementById('nmin').value,
					document.getElementById('nsec').value,
					document.getElementById('egrad').value,
					document.getElementById('emin').value,
					document.getElementById('esec').value,
					document.getElementById('cog').value,
					document.getElementById('sog').value,
					document.getElementById('btm').value,
					document.getElementById('dtm').value,
					document.getElementById('fahrtnach').options[fahrtnach.selectedIndex].value,
					document.getElementById('manoever').options[manoever.selectedIndex].value,
					document.getElementById('vorsegel').options[vorsegel.selectedIndex].value,
					document.getElementById('grosssegel').options[grosssegel.selectedIndex].value,
					document.getElementById('notes').value,
					document.getElementById('triptitle').value
			);
			ajax_entry();
		}
	});	
}

function ajax_entry(){
	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/SeaPalJSP/Servlet_entryinfo',
		data : {'name' : entry[0],
			'ngrad' :  entry[1],
			'nmin' :  entry[2],
			'nsec' :  entry[3],
			'egrad' :  entry[4],
			'emin' :  entry[5],
			'esec' :  entry[6],
			'cog' :  entry[7],
			'sog' :  entry[8],
			'btm' :  entry[9],
			'dtm' :  entry[10],
			'fahrtnach' : entry[11],
			'manoever' :  entry[12],
			'vorsegel' :  entry[13],
			'grosssegel' :  entry[14],
			'notes' :  entry[15],
			'triptitle' :  entry[16]},
		success: 
			window.location.href = "./tripinformation.php?triptitle="+entry[16]
	});
}
});

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

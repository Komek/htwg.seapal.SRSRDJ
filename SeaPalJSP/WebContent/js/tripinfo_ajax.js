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
	

if(GET('registernr')!=='undefined'){

	$("#form").keyup(function(e) {
		if(e.keyCode==13){
			var tank;
			if($("#tankgefuellt").attr('checked')){
				tank=1;
			}else{
				tank=0;
			}
			document.getElementById('registernr').value = GET('registernr');
			trip = new Array(document.getElementById('title').value,
					document.getElementById('von').value,
					document.getElementById('nach').value,
					document.getElementById('skipper').value,
					document.getElementById('crew').value,
					document.getElementById('start').value,
					document.getElementById('ende').value,
					document.getElementById('dauer').value,
					document.getElementById('motor').value,
					tank,
					document.getElementById('notes').value,
					GET('registernr')
					);
			ajax_trip();
		}
	});	
}else {

		$.ajax({
			type: 'GET',
			url : "http://localhost:8080/SeaPalJSP/Servlet_tripinfo?key="+GET('triptitle'),
			dataType : "json",
			success : function(json) {
				$.each(json.Trip, function() {
					document.getElementById('dauer').value =this['dauer'];
					document.getElementById('ende').value =this['ende'];
					document.getElementById('title').value =this['title'];
					document.getElementById('registernr').value =this['registernr'];
					document.getElementById('von').value =this['von'];
					document.getElementById('start').value =this['start'];
					document.getElementById('motor').value =this['motor'];
					document.getElementById('crew').value =this['crew'];
					document.getElementById('skipper').value =this['skipper'];
					document.getElementById('notes').value =this['notes'];
					if(this['tankgefuellt'] == 1){
						document.getElementById('tankgefuellt').checked = true;
					}else{
						document.getElementById('tankgefuellt').checked = false;
					}
					document.getElementById('nach').value =this['nach'];
				});			
			}
		});
		
		getUebersicht(GET('triptitle'));
		
		$("#form").keyup(function(e) {
			if(e.keyCode==13){
				var tank;
				if($("#tankgefuellt").attr('checked')){
					tank=1;
				}else{
					tank=0;
				}
				trip = new Array(document.getElementById('title').value,
						document.getElementById('von').value,
						document.getElementById('nach').value,
						document.getElementById('skipper').value,
						document.getElementById('crew').value,
						document.getElementById('start').value,
						document.getElementById('ende').value,
						document.getElementById('dauer').value,
						document.getElementById('motor').value,
						tank,
						document.getElementById('notes').value,
						document.getElementById('registernr').value
						);
				ajax_trip();
			}
		});
		
		
		
		
		
		$("#newEntry").click(function(){
		    document.location.href='./entryinformation.php?triptitle='+GET('triptitle');
		});
		
		$("#delete").click(function(){
			var name = selected_row_key;
			$.ajax({
				type:'GET',
				url : 'http://localhost:8080/SeaPalJSP/Servlet_entryinfo?wert='+name,
				success : function() {
					getUebersicht(GET('triptitle'));
				}
			});
		});
		
		

}
function ajax_trip(){
	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/SeaPalJSP/Servlet_tripinfo',
		data : {'title' : trip[0],
			'von' :  trip[1],
			'nach' :  trip[2],
			'skipper' :  trip[3],
			'crew' :  trip[4],
			'start' :  trip[5],
			'ende' :  trip[6],
			'dauer' :  trip[7],
			'motor' :  trip[8],
			'tankgefuellt' :  trip[9],
			'notes' :  trip[10]		,
			'registernr' : trip[11]},
		success: 
			window.location.href = "./triplist.php?val="+trip[11]
	});
}



});

function getUebersicht(triptitle) {
	$.ajax({	
		type: 'GET',
		url : "http://localhost:8080/SeaPalJSP/Servlet_entryinfo?triptitle="+triptitle,
		dataType : "json",
		success : function(json) {
			var ergebnis = "";
			$.each(json.Entrys, function() {
				var name = this['name'];
				ergebnis +="<tr class='row' onclick='set_values(this);'>";
				ergebnis +="<td>"+name+"</td>";
				ergebnis +="<td>"+this['time']+"</td>";
				ergebnis +="<td>"+this['ngrad']+"MIN "+this['nmin']+"' "+this['nsec']+"'' </td>";
				ergebnis +="<td>"+this['egrad']+"MIN "+this['emin']+"' "+this['esec']+"'' </td>";
				ergebnis +="<td>COG "+this['cog']+"</td>";
				ergebnis +="<td>SOG "+this['sog']+"</td>";
				ergebnis +="<td style='display:none'>"+this['triptitle']+"</td>";
				ergebnis +="<td><a style='text-decoration:none' href='./entryinformation.php?name="+name+"'>Entry</a></td>";
				ergebnis +="</tr>";
			});			
			$("#uebersicht").html(ergebnis);
		}
	});
}

function set_values(tableRow){
	var nodes = tableRow.getElementsByTagName("td");
	selected_row_key=nodes[0].innerHTML;
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
	return edit_Node(/^([A-Za-z'\-\s]{2,20})$/, inputField.value, helpId);
}
function regEx3(inputField, helpId) {			
	return edit_Node(/^(20|21|22|23|[01]\d|\d)(([:][0-5]\d){1,2})$/, inputField.value, helpId);
}
function regEx4(inputField, helpId) {			
	return edit_Node(/^([\d]{1,3}\.[\d]{2,2})$/, inputField.value, helpId);
}
function regEx5(inputField, helpId) {			
	return edit_Node(/^([\d]{4,4})$/, inputField.value, helpId);
}
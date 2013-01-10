$(document).ready(function() {
	getUebersicht();
	$("#form").keyup(function(e) {
		if(e.keyCode==13){
			var boat_values = $('form').serializeArray();
			$.ajax({
				type : 'POST',
				url : 'boatinformation.jsp',
				data : boat_values,
				success : function() {
					getUebersicht();
					reset_form();
					
				}
			});
		}
	});
	$("#delete").click(function(){
		var eingabefeld = document.getElementById("registernr");
		$.ajax({
			type:'GET',
			url : "http://localhost:8080/SeaPalJSP/Servlet_boatinfo?wert="+escape(eingabefeld.value),
			success : function() {
				getUebersicht();
				reset_form();
			}
		});
	});
});

function getUebersicht() {
	$.ajax({
		type: 'POST',
		url : "http://localhost:8080/SeaPalJSP/Servlet_boatinfo",
		dataType : "json",
		success : function(json) {
			var ergebnis = "";
			$.each(json.Boote, function() {
				
				ergebnis +="<tr class='row' onclick='set_values(this);'>";
				ergebnis +="<td>"+this['bootsname']+"</td>";
				ergebnis +="<td style='display:none'>"+this['registernr']+"</td>";
				ergebnis += "<td style='display:none'>"+this['segelzeichen']+"</td>";
				ergebnis +="<td style='display:none'>"+this['heimathafen']+"</td>";
				ergebnis +="<td style='display:none'>"+this['yachtclub']+"</td>";
				ergebnis +="<td>"+this['eigner']+"</td>";
				ergebnis +="<td style='display:none'>"+this['versicherung']+"</td>";
				ergebnis +="<td style='display:none'>"+this['rufzeichen']+"</td>";
				ergebnis +="<td>"+this['typ']+"</td>";
				ergebnis +="<td>"+this['konstrukteur']+"</td>";
				ergebnis +="<td>"+this['laenge']+"</td>";
				ergebnis +="<td style='display:none'>"+this['breite']+"</td>";
				ergebnis +="<td style='display:none'>"+this['tiefgang']+"</td>";
				ergebnis +="<td style='display:none'>"+this['masthoehe']+"</td>";
				ergebnis +="<td style='display:none'>"+this['verdraengung']+"</td>";
				ergebnis +="<td style='display:none'>"+this['rigArt']+"</td>";
				ergebnis +="<td style='display:none'>"+this['baujahr']+"</td>";
				ergebnis +="<td style='display:none'>"+this['motor']+"</td>";
				ergebnis +="<td style='display:none'>"+this['tankgroesse']+"</td>";
				ergebnis +="<td style='display:none'>"+this['wassertankgroesse']+"</td>";
				ergebnis +="<td style='display:none'>"+this['abwassertankgroesse']+"</td>";
				ergebnis +="<td style='display:none'>"+this['grosssegelgroesse']+"</td>";
				ergebnis +="<td style='display:none'>"+this['genuagroesse']+"</td>";
				ergebnis +="<td style='display:none'>"+this['spi']+"</td>";
				ergebnis +="<td><a style='text-decoration:none' href='./triplist.php?val="+this['registernr']+"'>Trips</a></td>";
				ergebnis +="</tr>";
			});			
			$("#uebersicht").html(ergebnis);
		}
	});
}

function set_values(tableRow){
	var nodes = tableRow.getElementsByTagName("td");
	selected_row_key=nodes[1].innerHTML;
	document.getElementById("bootsname").value = nodes[0].innerHTML;
	document.getElementById("registernr").value = nodes[1].innerHTML;
	document.getElementById("segelzeichen").value = nodes[2].innerHTML;
	document.getElementById("heimathafen").value = nodes[3].innerHTML;
	document.getElementById("yachtclub").value = nodes[4].innerHTML;
	document.getElementById("eigner").value = nodes[5].innerHTML;
	document.getElementById("versicherung").value = nodes[6].innerHTML;
	document.getElementById("rufzeichen").value = nodes[7].innerHTML;
	document.getElementById("typ").value = nodes[8].innerHTML;
	document.getElementById("konstrukteur").value = nodes[9].innerHTML;
	document.getElementById("laenge").value = nodes[10].innerHTML;
	document.getElementById("breite").value = nodes[11].innerHTML;
	document.getElementById("tiefgang").value = nodes[12].innerHTML;
	document.getElementById("masthoehe").value = nodes[13].innerHTML;
	document.getElementById("verdraengung").value = nodes[14].innerHTML;
	document.getElementById("rigArt").value = nodes[15].innerHTML;
	document.getElementById("baujahr").value = nodes[16].innerHTML;
	document.getElementById("motor").value = nodes[17].innerHTML;
	document.getElementById("tankgroesse").value = nodes[18].innerHTML;
	document.getElementById("wassertankgroesse").value = nodes[19].innerHTML;
	document.getElementById("abwassertankgroesse").value = nodes[20].innerHTML;
	document.getElementById("grosssegelgroesse").value = nodes[21].innerHTML;
	document.getElementById("genuagroesse").value = nodes[22].innerHTML;
	document.getElementById("spi").value = nodes[23].innerHTML;	
}

function reset_form(){
	document.getElementById('registernr').value="";
	document.getElementById('bootsname').value="";
	document.getElementById('segelzeichen').value="";
	document.getElementById('heimathafen').value="";
	document.getElementById('yachtclub').value="";
	document.getElementById('eigner').value="";
	document.getElementById('versicherung').value="";
	document.getElementById('rufzeichen').value="";
	document.getElementById('typ').value="";
	document.getElementById('konstrukteur').value="";
	document.getElementById('laenge').value="";
	document.getElementById('breite').value="";
	document.getElementById('tiefgang').value="";
	document.getElementById('masthoehe').value="";
	document.getElementById('verdraengung').value="";
	document.getElementById('rigArt').value="";
	document.getElementById('baujahr').value="";
	document.getElementById('motor').value="";
	document.getElementById('tankgroesse').value="";
	document.getElementById('wassertankgroesse').value="";
	document.getElementById('abwassertankgroesse').value="";
	document.getElementById('grosssegelgroesse').value="";
	document.getElementById('genuagroesse').value="";
	document.getElementById('spi').value="";
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
	return edit_Node(/^([\w]{2,30})$/, inputField.value, helpId);
}
function regEx3(inputField, helpId) {			
	return edit_Node(/^([\w]{1})$/, inputField.value, helpId);
}
function regEx4(inputField, helpId) {			
	return edit_Node(/^([A-Za-z\-\s]{2,30})$/, inputField.value, helpId);
}
function regEx5(inputField, helpId) {			
	return edit_Node(/^([\w'\-\s]{2,30})$/, inputField.value, helpId);
}
function regEx6(inputField, helpId) {			
	return edit_Node(/^([A-Za-z\-\s]{2,30})$/, inputField.value, helpId);
}
function regEx7(inputField, helpId) {			
	return edit_Node(/^([\d]{1,4}\.[\d]{2})$/, inputField.value, helpId);
}
function regEx8(inputField, helpId) {			
	return edit_Node(/^([\d]{1,4})$/, inputField.value, helpId);
}

function regEx9(inputField, helpId) {			
	return edit_Node(/^([\d]{2,4})$/, inputField.value, helpId);
}


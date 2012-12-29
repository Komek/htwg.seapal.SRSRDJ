function update_div(){
	$('#dynamic_view').load('dynamic_view.php');
	reset_form();
}

function Change_Background(tableRow){
	for (var i = 0; i < document.getElementsByTagName("tr").length; i++) {
	    document.getElementsByTagName("tr")[i].style.backgroundColor = "white";
	}
	tableRow.style.backgroundColor = "#00BFFF";

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


				
	
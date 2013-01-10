function show_trip(title,von,nach,skipper,crew,start,ende,dauer,motor,notes){
	document.getElementById('triptitle').value =title;
	document.getElementById('von').value =von;
	document.getElementById('nach').value =nach;
	document.getElementById('skipper').value =skipper;
	document.getElementById('crew').value =crew;
	document.getElementById('start').value =start;
	document.getElementById('ende').value =ende;
	document.getElementById('dauer').value =dauer;
	document.getElementById('motor').value =motor;
	document.getElementById('notes').value =notes;
}
function set_foreign_key(key){
	document.getElementById('registernr').value =key;
}

function Change_Background(tableRow){
	for (var i = 0; i < document.getElementsByTagName("tr").length; i++) {
	    document.getElementsByTagName("tr")[i].style.backgroundColor = "white";
	}
	tableRow.style.backgroundColor = "#00BFFF";
	var nodes = tableRow.getElementsByTagName("td");
	selected_row_key=nodes[0].innerHTML;
	selected_row_fk=nodes[6].innerHTML;
}

function delete_entry(){
	window.location.href = "./tripinformation.php?delete="+selected_row_key+"&fk="+selected_row_fk;
}

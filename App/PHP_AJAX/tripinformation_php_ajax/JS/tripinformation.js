function show_trip(title,von,nach,skipper,crew,start,ende,dauer,motor,tankgefuellt,notes){
	if(tankgefuellt == 1){
		document.getElementById('tankgefuellt').checked = true;
	}else{
		document.getElementById('tankgefuellt').checked = false;
	}
	
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
	$.ajax({
		type: 'POST',
		url: 'process.php',
		data: {
			'action' : 'delete',
			'key' : selected_row_key,	
		},
		dataType : 'json',
		 success : function(data){
		 	alert(data['msg']);
		 	$('#dynamic_view').empty();
			$('#dynamic_view').load('entry_table.php?val='+selected_row_fk);
		 }
	});
}
function trip_send(trip){
	$.ajax({
		type: 'POST',
		url: 'process.php',
		data: {
			'action' : 'insert',
			'registernr' : trip[0],
			'triptitle' : trip[1],
			'von' :  trip[2],
			'nach' :  trip[3],
			'skipper' :  trip[4],
			'crew' :  trip[5],
			'start' :  trip[6],
			'ende' :  trip[7],
			'dauer' :  trip[8],
			'motor' :  trip[9],
			'tankgefuellt' :  trip[10],
			'notes' :  trip[11]		
		},
		dataType : 'json',
		success : function(data){
		 	alert(data['msg']);
		 	window.location.href = "../triplist_php_ajax/triplist.php?val="+trip[0];
		}
	});
}
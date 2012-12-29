function Change_Background(tableRow){
	for (var i = 0; i < document.getElementsByTagName("tr").length; i++) {
	    document.getElementsByTagName("tr")[i].style.backgroundColor = "white";
	}
	tableRow.style.backgroundColor = "#00BFFF";
	var nodes = tableRow.getElementsByTagName("td");
	selected_row_key=nodes[0].innerHTML;
	selected_row_fk=nodes[6].innerHTML;
}

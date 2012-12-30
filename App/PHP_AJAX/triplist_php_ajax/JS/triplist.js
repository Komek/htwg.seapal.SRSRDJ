function set_keys(tableRow){
	var nodes = tableRow.getElementsByTagName("td");
	selected_row_key=nodes[0].innerHTML;
	selected_row_fk=nodes[6].innerHTML;
}

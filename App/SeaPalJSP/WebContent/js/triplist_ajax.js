$(document).ready(function() {
	//Registernr über HTTP GET AUSLESEN
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
	var regnr = HTTP_GET_VARS['val'];
	
	$("#headline").html("Trips von Boot: "+regnr);
	getUebersicht(regnr);

	$("#delete").click(function(){
		var title = selected_row_key;
		$.ajax({
			type:'GET',
			url : 'http://localhost:8080/SeaPalJSP/Servlet_triplist?wert='+title,
			success : function() {
				getUebersicht(regnr);
			}
		});
	});
	
	$("#newTrip").click(function(){
	    document.location.href='./tripinformation.php?registernr='+regnr;
	});
});


function getUebersicht(regnr) {
	$.ajax({
		type: 'GET',
		url : "http://localhost:8080/SeaPalJSP/Servlet_triplist?registernr="+regnr,
		dataType : "json",
		success : function(json) {
			var ergebnis = "";
			$.each(json.Trips, function() {
				ergebnis +="<tr class='row' onclick='set_values(this);'>";
				ergebnis +="<td>"+this['title']+"</td>";
				ergebnis +="<td>"+this['von']+"</td>";
				ergebnis +="<td>"+this['nach']+"</td>";
				ergebnis +="<td>"+this['skipper']+"</td>";
				ergebnis +="<td>"+this['start']+"</td>";
				ergebnis +="<td>"+this['ende']+"</td>";
				ergebnis +="<td style='display:none'>"+this['registernr']+"</td>";
				ergebnis +="<td><a style='text-decoration:none' href='./tripinformation.php?triptitle="+this['title']+"'>Tripinformation</a></td>";
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


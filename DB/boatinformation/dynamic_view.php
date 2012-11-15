<?php
   $result = mysql_query("SELECT bootsname,registernr,typ,konstrukteur,laenge,eigener FROM boatinformation");
	echo "	<table border='1' rules='groups' cellspacing='10' cellpadding='10' >
			<thead><tr><th>Bootsname</th><th>RegisterNr</th><th>Typ</th><th>Konstrukteur</th><th>Laenge</th><th>Inhaber</th></tr></thead>
			<tfoot>
			<tr><td><input type='button' onclick='window.location.reload()' value='Aktualisieren'/></td>
				<td><input type='button' onclick='delete.php' value='Loeschen'/></td>
			</tr>
			</tfoot>
			<tbody>	";
	while ($row = mysql_fetch_array($result)) {
		echo "<tr class='row' onclick='Change_Background(this);'>";
		echo "<td>".$row['bootsname']."</td>";
		echo "<td>".$row['registernr']."</td>";
		echo "<td>".$row['typ']."</td>";
		echo "<td>".$row['konstrukteur']."</td>";
		echo "<td>".$row['laenge']."</td>";
		echo "<td>".$row['eigener']."</td>";
		echo "</tr>";
	}
	echo "</tbody></table>";
?>

<script type="text/javascript" src="../Scripts/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function Change_Background(tableRow){
		for (var i = 0; i < document.getElementsByTagName("tr").length; i++) {
		    document.getElementsByTagName("tr")[i].style.backgroundColor = "white";
		}
		tableRow.style.backgroundColor = "#00BFFF";
	}
</script>

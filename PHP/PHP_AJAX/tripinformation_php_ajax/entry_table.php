<?php
	$connection = include("../../connection.php"); 
	$select = "SELECT e.Name,e.Ngrad,e.Nmin,e.Nsec,e.Egrad,e.Emin,e.Esec,e.Cog,e.Sog,e.Btm,e.Dtm,e.Fahrtnach,e.Manoever,e.Vorsegel,e.Grosssegel,e.Notes,e.Time,e.Triptitle 
				FROM entryinformation e, tripinformation t
				WHERE e.Triptitle = '$_GET[val]' AND e.Triptitle = t.Title";
				
	$result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	echo "	<table class='table1' id='entry_table' rules='groups' cellspacing='10' cellpadding='10' >
			<thead><tr><th>Name</th><th>NORTH</th><th>EAST</th><th>COG</th><th>SOG</th><th>Zu dem Eintrag</th></tr></thead>
			<tfoot>
			<tr>
				<td><input type='button' onclick='delete_entry();' value='Loeschen'/></td>
				<td><a style='text-decoration:none' href='../entryinformation_php_ajax/entryinformation.php?newval=".$_GET['val']."'><input type='button' value='Neuer Eintrag'/></a></td>
			</tr>
			</tfoot>
			<tbody>	";
	while ($row = mysql_fetch_array($result)) {
		echo "<tr class='row' onclick='Change_Background(this);'>";
		echo "<td>".$row['Name']."</td>";
		echo "<td>".$row['Ngrad']."MIN ".$row['Nmin']."' ".$row['Nsec']."'' </td>";
		echo "<td>".$row['Egrad']."MIN ".$row['Emin']."' ".$row['Esec']."'' </td>";
		echo "<td>COG ".$row['Cog']."</td>";
		echo "<td>SOG ".$row['Sog']."</td>";
		echo "<td style='display:none'>".$row['Triptitle']."</td>";
		echo "<td><a style='text-decoration:none' href='../entryinformation_php_ajax/entryinformation.php?val=".$row['Name']."'>Entry</a></td>";
		echo "</tr>";
	}
	echo "</tbody></table>";
	mysql_close($connection);
?>
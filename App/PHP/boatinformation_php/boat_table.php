<?php
	$select = "SELECT bootsname,registernr,segelzeichen,heimathafen,yachtclub,eigner,versicherung,rufzeichen,typ,konstrukteur,laenge,
    						breite,tiefgang,masthoehe,verdraengung,rigArt,baujahr,motor,tankgroesse,wassertankgroesse,abwassertankgroesse,
    						grosssegelgroesse,genuagroesse,spi FROM boatinformation";
    $result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	
	echo "	<table border='1' rules='groups' cellspacing='10' cellpadding='10' >
			<thead><tr><th>Bootsname</th><th>Inhaber</th><th>Typ</th><th>Konstrukteur</th><th>Laenge</th></tr></thead>
			<tfoot>
			<tr><td colspan = 5><input type='button' onclick='delete_entry();' value='Loeschen'/></td></tr>
			</tfoot>
			<tbody>	";
	while ($row = mysql_fetch_array($result)) {
		echo "<tr class='row' onclick='Change_Background(this);'>";
		echo "<td>".$row['bootsname']."</td>";
		echo "<td style='display:none'>".$row['registernr']."</td>";
		echo "<td style='display:none'>".$row['segelzeichen']."</td>";
		echo "<td style='display:none'>".$row['heimathafen']."</td>";
		echo "<td style='display:none'>".$row['yachtclub']."</td>";
		echo "<td>".$row['eigner']."</td>";
		echo "<td style='display:none'>".$row['versicherung']."</td>";
		echo "<td style='display:none'>".$row['rufzeichen']."</td>";
		echo "<td>".$row['typ']."</td>";
		echo "<td>".$row['konstrukteur']."</td>";
		echo "<td>".$row['laenge']."</td>";
		echo "<td style='display:none'>".$row['breite']."</td>";
		echo "<td style='display:none'>".$row['tiefgang']."</td>";
		echo "<td style='display:none'>".$row['masthoehe']."</td>";
		echo "<td style='display:none'>".$row['verdraengung']."</td>";
		echo "<td style='display:none'>".$row['rigArt']."</td>";
		echo "<td style='display:none'>".$row['baujahr']."</td>";
		echo "<td style='display:none'>".$row['motor']."</td>";
		echo "<td style='display:none'>".$row['tankgroesse']."</td>";
		echo "<td style='display:none'>".$row['wassertankgroesse']."</td>";
		echo "<td style='display:none'>".$row['abwassertankgroesse']."</td>";
		echo "<td style='display:none'>".$row['grosssegelgroesse']."</td>";
		echo "<td style='display:none'>".$row['genuagroesse']."</td>";
		echo "<td style='display:none'>".$row['spi']."</td>";
		echo "<td><a href='../triplist_php/triplist.php?val=".$row['registernr']."'>Trips</a></td>";
		echo "</tr>";
	}
	echo "</tbody></table>";
	
?>

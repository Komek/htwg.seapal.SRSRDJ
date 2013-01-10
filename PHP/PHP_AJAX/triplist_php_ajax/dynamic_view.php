<?php
	$connection = include("../../connection.php");
	echo "<h1>Trips von Boot: $_GET[val]</h1>";
	
	$select = "SELECT title,von,nach,skipper,start,ende,registernr FROM tripinformation WHERE registernr='$_GET[val]'";
    $result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	
	echo "	<table class='table1' rules='groups' cellspacing='10' cellpadding='10' >
			<thead><tr><th>Title</th><th>Von</th><th>Nach</th><th>Skipper</th><th>Start</th><th>Ende</th><th>Zu dem Trip</th></tr></thead>
			<tfoot>
			<tr>
				<td><input type='button' onclick='delete_entry();' value='Trip Loeschen'/></td>
				<td><a style='text-decoration:none' href='../tripinformation_php_ajax/tripinformation.php?newval=$_GET[val]'><input type='button' value='Trip anlegen'/></a></td>
			</tr>
			</tfoot>
			<tbody>	";
	while ($row = mysql_fetch_array($result)) {
		echo "<tr class='row' onclick='set_keys(this);'>";
		echo "<td>".$row['title']."</td>";
		echo "<td>".$row['von']."</td>";
		echo "<td>".$row['nach']."</td>";
		echo "<td>".$row['skipper']."</td>";
		echo "<td>".$row['start']."</td>";
		echo "<td>".$row['ende']."</td>";
		echo "<td style='display:none'>".$row['registernr']."</td>";
		echo "<td><a style='text-decoration:none' href='../tripinformation_php_ajax/tripinformation.php?val=".$row['title']."'>Tripinformation</a></td>";
		echo "</tr>";
	}
	echo "</tbody></table>";
	mysql_close($connection);
?>
<?php
	$select = "SELECT title,von,nach,skipper,crew,start,ende,dauer,motor,notes,registernr FROM tripinformation WHERE title ='$_GET[val]'";
	$result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	$row = mysql_fetch_array($result);
	echo "<script type='text/javascript'>show_trip('$row[title]','$row[von]','$row[nach]','$row[skipper]','$row[crew]','$row[start]','$row[ende]','$row[dauer]','$row[motor]','$row[notes]');set_foreign_key('$row[registernr]');</script>";
?>
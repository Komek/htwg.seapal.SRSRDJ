<?php
	$insert = "INSERT INTO tripinformation (title,von,nach,skipper,crew,start,ende,dauer,motor,notes,registernr) VALUES 
			('$_POST[triptitle]','$_POST[von]','$_POST[nach]','$_POST[skipper]','$_POST[crew]','$_POST[start]','$_POST[ende]','$_POST[dauer]',
			'$_POST[motor]','$_POST[notes]','$_POST[registernr]') ON DUPLICATE KEY UPDATE von = '$_POST[von]', nach = '$_POST[nach]', skipper = '$_POST[skipper]', crew = '$_POST[crew]',
			start = '$_POST[start]', ende = '$_POST[ende]', dauer = '$_POST[dauer]', motor = '$_POST[motor]', notes = '$_POST[notes]'";
	if(!mysql_query($insert)){
			echo "Could not insert: " . mysql_error();
	}
	header("Location: ../triplist_php/triplist.php?val=$_POST[registernr]");
?>
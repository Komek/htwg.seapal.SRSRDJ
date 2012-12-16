<?php
	$delete ="DELETE FROM boatinformation WHERE Registernr = '$_GET[delete]'";
	if(!mysql_query($delete)){
		echo "Could not delete: " . mysql_error();
	}
?>
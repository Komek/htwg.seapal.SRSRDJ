<?php
	$delete="DELETE FROM entryinformation WHERE Name = '$_GET[delete]'";	
	if(!mysql_query($delete)){
			echo "Could not insert: " . mysql_error();
	}
	header("Location: ./tripinformation.php?val=$_GET[fk]");
?>
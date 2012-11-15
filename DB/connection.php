<?php 
	$connection = mysql_connect("localhost","testuser","test");
	if(!$connection){
		echo "Could not connect: " . mysql_error();
	}
	mysql_select_db("seapal");
	return $connection;
?>
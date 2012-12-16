<?php 
	$connection = mysql_connect("localhost","root","");
	if(!$connection){
		echo "Could not connect: " . mysql_error();
	}
	mysql_select_db("seapal");
	return $connection;
?>
<?php
    $connection = include("../../connection.php");
	$delete = "DELETE FROM tripinformation WHERE title = '$_POST[key]'";
	$res = array();
	if(!mysql_query($delete)){
		$res['msg'] = "MySQL ERROR: " . mysql_error();		
	}
	else {
		 $res['msg'] = "Eintrag gelöscht.";
	}
	echo json_encode($res);
	mysql_close($connection);			
?>
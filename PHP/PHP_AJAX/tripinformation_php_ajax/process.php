<?php
	$connection = include("../../connection.php");
	$action = $_POST['action'];
	$res = array();
	
	switch($action){
		case('insert'): 
			$insert = "INSERT INTO tripinformation (title,von,nach,skipper,crew,start,ende,dauer,motor,tankgefuellt,notes,registernr) VALUES 
					('$_POST[triptitle]','$_POST[von]','$_POST[nach]','$_POST[skipper]','$_POST[crew]','$_POST[start]','$_POST[ende]','$_POST[dauer]',
					'$_POST[motor]','$_POST[tankgefuellt]','$_POST[notes]','$_POST[registernr]') ON DUPLICATE KEY UPDATE von = '$_POST[von]', nach = '$_POST[nach]',
					skipper = '$_POST[skipper]', crew = '$_POST[crew]', start = '$_POST[start]', ende = '$_POST[ende]', dauer = '$_POST[dauer]',
					motor = '$_POST[motor]',tankgefuellt = '$_POST[tankgefuellt]', notes = '$_POST[notes]'";
			
			
			if(!mysql_query($insert)){
				$res['msg'] = "MySQL ERROR: " . mysql_error();		
			}
			else {
				 $res['msg'] = "Neuer Eintrag eingefügt.";
			}
			echo json_encode($res);
			mysql_close($connection);
			break;
		
		case('delete'):
			$delete="DELETE FROM entryinformation WHERE Name = '$_POST[key]'";	
			if(!mysql_query($delete)){
				$res['msg'] = "MySQL ERROR: " . mysql_error();		
			}
			else {
				 $res['msg'] = "Eintrag gelöscht.";
			}
			echo json_encode($res);
			mysql_close($connection);
			break;
		 }
?>
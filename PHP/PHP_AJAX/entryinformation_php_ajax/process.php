<?php
	$connection = include("../../connection.php");
	$insert = "INSERT INTO entryinformation (name,ngrad,nmin,nsec,egrad,emin,esec,cog,sog,btm,dtm,fahrtnach,manoever,vorsegel,grosssegel,notes,triptitle) VALUES 
			('$_POST[name]','$_POST[ngrad]','$_POST[nmin]','$_POST[nsec]','$_POST[egrad]','$_POST[emin]','$_POST[esec]','$_POST[cog]',
			'$_POST[sog]','$_POST[btm]','$_POST[dtm]', '$_POST[fahrtnach]','$_POST[manoever]','$_POST[vorsegel]','$_POST[grosssegel]','$_POST[notes]','$_POST[triptitle]')
			ON DUPLICATE KEY UPDATE name = '$_POST[name]', ngrad = '$_POST[ngrad]',
			nmin ='$_POST[nmin]', nsec = '$_POST[nsec]', egrad = '$_POST[egrad]', emin = '$_POST[emin]', esec = '$_POST[esec]', cog = '$_POST[cog]', sog = '$_POST[sog]',
			btm = '$_POST[btm]', dtm = '$_POST[dtm]', fahrtnach = '$_POST[fahrtnach]', manoever = '$_POST[manoever]', vorsegel = '$_POST[vorsegel]', grosssegel = '$_POST[grosssegel]', notes = '$_POST[notes]',triptitle = '$_POST[triptitle]'";
			
	$res = array();
	if(!mysql_query($insert)){
		$res['msg'] = "MySQL ERROR: " . mysql_error();		
	}
	else {
		 $res['msg'] = "Neuer Eintrag eingefügt.";
	}
	echo json_encode($res);
	mysql_close($connection);		 
?>
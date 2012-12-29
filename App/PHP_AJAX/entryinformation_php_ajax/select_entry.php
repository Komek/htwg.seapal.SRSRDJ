<?php
	$connection = include("../../connection.php"); 
	$select = "SELECT name,ngrad,nmin,nsec,egrad,emin,esec,cog,sog,btm,dtm,manoever,vorsegel,grosssegel,notes,triptitle FROM entryinformation WHERE name ='$_GET[val]'";
	$result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	$row = mysql_fetch_array($result);
	echo "<script type='text/javascript'>show_entry('$row[name]','$row[ngrad]','$row[nmin]','$row[nsec]','$row[egrad]','$row[emin]','$row[esec]','$row[cog]',
	'$row[sog]','$row[btm]','$row[dtm]','$row[manoever]','$row[vorsegel]','$row[grosssegel]','$row[notes]','$row[triptitle]');set_foreign_key('$row[triptitle]');</script>";
	mysql_close($connection);
?>
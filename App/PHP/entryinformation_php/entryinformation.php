<!DOCTYPE HTML>
<html>
<head>
	<title>Entry Information</title>
</head>
<body>
	<h1>Entryinformation</h1>
	<?php 
	include("./entryForm.html");
	$connection = include("../../connection.php"); 
	if (isset($_GET['val'])) {
		// neuer entry in DB schreiben
		echo "<script type='text/javascript'>set_foreign_key('$_GET[val]');</script>";
	}
	//entry anzeigen im falle eines submits rückleitung an trip information
	
	mysql_close($connection);
	?>
</body>
</html>
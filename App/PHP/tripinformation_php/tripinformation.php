<!DOCTYPE HTML>
<html>
<head>
	<title>Trip Information</title>
	<script type="text/javascript" src="./tripinformation.js"></script>
</head>
<body>
	<h1>Tripinformation</h1>
<?php 
	include("./tripForm.html");
	$connection = include("../../connection.php"); 
	 
	if (isset($_GET['val'])) {
		//Vorhandenen Trip anzeigen
		include("./select_trip.php");
		include("./entry_table.php");
	}
	elseif (isset($_GET['newval'])) {
		//Neuen Trip anlegen
		echo "<script type='text/javascript'>set_foreign_key('$_GET[newval]');</script>";
	}
	elseif ($_POST['submit']) {
		include ("./insert_trip.php");
	}
	
	mysql_close($connection);
?>
</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
	<title>Trip Information</title>
	<script type="text/javascript" src="./JS/tripinformation.js"></script>
	<script type="text/javascript" src="./JS/jquery-1.8.2.js"></script>
	<link rel="stylesheet" type="text/css" href="./JS/style.css">
	<script type="text/javascript">
	$(function(){
		$('#form').keyup(function (e){
			if (e.keyCode==13){
				var tank;
				if(document.getElementById('tankgefuellt').checked){
					tank = 1;
				}else{
					tank = 0;
				}
				trip = new Array(
					document.getElementById('registernr').value,
					document.getElementById('triptitle').value,
					document.getElementById('von').value,
					document.getElementById('nach').value,
					document.getElementById('skipper').value,
					document.getElementById('crew').value,
					document.getElementById('start').value,
					document.getElementById('ende').value,
					document.getElementById('dauer').value,
					document.getElementById('motor').value,
					tank,
					document.getElementById('notes').value
				);
				trip_send(trip);
			}
		});
	});
	</script>
</head>
<body>
	<h1>Tripinformation</h1>
<?php 
	include("./tripForm.html");

	if (isset($_GET['val'])) {
		include("./select_trip.php");
		echo "<div id='dynamic_view'>";
		include ("./entry_table.php");
		echo "</div>";
	}
	elseif (isset($_GET['newval'])) {
		echo "<script type='text/javascript'>set_foreign_key('$_GET[newval]');</script>";
	}
?>
</body>
</html>
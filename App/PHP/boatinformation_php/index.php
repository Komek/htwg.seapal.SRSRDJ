<!DOCTYPE HTML>
<html>
<head>
	<title>Boat Information</title>
	<script type='text/javascript' src='./dynamic_view.js'></script>
	<script type="text/javascript" src="./boatRegEx.js"></script>
</head>
<body>
	<h1>Boat Information</h1>
	<?php
		if (isset($_POST['submit'])) {
			include("./insert_boat.php");
		}elseif(isset($_GET['delete'])){
			include("./delete_boat.php");		
		}
		include("./boatForm.html");
		include("./dynamic_view.php");
?>
	</body>
</html>
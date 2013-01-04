<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Triplist</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/triplist_ajax.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style_triplist.css">

<body>

	<h1 id="headline"></h1>

	<table class='table1' rules='groups' cellspacing='10' cellpadding='10'>
		<thead>
			<tr>
				<th>Triptitel</th>
				<th>Von</th>
				<th>Nach</th>
				<th>Skipper</th>
				<th>Start</th>
				<th>Ende</th>
				<th>Zu dem Trip</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td><input type='button' id='delete' value='Trip loeschen' /></td>
				<td><input id ="newTrip" type='button' value='Trip anlegen' /></td>
			</tr>
		</tfoot>
		<tbody id="uebersicht">

		</tbody>
	</table>
</body>
</html>

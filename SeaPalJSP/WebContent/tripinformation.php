<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip Information</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tripinfo_ajax.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style_trip.css">

<body>

	<h1>Trip Information</h1>


	<form id="form">
		<fieldset>
			<legend align="center">Logbuch</legend>
			<table>
				<tr>

					<td><label for="title">Trip Title:</label></td>
					<td><input type="text" name="title" id="title"
						tabindex="1" onblur="regEx1(this, document.getElementById('title'))"/></td>

				</tr>
				<tr>
					<td><label for="von">Von:</label></td>
					<td><input type="text" name="von" id="von" tabindex="2" onblur="regEx1(this, document.getElementById('von'))"/></td>
					<td rowspan="3"><label for="crew">Crew:</label></td>
					<td rowspan="3"><textarea name="crew" cols="20" rows="5"
							tabindex="5" id="crew"></textarea></td>
					<td><label for="start">Start:</label></td>
					<td><input type="text" name="start" id="start" tabindex="6" onblur="regEx3(this, document.getElementById('start'))"/></td>
					<td style='display:none'><input type="text" name="registernr" id="registernr"/></td>
				</tr>
				<tr>
					<td><label for="nach">Nach:</label></td>
					<td><input type="text" name="nach" id="nach" tabindex="3" onblur="regEx1(this, document.getElementById('nach'))"/></td>
					<td><label for="ende">Ende:</label></td>
					<td><input type="text" name="ende" id="ende" tabindex="7" onblur="regEx3(this, document.getElementById('ende'))"/></td>
					<td><label for="motor">Motor(min):</label></td>
					<td><input type="text" name="motor" id="motor" tabindex="9" onblur="regEx5(this, document.getElementById('motor'))"/></td>
				</tr>
				<tr>
					<td><label for="skipper">Skipper:</label></td>
					<td><input type="text" name="skipper" id="skipper"
						tabindex="4" onblur="regEx2(this, document.getElementById('skipper'))"/></td>
					<td><label for="dauer">Dauer:</label></td>
					<td><input type="text" name="dauer" id="dauer" tabindex="8" onblur="regEx4(this, document.getElementById('dauer'))"/></td>
					<td><label for="tankgefuellt">Tank gefuellt?</label></td>
					<td><input type="checkbox" name="tankgefuellt"
						id="tankgefuellt" tabindex="10" /></td>
				</tr>
			</table>
		</fieldset>
		<div id='divnotes'>
			<label for="notes">Notes:</label>
			<textarea name="notes" id="notes" cols="30" rows="15"></textarea>
		</div>

		<div id='divscreen'>
			<img src="./images/TestScreenshot.PNG" width="350" height="250" alt="Screenshots">
		</div>
		<div id='divimage'>
			<img src="./images/NoImage.PNG" width="250" height="250" alt="Bild">
		</div>
	</form>

	<table class='table1' id='entry_table' rules='groups' cellspacing='10'
		cellpadding='10'>
		<thead>
			<tr>
				<th>Name</th>
				<th>Zeit</th>
				<th>NORTH</th>
				<th>EAST</th>
				<th>COG</th>
				<th>SOG</th>
				<th> . </th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td><input type='button' id="delete" value='Entry loeschen' /></td>
				<td><input id ="newEntry" type='button' value='Entry anlegen' /></td>
			</tr>
		</tfoot>
		<tbody id="uebersicht">
			
		</tbody>
</body>
</html>

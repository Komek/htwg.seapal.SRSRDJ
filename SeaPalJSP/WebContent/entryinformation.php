<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Entry Information</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/style_entry.css">
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/entry_ajax.js"></script>
<body>
	<h1>Entry Information</h1>
	<form id="form">
		<fieldset>
			<legend align="center">Logbuch</legend>
			<table cellspacing="2" cellpadding="2">
				<input style='display: none' type="text" name="triptitle"
					id="triptitle" />
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" name="name" id="name" style="width: 110px;" onblur="regEx1(this, document.getElementById('name'))"/></td>
				</tr>

				<tr>
					<td><label for="position">Position</label></td>
					<td><input type="text" name="ngrad" id="ngrad" style="width: 110px;" onblur="regEx2(this, document.getElementById('ngrad'))"/>&deg;</td>
					<td><input type="text" name="nmin" id='nmin' style="width: 110px;" onblur="regEx3(this, document.getElementById('nmin'))"/>'</td>
					<td><input type="text" name="nsec" id='nsec' style="width: 110px;" onblur="regEx3(this, document.getElementById('nsec'))"/>"N</td>
					<td><input type="text" name="egrad" id='egrad' style="width: 110px;" onblur="regEx2(this, document.getElementById('egrad'))"/>&deg;</td>
					<td><input type="text" name="emin" id='emin' style="width: 110px;" onblur="regEx3(this, document.getElementById('emin'))"/>'</td>
					<td><input type="text" name="esec" id='esec' style="width: 110px;" onblur="regEx3(this, document.getElementById('esec'))"/>"E</td>
				</tr>
				<tr>
					<td><label for="cog">COG</label></td>
					<td><input type="text" name="cog" id="cog" style="width: 110px;" onblur="regEx4(this, document.getElementById('cog'))"/></td>
					<td><label for="sog">SOG</label></td>
					<td><input type="text" name="sog" id="sog" style="width: 110px;" onblur="regEx5(this, document.getElementById('sog'))"/></td>
					<td>at <span id='time'></span>
					</td>
				</tr>
				<tr>
					<td><label for="btm">BTM</label></td>
					<td><input type="text" name="btm" id="btm" value="0000" style="width: 110px;" onblur="regEx6(this, document.getElementById('btm'))" /></td>
					<td><label for="dtm">DTM</label></td>
					<td><input type="text" name="dtm" id="dtm" value="0.0000" style="width: 110px;" onblur="regEx7(this, document.getElementById('dtm'))"/></td>
					<td><label for="fahrtnach">Fahrt nach</label></td>
					<td><select name="fahrtnach" id="fahrtnach">
							<option value="0" selected="selected">Mark 1</option>
							<option value="1">Mark 2</option>
							<option value="2">Mark 3</option>
					</select>
					</td>
				</tr>

				<tr>
					<td><label for="manoever">Manoever</label></td>
					<td><select name="manoever" id="manoever">
							<option value="0" selected="selected">-</option>
							<option value="1">Track</option>
							<option value="2">Jibe</option>
							<option value="3">Lay to</option>
							<option value="4">Set Sails</option>
							<option value="5">Change Sails</option>
							<option value="6">Sails down</option>
							<option value="7">Reff</option>
							<option value="8">Anker up</option>
							<option value="9">Anker down</option>
					</select>
					</td>
					<td><label for="vorsegel">Vorsegel</label></td>
					<td><select name="vorsegel" id="vorsegel">
							<option value="0" selected="selected">-</option>
							<option value="1">Genua1</option>
							<option value="2">Genua2</option>
							<option value="3">Genua3</option>
							<option value="4">Fock</option>
							<option value="5 Fock">Storm Fock</option>
							<option value="6">Blister</option>
							<option value="7">Spinaker</option>
					</select>
					</td>
					<td><label for="grosssegel">Grosssegel</label></td>
					<td><select name="grosssegel" id="grosssegel">
							<option value="0" selected="selected">-</option>
							<option value="1">full</option>
							<option value="2">reef 1</option>
							<option value="3">reef 2</option>
					</select>
					</td>
				</tr>
			</table>
			<div id='divnotes'>
				<label for="notes">Notes:</label>
				<textarea name="notes" cols="30" rows="15" id='notes'></textarea>
			</div>
			<div id='divscreen'>
				<img src="./images/TestScreenshot.PNG" alt="Screenshots" width="350" height="250">
			</div>
			<div id='divimage'>
				<img src="./images/NoImage.PNG" alt="Bild width="250" height="250">
			</div>
		</fieldset>
	</form>
</body>
</html>

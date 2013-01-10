

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BootInfo</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/boatinfo_ajax.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style_boat.css">

<body>

<h1>Boot Information</h1>
	<form id="form">
		<fieldset>
			<legend align="center">Logbuch</legend>
			<table cellspacing="5" cellpadding="5">
				<tr>
					<td><label for="bootsname">Bootsname:</label></td>
					<td><input type="text" name="bootsname" id="bootsname"
						tabindex="1"
						onblur="regEx1(this, document.getElementById('bootsname'))" />
						</td>


					<td><label for="typ">Typ:</label></td>
					<td><input type="text" name="typ" id="typ" tabindex="9"
						onblur="regEx6(this, document.getElementById('typ'))" />
						</td>

					<td><label for="baujahr">Baujahr:</label></td>
					<td><input type="text" name="baujahr" id="baujahr"
						tabindex="17"
						onblur="regEx9(this, document.getElementById('baujahr'))" />
						</td>
				</tr>
				<tr>
					<td><label for="registernr">Registernr:</label></td>
					<td><input type="text" name="registernr" id="registernr"
						tabindex="2"
						onblur="regEx2(this, document.getElementById('registernr'))" />
						</td>

					<td><label for="konstrukteur">Konstrukteur:</label></td>
					<td><input type="text" name="konstrukteur" id="konstrukteur"
						tabindex="10"
						onblur="regEx1(this, document.getElementById('konstrukteur'))" />
						</td>

					<td><label for="motor">Motor:</label></td>
					<td><input type="text" name="motor" id="motor" tabindex="18"
						onblur="regEx5(this, document.getElementById('motor'))" />
						</td>
				</tr>
				<tr>
					<td><label for="segelzeichen">Segelzeichen:</label></td>
					<td><input type="text" name="segelzeichen" id="segelzeichen"
						tabindex="3"
						onblur="regEx1(this, document.getElementById('segelzeichen'))" />
						</td>

					<td><label for="laenge">Laenge:</label></td>
					<td><input type="text" name="laenge" id="laenge" tabindex="11"
						onblur="regEx7(this, document.getElementById('laenge'))" />
						</td>

					<td><label for="tankgroesse">Tankgroesse:</label></td>
					<td><input type="text" name="tankgroesse" id="tankgroesse"
						tabindex="19"
						onblur="regEx8(this, document.getElementById('tankgroesse'))" />
						</td>
				</tr>
				<tr>
					<td><label for="heimathafen">Heimathafen:</label></td>
					<td><input type="text" name="heimathafen" id="heimathafen"
						tabindex="4"
						onblur="regEx4(this, document.getElementById('heimathafen'))" />
						</td>

					<td><label for="breite">Breite:</label></td>
					<td><input type="text" name="breite" id="breite" tabindex="12"
						onblur="regEx7(this, document.getElementById('breite'))" />
						</td>

					<td><label for="wassertankgroesse">Wassertankgroesse:</label></td>
					<td><input type="text" name="wassertankgroesse"
						id="wassertankgroesse" tabindex="20"
						onblur="regEx7(this, document.getElementById('wassertankgroesse'))" />
						</td>
				</tr>
				<tr>
					<td><label for="yachtclub">Yachtclub:</label></td>
					<td><input type="text" name="yachtclub" id="yachtclub"
						tabindex="5"
						onblur="regEx5(this, document.getElementById('yachtclub'))" />
						</td>

					<td><label for="tiefgang">Tiefgang:</label></td>
					<td><input type="text" name="tiefgang" id="tiefgang"
						tabindex="13"
						onblur="regEx7(this, document.getElementById('tiefgang'))" />
						</td>

					<td><label for="abwassertankgroesse">Abwassertankgroesse:</label></td>
					<td><input type="text" name="abwassertankgroesse"
						id="abwassertankgroesse" tabindex="21"
						onblur="regEx7(this, document.getElementById('abwassertankgroesse'))" />
						</td>
				</tr>
				<tr>
					<td><label for="eigner">Eigener:</label></td>
					<td><input type="text" name="eigner" id="eigner" tabindex="6"
						onblur="regEx6(this, document.getElementById('eigner'))" />
						</td>

					<td><label for="masthoehe">Masthoehe:</label></td>
					<td><input type="text" name="masthoehe" id="masthoehe"
						tabindex="14"
						onblur="regEx7(this, document.getElementById('masthoehe'))" />
						</td>

					<td><label for="grosssegelgroesse">Grosssegelgroesse:</label></td>
					<td><input type="text" name="grosssegelgroesse"
						id="grosssegelgroesse" tabindex="22"
						onblur="regEx7(this, document.getElementById('grosssegelgroesse'))" />
						</td>
				</tr>
				<tr>
					<td><label for="versicherung">Versicherung:</label></td>
					<td><input type="text" name="versicherung" id="versicherung"
						tabindex="7"
						onblur="regEx4(this, document.getElementById('versicherung'))" />
						</td>

					<td><label for="verdraengung">Verdraengung:</label></td>
					<td><input type="text" name="verdraengung" id="verdraengung"
						tabindex="15"
						onblur="regEx7(this, document.getElementById('verdraengung'))" />
						</td>

					<td><label for="genuagroesse">Genuagroesse:</label></td>
					<td><input type="text" name="genuagroesse" id="genuagroesse"
						tabindex="23"
						onblur="regEx7(this, document.getElementById('genuagroesse'))" />
						</td>
				</tr>
				<tr>
					<td><label for="rufzeichen">Rufzeichen:</label></td>
					<td><input type="text" name="rufzeichen" id="rufzeichen"
						tabindex="8"
						onblur="regEx2(this, document.getElementById('rufzeichen'))" />
						</td>

					<td><label for="rigArt">Rig-Art:</label></td>
					<td><input type="text" name="rigArt" id="rigArt" tabindex="16"
						onblur="regEx2(this, document.getElementById('rigArt'))" />
						</td>

					<td><label for="spi">Spi size Spigroesse:</label></td>
					<td><input type="text" name="spi" id="spi" tabindex="24"
						onblur="regEx7(this, document.getElementById('spi'))" />
						</td>
				</tr>
			</table>
		</fieldset>
	</form>

	<table class='table1' rules='groups' cellspacing='10' cellpadding='10'>
		<thead>
			<tr>
				<th>Bootsname</th>
				<th>Inhaber</th>
				<th>Typ</th>
				<th>Konstrukteur</th>
				<th>Laenge</th>
				<th>Zu den Trips</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td><input type="button" value="Ausgewählten Eintrag löschen" id="delete" /></td>
			</tr>
		</tfoot>
		<tbody id="uebersicht">
			
		</tbody>
	</table>
</body>
</html>
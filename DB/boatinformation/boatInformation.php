<!DOCTYPE HTML>
<html>
<head>
	<title>Boat Information</title>
	<link rel="stylesheet" type="text/css" href="./boatInformationStyle.css">
</head>
<body>
	<h1>Boat Information</h1>
	<?
	include("../connection.php");
	
	$insert = "INSERT INTO boatinformation (Registernr,Bootsname,Segelzeichen,Heimathafen,
				Yachtclub,Eigener,Versicherung,Rufzeichen,Typ,Konstrukteur,Laenge,Breite,
				Tiefgang,Masthoehe,Verdraengung,FligArt,Baujahr,Motor,Tankgroesse,Wassertankgroesse,
				Abwassertankgroesse,Grosssegelgroesse,Genuagroesse,SpiSizeSpiegroesse) VALUES 
				('$_POST[registernr]','$_POST[bootsname]','$_POST[segelzeichen]','$_POST[heimathafen]','$_POST[yachtclub]',
				'$_POST[eigener]','$_POST[versicherung]','$_POST[rufzeichen]','$_POST[typ]','$_POST[konstrukteur]',
				'$_POST[laenge]','$_POST[breite]','$_POST[tiefgang]','$_POST[masthoehe]','$_POST[verdraengung]','$_POST[fligArt]',
				'$_POST[baujahr]','$_POST[motor]','$_POST[tankgroesse]','$_POST[wassertankgroesse]','$_POST[abwassertankgroesse]',
				'$_POST[grosssegelgroesse]','$_POST[genuagroesse]','$_POST[spi]')";
	
	
	if(!mysql_query($insert,$connection)){
		echo "Could not insert: " . mysql_error();
	}
	mysql_close($connection);
	
	
	 ?>
	<!-----------------------Boat Information------------------------------------>
	<form action="boatinformation.php" method="post">
	<fieldset><legend align="center">Logbuch</legend>  
	<table cellspacing="10" cellpadding="10">
		<tr><td><label for="bootsname">Bootsname:</label></td>
			<td><input type="text" name="bootsname" id="bootsname" tabindex="1" /></td>
			<td><label for="typ">Typ:</label></td>
			<td><input type="text" name="typ" id="typ" tabindex="9"/></td>
			<td><label for="baujahr">Baujahr:</label></td>
			<td><input type="text" name="baujahr" id="baujahr" tabindex="17"/></td>
			</tr>
		<tr>
			<td><label for="registernr">Registernr:</label></td>
			<td><input type="text" name="registernr" id="registernr" tabindex="2"/></td>
			<td><label for="konstrukteur">Konstrukteur:</label></td>
			<td><input type="text" name="konstrukteur" id="konstrukteur" tabindex="10"/></td>
			<td><label for="motor">Motor:</label></td>
			<td><input type="text" name="motor" id="motor" tabindex="18"/></td>
			
		</tr>
		<tr>
			<td><label for="segelzeichen">Segelzeichen:</label></td>
			<td><input type="text" name="segelzeichen" id="segelzeichen" tabindex="3"/></td>
			<td><label for="laenge">Laenge:</label></td>
			<td><input type="text" name="laenge" id="laenge" tabindex="11"/></td>
			<td><label for="tankgroesse">Tankgroesse:</label></td>
			<td><input type="text" name="tankgroesse" id="tankgroesse" tabindex="19"/></td>
		
		</tr>
		<tr>
			<td><label for="heimathafen">Heimathafen:</label></td>
			<td><input type="text" name="heimathafen" id="heimathafen" tabindex="4"/></td>
			<td><label for="breite">Breite:</label></td>
			<td><input type="text" name="breite" id="breite" tabindex="12"/></td>
			<td><label for="wassertankgroesse">Wassertankgroesse:</label></td>
			<td><input type="text" name="wassertankgroesse" id="wassertankgroesse" tabindex="20"/></td>
		</tr>
		<tr>
			<td><label for="yachtclub">Yachtclub:</label></td>
			<td><input type="text" name="yachtclub" id="yachtclub" tabindex="5" /></td>
			<td><label for="tiefgang">Tiefgang:</label></td>
			<td><input type="text" name="tiefgang" id="tiefgang" tabindex="13"/></td>
			<td><label for="abwassertankgroesse">Abwassertankgroesse:</label></td>
			<td><input type="text" name="abwassertankgroesse" id="abwassertankgroesse" tabindex="21" /></td>
		</tr>
		<tr>
			<td><label for="eigener">Eigener:</label></td>
			<td><input type="text" name="eigener" id="eigener" tabindex="6"/></td>
			<td><label for="masthoehe">Masthoehe:</label></td>
			<td><input type="text" name="masthoehe" id="masthoehe" tabindex="14"/></td>
			<td><label for="grosssegelgroesse">Grosssegelgroesse:</label></td>
			<td><input type="text" name="grosssegelgroesse" id="grosssegelgroesse" tabindex="22"/></td>
		</tr>
		<tr>
			<td><label for="versicherung">Versicherung:</label></td>
			<td><input type="text" name="versicherung" id="versicherung" tabindex="7" /></td>
			<td><label for="verdraengung">Verdraengung:</label></td>
			<td><input type="text" name="verdraengung" id="verdraengung" tabindex="15"/></td>
			<td><label for="genuagroesse">Genuagroesse:</label></td>
			<td><input type="text" name="genuagroesse" id="genuagroesse" tabindex="23"/></td>
		</tr>
		<tr>
			<td><label for="rufzeichen">Rufzeichen:</label></td>
			<td><input type="text" name="rufzeichen" id="rufzeichen" tabindex="8" /></td>
			<td><label for="fligArt">Flig-Art:</label></td>
			<td><input type="text" name="fligArt" id="fligArt" tabindex="16"/></td>
			<td><label for="spi">Spi size Spigroesse:</label></td>
			<td><input type="text" name="spi" id="spi" tabindex="24"/></td>
		</tr>	
	</table>
		
		<input type="submit" name="submit" value="Eintragen" />
		<input type="reset" name="reset" value="Zuruecksetzen" />
		
	</fieldset>
	</form>
	<!-----------------------Boat Summary------------------------------------>
	<?php 
	include("dynamic_view.php");
	?>
	</body>
</html>
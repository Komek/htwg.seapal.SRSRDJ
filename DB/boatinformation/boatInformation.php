<!DOCTYPE HTML>
<html>
<head>
	<title>Boat Information</title>
	<link rel="stylesheet" type="text/css" href="./boatInformationStyle.css">
	<script type="text/javascript">
		function CheckPattern_Text(inputField,helpId){
		
		}
		function CheckPattern_Decimal(inputField,helpId){
		
		}
		function CheckPattern_Integer(inputField,helpId){
		
		}
		function CheckPattern_Rufzeichen(inputField,helpId){
		
		}
		function CheckPattern_Typ(inputField,helpId){
		
		}
		function CheckPattern_Motor(inputField,helpId){
		
		}
		function CheckPattern_Registernr(inputField,helpId){
		
		}
		function CheckPattern_Segelzeichen(inputField,helpId){
		
		}
		function CheckPattern(regex, input, helpId, helpMessage){
			if (!regex.test(input)){
				if (helpId != null)
					while (helpId.firstChild)
						helpId.removeChild(helpId.firstChild);
		
					helpId.appendChild(document.createTextNode(helpMessage)); 
					return false;
				}else {        
					if (helpId != null){
						while (helpId.firstChild) 
							helpId.removeChild(helpId.firstChild);
					}
				return true;
			}      
		}
		
	</script>
</head>
<body>
	<h1>Boat Information</h1>
	<?php
		if (isset($_POST['submit'])) {
			$connection = include("../connection.php");
			$insert = "INSERT INTO boatinformation (Registernr,Bootsname,Segelzeichen,Heimathafen,
					 Yachtclub,Eigener,Versicherung,Rufzeichen,Typ,Konstrukteur,Laenge,Breite,
					 Tiefgang,Masthoehe,Verdraengung,FligArt,Baujahr,Motor,Tankgroesse,Wassertankgroesse,
					 Abwassertankgroesse,Grosssegelgroesse,Genuagroesse,SpiSizeSpiegroesse) VALUES 
					 ('$_POST[registernr]','$_POST[bootsname]','$_POST[segelzeichen]','$_POST[heimathafen]','$_POST[yachtclub]',
					 '$_POST[eigener]','$_POST[versicherung]','$_POST[rufzeichen]','$_POST[typ]','$_POST[konstrukteur]',
					 '$_POST[laenge]','$_POST[breite]','$_POST[tiefgang]','$_POST[masthoehe]','$_POST[verdraengung]','$_POST[fligArt]',
					 '$_POST[baujahr]','$_POST[motor]','$_POST[tankgroesse]','$_POST[wassertankgroesse]','$_POST[abwassertankgroesse]',
					 '$_POST[grosssegelgroesse]','$_POST[genuagroesse]','$_POST[spi]') ON DUPLICATE KEY UPDATE 
					 Bootsname = '$_POST[bootsname]',Segelzeichen = '$_POST[segelzeichen]',Heimathafen = '$_POST[heimathafen]',
					 Yachtclub = '$_POST[yachtclub]',Eigener = '$_POST[eigener]',Versicherung = '$_POST[versicherung]',
					 Rufzeichen = '$_POST[rufzeichen]',Typ = '$_POST[typ]',Konstrukteur = '$_POST[konstrukteur]',
					 Laenge = '$_POST[laenge]',Breite = '$_POST[breite]',Tiefgang = '$_POST[tiefgang]',Masthoehe = '$_POST[masthoehe]',
					 Verdraengung = '$_POST[verdraengung]',FligArt = '$_POST[fligArt]',Baujahr = '$_POST[baujahr]',Motor = '$_POST[motor]',
					 Tankgroesse = '$_POST[tankgroesse]',Wassertankgroesse = '$_POST[wassertankgroesse]',
					 Abwassertankgroesse = '$_POST[abwassertankgroesse]',Grosssegelgroesse = '$_POST[grosssegelgroesse]',
					 Genuagroesse = '$_POST[genuagroesse]',SpiSizeSpiegroesse = '$_POST[spi]'";
			if(!mysql_query($insert,$connection)){
				echo "Could not insert: " . mysql_error();
			}
			
			mysql_close($connection);
		}
?>
	<!-----------------------Boat Information------------------------------------>
	<form action="boatinformation.php" method="post">
	<fieldset><legend align="center">Logbuch</legend>  
	<table cellspacing="10" cellpadding="10">
		<tr><td><label for="bootsname">Bootsname:</label></td>
			<td><input type="text" name="bootsname" id="bootsname" tabindex="1" onblur="CheckPattern_Text(this, document.getElementById('bootsname_help'))" /></td>
			<span id="bootsname_help"></span>
			
			<td><label for="typ">Typ:</label></td>
			<td><input type="text" name="typ" id="typ" tabindex="9" onblur="CheckPattern_Typ(this, document.getElementById('typ_help'))" /></td>
			<span id="typ_help"></span>	
			
			<td><label for="baujahr">Baujahr:</label></td>
			<td><input type="text" name="baujahr" id="baujahr" tabindex="17" onblur="CheckPattern_Integer(this, document.getElementById('baujahr_help'))" /></td>
			<span id="baujahr_help"></span>
		</tr>
		<tr>
			<td><label for="registernr">Registernr:</label></td>
			<td><input type="text" name="registernr" id="registernr" tabindex="2" onblur="CheckPattern_Registernr(this, document.getElementById('registernr_help'))" /></td>
			<span id="registernr_help"></span>
			
			<td><label for="konstrukteur">Konstrukteur:</label></td>
			<td><input type="text" name="konstrukteur" id="konstrukteur" tabindex="10" onblur="CheckPattern_Text(this, document.getElementById('konstrukteur_help'))" /></td>
			<span id="konstrukteur_help"></span>
			
			<td><label for="motor">Motor:</label></td>
			<td><input type="text" name="motor" id="motor" tabindex="18" onblur="CheckPattern_Motor(this, document.getElementById('motor_help'))" /></td>
			<span id="motor_help"></span>
		</tr>
		<tr>
			<td><label for="segelzeichen">Segelzeichen:</label></td>
			<td><input type="text" name="segelzeichen" id="segelzeichen" tabindex="3" onblur="CheckPattern_Segelzeichen(this, document.getElementById('segelzeichen_help'))" /></td>
			<span id="segelzeichen_help"></span>
			
			<td><label for="laenge">Laenge:</label></td>
			<td><input type="text" name="laenge" id="laenge" tabindex="11" onblur="CheckPattern_Decimal(this, document.getElementById('laenge_help'))" /></td>
			<span id="laenge_help"></span>
			
			<td><label for="tankgroesse">Tankgroesse:</label></td>
			<td><input type="text" name="tankgroesse" id="tankgroesse" tabindex="19" onblur="CheckPattern_Decimal(this, document.getElementById('tankgroesse_help'))" /></td>
			<span id="tankgroesse_help"></span>
		</tr>
		<tr>
			<td><label for="heimathafen">Heimathafen:</label></td>
			<td><input type="text" name="heimathafen" id="heimathafen" tabindex="4" onblur="CheckPattern_Text(this, document.getElementById('heimathafen_help'))" /></td>
			<span id="heimathafen_help"></span>
			
			<td><label for="breite">Breite:</label></td>
			<td><input type="text" name="breite" id="breite" tabindex="12" onblur="CheckPattern_Decimal(this, document.getElementById('breite_help'))" /></td>
			<span id="breite_help"></span>
			
			<td><label for="wassertankgroesse">Wassertankgroesse:</label></td>
			<td><input type="text" name="wassertankgroesse" id="wassertankgroesse" tabindex="20" onblur="CheckPattern_Decimal(this, document.getElementById('wassertankgroesse_help'))" /></td>
			<span id="wassertankgroesse_help"></span>
		</tr>
		<tr>
			<td><label for="yachtclub">Yachtclub:</label></td>
			<td><input type="text" name="yachtclub" id="yachtclub" tabindex="5" onblur="CheckPattern_Text(this, document.getElementById('yachtclub_help'))" /></td>
			<span id="yachtclub_help"></span>
			
			<td><label for="tiefgang">Tiefgang:</label></td>
			<td><input type="text" name="tiefgang" id="tiefgang" tabindex="13" onblur="CheckPattern_Decimal(this, document.getElementById('tiefgang_help'))" /></td>
			<span id="tiefgang_help"></span>
			
			<td><label for="abwassertankgroesse">Abwassertankgroesse:</label></td>
			<td><input type="text" name="abwassertankgroesse" id="abwassertankgroesse" tabindex="21" onblur="CheckPattern_Decimal(this, document.getElementById('abwassertankgroesse_help'))" /></td>
			<span id="abwassertankgroesse_help"></span>
		</tr>
		<tr>
			<td><label for="eigener">Eigener:</label></td>
			<td><input type="text" name="eigener" id="eigener" tabindex="6" onblur="CheckPattern_Text(this, document.getElementById('eigener_help'))" /></td>
			<span id="eigener_help"></span>
			
			<td><label for="masthoehe">Masthoehe:</label></td>
			<td><input type="text" name="masthoehe" id="masthoehe" tabindex="14" onblur="CheckPattern_Decimal(this, document.getElementById('masthoehe_help'))" /></td>
			<span id="masthoehe_help"></span>
			
			<td><label for="grosssegelgroesse">Grosssegelgroesse:</label></td>
			<td><input type="text" name="grosssegelgroesse" id="grosssegelgroesse" tabindex="22" onblur="CheckPattern_Decimal(this, document.getElementById('grosssegelgroesse_help'))" /></td>
			<span id="grosssegelgroesse_help"></span>
		</tr>
		<tr>
			<td><label for="versicherung">Versicherung:</label></td>
			<td><input type="text" name="versicherung" id="versicherung" tabindex="7" onblur="CheckPattern_Text(this, document.getElementById('versicherung_help'))" /></td>
			<span id="versicherung_help"></span>
			
			<td><label for="verdraengung">Verdraengung:</label></td>
			<td><input type="text" name="verdraengung" id="verdraengung" tabindex="15" onblur="CheckPattern_Decimal(this, document.getElementById('verdraengung_help'))" /></td>
			<span id="verdraengung_help"></span>
			
			<td><label for="genuagroesse">Genuagroesse:</label></td>
			<td><input type="text" name="genuagroesse" id="genuagroesse" tabindex="23" onblur="CheckPattern_Decimal(this, document.getElementById('genuagroesse_help'))" /></td>
			<span id="genuagroesse_help"></span>
		</tr>
		<tr>
			<td><label for="rufzeichen">Rufzeichen:</label></td>
			<td><input type="text" name="rufzeichen" id="rufzeichen" tabindex="8" onblur="CheckPattern_Rufzeichen(this, document.getElementById('rufzeichen_help'))" /></td>
			<span id="rufzeichen_help"></span>
			
			<td><label for="fligArt">Flig-Art:</label></td>
			<td><input type="text" name="fligArt" id="fligArt" tabindex="16" onblur="CheckPattern_Text(this, document.getElementById('fligart_help'))" /></td>
			<span id="fligart_help"></span>
			
			<td><label for="spi">Spi size Spigroesse:</label></td>
			<td><input type="text" name="spi" id="spi" tabindex="24" onblur="CheckPattern_Decimal(this, document.getElementById('spi_help'))" /></td>
			<span id="spi_help"></span>
		</tr>	
	</table>
		
		<input type="submit" name="submit" value="Eintragen" />
		<input type="reset" name="reset" value="Zuruecksetzen" />
		
	</fieldset>
	</form>
	<!-----------------------Boat Summary------------------------------------>
	<?php 
		$connection = include("../connection.php");
		include("../dynamic_view.php");
		mysql_close($connection);
	?>
	</body>
</html>
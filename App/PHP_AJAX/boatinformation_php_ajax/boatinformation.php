<?php	include("./dynamic_view.php"); ?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>BoatInfo</title>
		<script type='text/javascript' src='./JS/dynamic_view.js'></script>
		<script type="text/javascript" src="./JS/jquery-1.8.2.js"></script>
		<script type="text/javascript">
			$(function(){
			$('#form').keyup(function (e){
				if (e.keyCode==13){
					var boat_values = new Array(
						document.getElementById('registernr').value,
						document.getElementById('bootsname').value,
						document.getElementById('segelzeichen').value,
						document.getElementById('heimathafen').value,
						document.getElementById('yachtclub').value,
						document.getElementById('eigener').value,
						document.getElementById('versicherung').value,
						document.getElementById('rufzeichen').value,
						document.getElementById('typ').value,
						document.getElementById('konstrukteur').value,
						document.getElementById('laenge').value,
						document.getElementById('breite').value,
						document.getElementById('tiefgang').value,
						document.getElementById('masthoehe').value,
						document.getElementById('verdraengung').value,
						document.getElementById('fligArt').value,
						document.getElementById('baujahr').value,
						document.getElementById('motor').value,
						document.getElementById('tankgroesse').value,
						document.getElementById('wassertankgroesse').value,
						document.getElementById('abwassertankgroesse').value,
						document.getElementById('grosssegelgroesse').value,
						document.getElementById('genuagroesse').value,
						document.getElementById('spi').value	
					);
					sendBoat(boat_values);
								
					}
				});
			});
			
			function sendBoat(boat_values){
				$.ajax({
					type: 'POST',
					url: 'process.php',
					data: {
						'action' : 'insert',
						'registernr' : boat_values[0],
						'bootsname' : boat_values[1],
						'segelzeichen' :  boat_values[2],
						'heimathafen' :  boat_values[3],
						'yachtclub' :  boat_values[4],
						'eigener' :  boat_values[5],
						'versicherung' :  boat_values[6],
						'rufzeichen' :  boat_values[7],
						'typ' :  boat_values[8],
						'konstrukteur' :  boat_values[9],
						'laenge' :  boat_values[10],
						'breite' :  boat_values[11],
						'tiefgang' :  boat_values[12],
						'masthoehe' :  boat_values[13],
						'verdraengung' :  boat_values[14],
						'fligArt' :  boat_values[15],
						'baujahr' :  boat_values[16],
						'motor' :  boat_values[17],
						'tankgroesse' :  boat_values[18],
						'wassertankgroesse' :  boat_values[19],
						'abwassertankgroesse' :  boat_values[20],
						'grosssegelgroesse' :  boat_values[21],
						'genuagroesse' :  boat_values[22],
						'spi' :  boat_values[23]						
					},
					dataType : 'json',
					success : update(),	
				});
			}
			function update(){
				reset_form();
				
				$.ajax({
					url : './dynamic_view.php',
					type : 'POST',
					success : function(result){
						alert(result);
						$('#dynamic_view').html(result);
					}
				});
						
			}
			
			function reset_form(){
				document.getElementById('registernr').value="";
						document.getElementById('bootsname').value="";
						document.getElementById('segelzeichen').value="";
						document.getElementById('heimathafen').value="";
						document.getElementById('yachtclub').value="";
						document.getElementById('eigener').value="";
						document.getElementById('versicherung').value="";
						document.getElementById('rufzeichen').value="";
						document.getElementById('typ').value="";
						document.getElementById('konstrukteur').value="";
						document.getElementById('laenge').value="";
						document.getElementById('breite').value="";
						document.getElementById('tiefgang').value="";
						document.getElementById('masthoehe').value="";
						document.getElementById('verdraengung').value="";
						document.getElementById('fligArt').value="";
						document.getElementById('baujahr').value="";
						document.getElementById('motor').value="";
						document.getElementById('tankgroesse').value="";
						document.getElementById('wassertankgroesse').value="";
						document.getElementById('abwassertankgroesse').value="";
						document.getElementById('grosssegelgroesse').value="";
						document.getElementById('genuagroesse').value="";
						document.getElementById('spi').value="";
			}	
		</script>
	</head>

	<body>
	
		<h1>Boat Information</h1>
		
	<form id="form">
	<fieldset ><legend align="center">Logbuch</legend>  
	<table cellspacing="10" cellpadding="10">
		<tr><td><label for="bootsname">Bootsname:</label></td>
			<td><input type="text" name="bootsname" id="bootsname" tabindex="1" onblur="CheckPattern_Text(this, document.getElementById('bootsname_help'))" />
			<span id="bootsname_help"></span></td>
			
			
			<td><label for="typ">Typ:</label></td>
			<td><input type="text" name="typ" id="typ" tabindex="9" onblur="CheckPattern_Typ(this, document.getElementById('typ_help'))" />
			<span id="typ_help"></span></td>
			
			<td><label for="baujahr">Baujahr:</label></td>
			<td><input type="text" name="baujahr" id="baujahr" tabindex="17" onblur="CheckPattern_Integer(this, document.getElementById('baujahr_help'))" />
			<span id="baujahr_help"></span></td>
		</tr>
		<tr>
			<td><label for="registernr">Registernr:</label></td>
			<td><input type="text" name="registernr" id="registernr" tabindex="2" onblur="CheckPattern_Registernr(this, document.getElementById('registernr_help'))" />
			<span id="registernr_help"></span></td>
			
			<td><label for="konstrukteur">Konstrukteur:</label></td>
			<td><input type="text" name="konstrukteur" id="konstrukteur" tabindex="10" onblur="CheckPattern_Text(this, document.getElementById('konstrukteur_help'))" />
			<span id="konstrukteur_help"></span></td>
			
			<td><label for="motor">Motor:</label></td>
			<td><input type="text" name="motor" id="motor" tabindex="18" onblur="CheckPattern_Motor(this, document.getElementById('motor_help'))" />
			<span id="motor_help"></span></td>
		</tr>
		<tr>
			<td><label for="segelzeichen">Segelzeichen:</label></td>
			<td><input type="text" name="segelzeichen" id="segelzeichen" tabindex="3" onblur="CheckPattern_Segelzeichen(this, document.getElementById('segelzeichen_help'))" />
			<span id="segelzeichen_help"></span></td>
			
			<td><label for="laenge">Laenge:</label></td>
			<td><input type="text" name="laenge" id="laenge" tabindex="11" onblur="CheckPattern_Decimal(this, document.getElementById('laenge_help'))" />
			<span id="laenge_help"></span></td>
			
			<td><label for="tankgroesse">Tankgroesse:</label></td>
			<td><input type="text" name="tankgroesse" id="tankgroesse" tabindex="19" onblur="CheckPattern_Decimal(this, document.getElementById('tankgroesse_help'))" />
			<span id="tankgroesse_help"></span></td>
		</tr>
		<tr>
			<td><label for="heimathafen">Heimathafen:</label></td>
			<td><input type="text" name="heimathafen" id="heimathafen" tabindex="4" onblur="CheckPattern_Text(this, document.getElementById('heimathafen_help'))" />
			<span id="heimathafen_help"></span></td>
			
			<td><label for="breite">Breite:</label></td>
			<td><input type="text" name="breite" id="breite" tabindex="12" onblur="CheckPattern_Decimal(this, document.getElementById('breite_help'))" />
			<span id="breite_help"></span></td>
			
			<td><label for="wassertankgroesse">Wassertankgroesse:</label></td>
			<td><input type="text" name="wassertankgroesse" id="wassertankgroesse" tabindex="20" onblur="CheckPattern_Decimal(this, document.getElementById('wassertankgroesse_help'))" />
			<span id="wassertankgroesse_help"></span></td>
		</tr>
		<tr>
			<td><label for="yachtclub">Yachtclub:</label></td>
			<td><input type="text" name="yachtclub" id="yachtclub" tabindex="5" onblur="CheckPattern_Text(this, document.getElementById('yachtclub_help'))" />
			<span id="yachtclub_help"></span></td>
			
			<td><label for="tiefgang">Tiefgang:</label></td>
			<td><input type="text" name="tiefgang" id="tiefgang" tabindex="13" onblur="CheckPattern_Decimal(this, document.getElementById('tiefgang_help'))" />
			<span id="tiefgang_help"></span></td>
			
			<td><label for="abwassertankgroesse">Abwassertankgroesse:</label></td>
			<td><input type="text" name="abwassertankgroesse" id="abwassertankgroesse" tabindex="21" onblur="CheckPattern_Decimal(this, document.getElementById('abwassertankgroesse_help'))" />
			<span id="abwassertankgroesse_help"></span></td>
		</tr>
		<tr>
			<td><label for="eigener">Eigener:</label></td>
			<td><input type="text" name="eigener" id="eigener" tabindex="6" onblur="CheckPattern_Text(this, document.getElementById('eigener_help'))" />
			<span id="eigener_help"></span></td>
			
			<td><label for="masthoehe">Masthoehe:</label></td>
			<td><input type="text" name="masthoehe" id="masthoehe" tabindex="14" onblur="CheckPattern_Decimal(this, document.getElementById('masthoehe_help'))" />
			<span id="masthoehe_help"></span></td>
			
			<td><label for="grosssegelgroesse">Grosssegelgroesse:</label></td>
			<td><input type="text" name="grosssegelgroesse" id="grosssegelgroesse" tabindex="22" onblur="CheckPattern_Decimal(this, document.getElementById('grosssegelgroesse_help'))" />
			<span id="grosssegelgroesse_help"></span></td>
		</tr>
		<tr>
			<td><label for="versicherung">Versicherung:</label></td>
			<td><input type="text" name="versicherung" id="versicherung" tabindex="7" onblur="CheckPattern_Text(this, document.getElementById('versicherung_help'))" />
			<span id="versicherung_help"></span></td>
			
			<td><label for="verdraengung">Verdraengung:</label></td>
			<td><input type="text" name="verdraengung" id="verdraengung" tabindex="15" onblur="CheckPattern_Decimal(this, document.getElementById('verdraengung_help'))" />
			<span id="verdraengung_help"></span></td>
			
			<td><label for="genuagroesse">Genuagroesse:</label></td>
			<td><input type="text" name="genuagroesse" id="genuagroesse" tabindex="23" onblur="CheckPattern_Decimal(this, document.getElementById('genuagroesse_help'))" />
			<span id="genuagroesse_help"></span></td>
		</tr>
		<tr>
			<td><label for="rufzeichen">Rufzeichen:</label></td>
			<td><input type="text" name="rufzeichen" id="rufzeichen" tabindex="8" onblur="CheckPattern_Rufzeichen(this, document.getElementById('rufzeichen_help'))" />
			<span id="rufzeichen_help"></span></td>
			
			<td><label for="fligArt">Flig-Art:</label></td>
			<td><input type="text" name="fligArt" id="fligArt" tabindex="16" onblur="CheckPattern_Text(this, document.getElementById('fligart_help'))" />
			<span id="fligart_help"></span></td>
			
			<td><label for="spi">Spi size Spigroesse:</label></td>
			<td><input type="text" name="spi" id="spi" tabindex="24" onblur="CheckPattern_Decimal(this, document.getElementById('spi_help'))" />
			<span id="spi_help"></span></td>
		</tr>	
	</table>		
	</fieldset>
	</form>
	<div id='dynamic_view'><?php dynamic_view(); ?></div>
	</body>
</html>

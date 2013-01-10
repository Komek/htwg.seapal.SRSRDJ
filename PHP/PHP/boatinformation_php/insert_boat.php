<?php
	$insert = "INSERT INTO boatinformation (Registernr,Bootsname,Segelzeichen,Heimathafen,
			 Yachtclub,eigner,Versicherung,Rufzeichen,Typ,Konstrukteur,Laenge,Breite,
			 Tiefgang,Masthoehe,Verdraengung,rigArt,Baujahr,Motor,Tankgroesse,Wassertankgroesse,
			 Abwassertankgroesse,Grosssegelgroesse,Genuagroesse,Spi) VALUES 
			 ('$_POST[registernr]','$_POST[bootsname]','$_POST[segelzeichen]','$_POST[heimathafen]','$_POST[yachtclub]',
			 '$_POST[eigner]','$_POST[versicherung]','$_POST[rufzeichen]','$_POST[typ]','$_POST[konstrukteur]',
			 '$_POST[laenge]','$_POST[breite]','$_POST[tiefgang]','$_POST[masthoehe]','$_POST[verdraengung]','$_POST[rigArt]',
			 '$_POST[baujahr]','$_POST[motor]','$_POST[tankgroesse]','$_POST[wassertankgroesse]','$_POST[abwassertankgroesse]',
			 '$_POST[grosssegelgroesse]','$_POST[genuagroesse]','$_POST[spi]') ON DUPLICATE KEY UPDATE 
			 Bootsname = '$_POST[bootsname]',Segelzeichen = '$_POST[segelzeichen]',Heimathafen = '$_POST[heimathafen]',
			 Yachtclub = '$_POST[yachtclub]',eigner = '$_POST[eigner]',Versicherung = '$_POST[versicherung]',
			 Rufzeichen = '$_POST[rufzeichen]',Typ = '$_POST[typ]',Konstrukteur = '$_POST[konstrukteur]',
			 Laenge = '$_POST[laenge]',Breite = '$_POST[breite]',Tiefgang = '$_POST[tiefgang]',Masthoehe = '$_POST[masthoehe]',
			 Verdraengung = '$_POST[verdraengung]',rigArt = '$_POST[rigArt]',Baujahr = '$_POST[baujahr]',Motor = '$_POST[motor]',
			 Tankgroesse = '$_POST[tankgroesse]',Wassertankgroesse = '$_POST[wassertankgroesse]',
			 Abwassertankgroesse = '$_POST[abwassertankgroesse]',Grosssegelgroesse = '$_POST[grosssegelgroesse]',
			 Genuagroesse = '$_POST[genuagroesse]',spi = '$_POST[spi]'";
	if(!mysql_query($insert)){
		echo "Could not insert: " . mysql_error();
	}
?>
<?php
    $connection = include("../../connection.php");
	
	$action = $_POST['action'];
	
	switch($action){
		case('insert'):
			
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
			if(!mysql_query($insert)){
				echo "Could not insert: " . mysql_error();
			}
			
			break;
		
		case('delete'):
			
			$delete ="DELETE FROM boatinformation WHERE Registernr = '$_POST[key]'";
			if(!mysql_query($delete)){
				echo "Could not delete: " . mysql_error();
			}
			
			break;
	}
	
	
	
			
			mysql_close($connection);
			
?>
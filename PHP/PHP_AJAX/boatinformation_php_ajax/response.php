<?php
	$connection = include("../../connection.php");
	$select = "SELECT bootsname,registernr,segelzeichen,heimathafen,yachtclub,eigner,versicherung,rufzeichen,typ,konstrukteur,laenge,
    						breite,tiefgang,masthoehe,verdraengung,rigArt,baujahr,motor,tankgroesse,wassertankgroesse,abwassertankgroesse,
    						grosssegelgroesse,genuagroesse,spi FROM boatinformation";
    $result = mysql_query($select) or die ("MySQL ERROR: " . mysql_error());
	$response = array();
	$count = 0;
	while ($row = mysql_fetch_array($result)) {
		$response[$count] = array(
			'bootsname' => $row['bootsname'],
			'registernr' => $row['registernr'],
			'segelzeichen' => $row['segelzeichen'],
			'heimathafen' => $row['heimathafen'],
			'yachtclub' => $row['yachtclub'],
			'eigner' => $row['eigner'],
			'versicherung' => $row['versicherung'],
			'rufzeichen' => $row['rufzeichen'],
			'typ' => $row['typ'],
			'konstrukteur' => $row['konstrukteur'],
			'laenge' => $row['laenge'],
			'breite' => $row['breite'],
			'tiefgang' => $row['tiefgang'],
			'masthoehe' => $row['masthoehe'],
			'verdraengung' => $row['verdraengung'],
			'rigArt' => $row['rigArt'],
			'baujahr' => $row['baujahr'],
			'motor' => $row['motor'],
			'tankgroesse' => $row['tankgroesse'],
			'wassertankgroesse' => $row['wassertankgroesse'],
			'abwassertankgroesse' => $row['abwassertankgroesse'],
			'grosssegelgroesse' => $row['grosssegelgroesse'],
			'genuagroesse' => $row['genuagroesse'],
			'spi' => $row['spi'],
		);
		$count++;
	}
	mysql_close($connection);
echo json_encode($response);
?>
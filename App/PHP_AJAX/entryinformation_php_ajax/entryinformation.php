<!DOCTYPE HTML>
<html>
<head>
	<title>Entry Information</title>
	<script type="text/javascript" src="./JS/entryinformation.js"></script>
	<script type="text/javascript" src="./JS/jquery-1.8.2.js"></script>
	<script type='text/javascript'>
	$(function(){
		$('#form').keyup(function (e){
			if (e.keyCode==13){
				entry = new Array(
					document.getElementById('triptitle').value,
					document.getElementById('name').value,
					document.getElementById('ngrad').value,
					document.getElementById('nmin').value,
					document.getElementById('nsec').value,
					document.getElementById('egrad').value,
					document.getElementById('emin').value,
					document.getElementById('esec').value,
					document.getElementById('cog').value,
					document.getElementById('sog').value,
					document.getElementById('btm').value,
					document.getElementById('dtm').value,
					//MARK FEHLT NOCH!!
					document.getElementById('manoever').options[manoever.selectedIndex].text,
					document.getElementById('vorsegel').options[vorsegel.selectedIndex].text,
					document.getElementById('grosssegel').options[grosssegel.selectedIndex].text,
					document.getElementById('notes').value
				);
				entry_send(entry);
			}
		});
	});
	function entry_send(entry){
		$.ajax({
			type: 'POST',
			url: 'process.php',
			data: {
				'triptitle' : entry[0],
				'name' : entry[1],
				'ngrad' : entry[2],
				'nmin' : entry[3],
				'nsec' : entry[4],
				'egrad' : entry[5],
				'emin' : entry[6],
				'esec' : entry[7],
				'cog' : entry[8],
				'sog' : entry[9],
				'btm' : entry[10],
				'dtm' : entry[11],
				'manoever' : entry[12],
				'vorsegel' : entry[13],
				'grosssegel' : entry[14],
				'notes' : entry[15]					
			},
			dataType : 'json',
			success : function(data){
			 	alert(data['msg']);
				window.location.href = "../tripinformation_php_ajax/tripinformation.php?val="+entry[0];
			 }
		});
	}
	</script>
</head>
<body>
	<h1>Entryinformation</h1>
	<?php 
	include("./entryForm.html"); 
	if (isset($_GET['newval'])) {
		echo "<script type='text/javascript'>set_foreign_key('$_GET[newval]');</script>";
	}else{
		include("./select_entry.php");
	}	
	?>
</body>
</html>
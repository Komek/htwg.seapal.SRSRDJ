<!DOCTYPE HTML>
<html>
<head>
	<title>Triplist</title>
	<link rel="stylesheet" type="text/css" href="./JS/style.css">
	<script type='text/javascript' src='./JS/triplist.js'></script>
	<script type='text/javascript' src='./JS/jquery-1.8.2.js'></script>
	<script type='text/javascript'>
	function delete_entry(){
		$.ajax({
			type: 'POST',
			url: 'process.php',
			data: {
				'key' : selected_row_key					
			},
			dataType : 'json',
			success : function(data){
			 	alert(data['msg']);
			 	$('#dynamic_view').load('dynamic_view.php?val='+HTTP_GET_VARS['val']);
			}
		});
	}
	
	
	$(document).ready(function () {
		
		HTTP_GET_VARS=new Array();
		strGET=document.location.search.substr(1,document.location.search.length);
		if(strGET!=''){
		   gArr=strGET.split('&');
			 for(i=0;i<gArr.length;++i){
  				v='';vArr=gArr[i].split('=');
    			if(vArr.length>1){v=vArr[1];}
    			HTTP_GET_VARS[unescape(vArr[0])]=unescape(v);
    		}
		}
		$('#dynamic_view').load('dynamic_view.php?val='+HTTP_GET_VARS['val']);
	});
	</script>
</head>
<body>
	<div id='dynamic_view'></div>
</body>
</html>
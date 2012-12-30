$(document).ready(function(){
	$("#welcome").click(function(){
		$("#austausch").animate({opacity:"0", filter:"alpha(opacity=0)"},400, function(){
			$("#austausch").load("welcome.php", function(){
				$("#austausch").animate({opacity:"1", filter:"alpha(opacity=100)"},400)
			});
		});
	});
	$("#functionOverview").click(function(){
		$("#austausch").animate({opacity:"0", filter:"alpha(opacity=0)"},400, function(){
			$("#austausch").load("functionOverview.php", function(){
				$("#austausch").animate({opacity:"1", filter:"alpha(opacity=100)"},400)
			});
		});
	});
});
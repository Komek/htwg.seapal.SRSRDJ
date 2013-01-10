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
	$("#php_ajax").click(function(){
		$("#tausche_demo").animate({opacity:"0", filter:"alpha(opacity=0)"},400, function(){
			$("#tausche_demo").load("demo_php_ajax.php", function(){
				$("#tausche_demo").animate({opacity:"1", filter:"alpha(opacity=100)"},400)
			});
		});
	});
	$("#JSP").click(function(){
		$("#tausche_demo").animate({opacity:"0", filter:"alpha(opacity=0)"},400, function(){
			$("#tausche_demo").load("demo_servlet.php", function(){
				$("#tausche_demo").animate({opacity:"1", filter:"alpha(opacity=100)"},400)
			});
		});
	});
	$("#map").click(function(){
		$("#tausche_demo").animate({opacity:"0", filter:"alpha(opacity=0)"},400, function(){
			$("#tausche_demo").load("demo_map.php", function(){
				$("#tausche_demo").animate({opacity:"1", filter:"alpha(opacity=100)"},400)
			});
		});
	});
});
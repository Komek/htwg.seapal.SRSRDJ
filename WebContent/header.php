<!DOCTYPE HTML>

<!--
	Citrusy: A responsive HTML5 website template by HTML5Templates.com
	Released for free under the Creative Commons Attribution 3.0 license (html5templates.com/license)
	Visit http://html5templates.com for more great templates or follow us on Twitter @HTML5T
-->

<html>
<head>
<title>SeaPal - <?php echo $name; ?>
</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<noscript>
	<link rel="stylesheet" href="css/5grid/core.css" />
	<link rel="stylesheet" href="css/5grid/core-desktop.css" />
	<link rel="stylesheet" href="css/5grid/core-1200px.css" />
	<link rel="stylesheet" href="css/5grid/core-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	

</noscript>
<script src="css/5grid/jquery.js"></script>
<script	src="css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none"></script>

<script src="js/loadcontent.js" type="text/javascript"></script>

<!--[if IE 9]><link rel="stylesheet" href="css/style-ie9.css" /><![endif]-->
</head>
<body class="homepage">

	<div id="header-wrapper">
		<header id="header">
			<div class="5grid-layout">
				<div class="row">
					<div class="12u" id="logo">
						<!-- Logo -->
						<img id="seapal_logo" src="images/seapal_logo_neu1.png" alt="logo">
					</div>
				</div>
			</div>
			<div class="5grid-layout">
				<div class="row">
					<div class="12u" id="menu">
						<nav class="mobileUI-site-nav">
							<ul>
								<?php



								$menu = array(
											"index.php" => "Homepage",
											"userguide.php" => "User Guide",
											"screenshots.php" => "Screenshots",
											"about.php" => "About",
											"contact.php" => "Contact"
										 );


							foreach ($menu as $i => $value)
							{
								if($name === $value)
								{
									echo '<li class="current_page_item"><a href="'.$i.'">'.$value.'</a></li>';
									continue;
								}
								echo '<li><a href="'.$i.'">'.$value.'</a></li>';
							}

							?>


								<!--<li class="current_page_item"><a href="index.php">Homepage</a></li>
							<li><a href="index.php">Homepage</a></li>
							<li><a href="userguiede.php">User Guide</a></li>
							<li><a href="screenshoots.php">Screenshots</a></li>
							<li><a href="about.php">About</a></li>
							<li><a href="contact.php">Contact</a></li>
							-->

							</ul>
						</nav>
					</div>
				</div>
			</div>
		</header>
	</div>
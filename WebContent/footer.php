
</head><body class="homepage">

<div id="footer-wrapper">
	<div class="5grid-layout">
		<div class="row" id="footer-content">
			<div class="4u" id="box1">
				<section>
					<h2>Where to get SeaPal</h2>
					<ul class="style6">
						<li class="first">
							<h3>SeaPal is available in the following stores</h3>
						</li>
						<li>
							<a href="http://itunes.apple.com/us/app/seapal/id561903907?mt=8&uo=4" target="itunes_store"><img src="images/seapal_logo.png" alt="SeaPal_Logo" align="middle" width="50px" height="50px">iPad App Store</a>
						</li>
						<li>
							<a href="#" target="itunes_store"><img src="images/seapal_logo.png" alt="SeaPal_Logo" align="middle" width="50px" height="50px">iPhone App Store</a>
						</li>
				</section>
			</div>
			<div class="4u" id="box2">
				<section>
					<h2>Help us to promote SeaPal</h2>
					
					<!-- Google Page Badge and +1 -->
					<script type="text/javascript">
 					 (function() {
   					 var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
   					 po.src = 'https://apis.google.com/js/plusone.js';
  					 var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
 					 })();
					</script>
					
					<!-- Link blog to Google+ page -->
					<a style='display: block; height: 0;' href="https://plus.google.com/100825752167882077539/posts" rel="publisher">&nbsp;</a>
					<!-- Google +1 Page badge -->
					<g:plus href="https://plus.google.com/100825752167882077539/posts" height="131" width="300" theme="light"></g:plus>
		
					
					<!-- Facebook like and send button -->
					<div id="fb-root"></div>
					<script>(function(d, s, id) {
				    var js, fjs = d.getElementsByTagName(s)[0];
				    if (d.getElementById(id)) return;
				    js = d.createElement(s); js.id = id;
				    js.src = "//connect.facebook.net/de_DE/all.js#xfbml=1";
				    fjs.parentNode.insertBefore(js, fjs);
					}(document, 'script', 'facebook-jssdk'));</script>
					<div class="fb-like" data-href="https://www.seapal.info" data-send="false" data-width="450" data-show-faces="true"></div>
		
					<p>&#8203</p>
					<!-- Twitter button-->
					<div>
						<iframe allowtransparency="true" frameborder="0" scrolling="no" src="./tweet_button.1347008535.htm" class="twitter-share-button twitter-count-horizontal" style="width: 110px; height: 20px; " title="Twitter Tweet Button" data-twttr-rendered="true"></iframe>
						<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
					</div>
		
		
					<p>&#8203</p>
					<?php
					$hit_count = @file_get_contents('count.txt'); 
					echo "<h3>Besucher: $hit_count</h3>"; 
					$hit_count++; 
					@file_put_contents('count.txt', $hit_count); 
					?>
				</section>
			</div>
			<div class="4u" id="box4">
				<section>
					<h2>Further Information</h2>
					<p><strong>SeaPal is a cooperation that is open for participation. If you have ideas for extensions or want to provide content, please send us a message.</strong></p>
					<ul class="style6">
						<li class="first">
		
						</li>
						<li>
							<a href="#" target="Impressum">Impressum</a>
						</li>
						<li>
							<a href="#" target="Legal notice">Legal notice</a>
						</li>
				</section>
			</div>
		</div>
	</div>
</div>
<div>
	<div class="5grid-layout" id="copyright">
		<div class="row">
			<div class="12u">
				<p>&copy; 2012 IBN Verlag | Design: <a href="http://html5templates.com/">HTML5Templates.com</a></p>
			</div>
		</div>
	</div>
</div>
</body>
</html>

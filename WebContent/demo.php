
<!--------------------------HEADER ------------------------------ -->

<?php 
$name = "Demo";
include("header.php");
?>


<div id="wrapper">
	<div id="page">
		<div class="5grid-layout">
			<div class="row">
				<div class="12u">
					<div class="mobileUI-main-content" id="content">
						<section>
							<div class="post">
								
								<ul>
								<li style="display: inline-block !important; list-style-type: none; margin-right:3em;"><a href="#!demo_JSP_Servlet" id="JSP">JSP/Servlet Version</a></li>
								<li style="display: inline-block !important; list-style-type: none; margin-right:3em;"><a href="#!/demo_php_AJAX" id="php_ajax" >PHP-AJAX Version</a></li>
								<li style="display: inline-block !important; list-style-type: none; margin-right:3em;"><a href="http://127.0.0.1:8888/Fu.html?gwt.codesvr=127.0.0.1:9997" id="GWT" target="_blank">GWT Version</a></li>
								<li style="display: inline-block !important; list-style-type: none; margin-right:3em;"><a href="http://localhost/App/PHP/boatinformation_php/index.php" target="_blank">PHP Version</a></li>
								<li style="display: inline-block !important; list-style-type: none; margin-right:3em;"><a href="http://localhost:8080/SeaPalJSP/boatinformation.php" id="play">Play Version</a></li>
								<li style="display: inline-block !important; list-style-type: none;"><a href="#!demo_map" id="map" >Google Map</a></li>
								</ul>
								<div id="tausche_demo">
								<iFrame src="http://localhost:8080/SeaPalJSP/boatinformation.php" style="width:100%; height:850px; border:none;" frameborder="0" scrolling="no"></iFrame>
								</div>
							</div>
						</section>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<!-----------------------------------FOOTER------------------------------------------------>
<?php include("footer.php");?>


</body>
</html>

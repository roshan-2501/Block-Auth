<!DOCTYPE html>
<html lang="en">
<head>
<title>Verification Authority</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Medi Plus Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/component.css" rel="stylesheet" type="text/css"  />
<link href="css/font-awesome.css" rel="stylesheet"> 			<!-- font-awesome icons -->
<!-- //Custom Theme files -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<script src="js/modernizr.custom.js"></script>
<!-- //js -->
<!-- web fonts -->
<!-- //web fonts -->
</head>
<body class="cbp-spmenu-push">
	<!-- banner -->
	<div class="banner">
		<!-- header -->		
		<div class="w3ls-header">
			<div class="container">	
				<div class="agile-logo">
					<h1><a href="javascript:void(0)">VERIFICATION AUTHORITY</a></h1>
				</div>
				<div class="top-nav">
					<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
						<h3>Menu</h3>
						<a href="login.jsp">Login</a>
						
					</nav>  
					<div class="main buttonset">	
						<!-- Class "cbp-spmenu-open" gets applied to menu and "cbp-spmenu-push-toleft" or "cbp-spmenu-push-toright" to the body -->
						<button id="showRightPush"><img src="images/menu-icon.png" alt=""/></button>
						<!-- <span class="menu"></span> -->
					</div>
					<!-- script-for-drop down -->
					<script>
						$( "a.menu-icon" ).click(function() { 
							$( "ul.nav1" ).slideToggle( 300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- //script-for-dropdown --> 
					<!-- Classie - class helper functions by @desandro https://github.com/desandro/classie -->
					<script src="js/classie.js"></script>
					<script>
						var menuRight = document.getElementById( 'cbp-spmenu-s2' ),
						showRightPush = document.getElementById( 'showRightPush' ),
						body = document.body;

						showRightPush.onclick = function() {
							classie.toggle( this, 'active' );
							classie.toggle( body, 'cbp-spmenu-push-toleft' );
							classie.toggle( menuRight, 'cbp-spmenu-open' );
							disableOther( 'showRightPush' );
						};

						function disableOther( button ) {
							if( button !== 'showRightPush' ) {
								classie.toggle( showRightPush, 'disabled' );
							}
						}
					</script>
					<!-- /script-for-menu -->
				</div>	
			</div>
		</div>
		<!-- //header -->
		<div class="banner-text">	
			<h3>WELCOME TO VERIFICATION AUTHORITY</h3> 
			<h5><i class="fa fa-phone" aria-hidden="true"></i> <span>+11 111 2222</span></h5>
			<h5><i class="fa fa-envelope-o" aria-hidden="true"></i> <a class="email-link" href="mailto:example@mail.com">mail@example.com</a></h5>
			 				 
		</div>
	</div>
	
	
	<!-- services -->
	<div class="services" id="services">
		<div class="container">
			<h3 class="w3l-title">Our Services</h3>
			<div class="service-agileinfo">
				<div class="col-md-4 col-sm-4 srvc-wthreegrids">
					<div class="srvc-img">
						<i class="fa fa-user-md" aria-hidden="true"></i>
					</div>
					<h5>QR Code</h5>
				</div>
				<div class="col-md-4 col-sm-4 srvc-wthreegrids">
					<div class="srvc-img">
						<i class="fa fa-medkit" aria-hidden="true"></i>
					</div>
					<h5>Passport</h5>
				</div>
				<div class="col-md-4 col-sm-4 srvc-wthreegrids">
					<div class="srvc-img">
						<i class="fa fa-ambulance" aria-hidden="true"></i>
					</div>
					<h5>Driving License</h5>
				</div>
				<div class="clearfix"> </div>				
			</div>
		</div>
	</div>
	<!-- //services --> 
	<!-- footer -->
	
	<div class="footer-bottom">
		<div class="container">
			<div class="footer-left">
				<p>© 2019 All rights reserved</p>		
			</div>
			<div class="footer-right">
				<ul class="w3-agileitsicons">
					<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a class="twt" href="#"><i class="fa fa-twitter" aria-hidden="true"></i> </a></li>
					<li><a class="drbl" href="#"><i class="fa fa-linkedin" aria-hidden="true"></i> </a></li>
					<li><a class="be" href="#"><i class="fa fa-dribbble" aria-hidden="true"></i> </a></li>
				</ul>
			</div>
			<script>$(function () {
			  $('[data-toggle="tooltip"]').tooltip()
			})</script>
		</div>
	</div>
	<!-- //footer -->
	<!-- start-smooth-scrolling --> 
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!-- //end-smooth-scrolling -->	
	<script type="text/javascript" src="js/numscroller-1.0.js"></script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="model.QRPojo"%>
<%@page import="service.AuthDao"%><!DOCTYPE html>
<html lang="en">
<head>
<title>Verification Authority</title>
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
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
<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="all"/>
<!-- //Custom Theme files -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<script src="js/modernizr.custom.js"></script>
<!-- //js -->
<!-- web fonts -->
<!-- //web fonts -->
<%
HttpSession hs=request.getSession(false);
String type=(String) hs.getAttribute("type");
String email=(String)hs.getAttribute("email");
%>
<script>
window.onload=function(){
	 document.getElementById('rbtn').style.display='none';
}

</script>
</head>
<body class="cbp-spmenu-push">
	<!-- banner -->
	<div class="banner abt-bnr">
		<!-- header -->		
		<div class="w3ls-header">
			<div class="container">	
				<div class="agile-logo">
					<h1><a href="javascript:void(0)" style="color: white;">VERIFICATION AUTHORITY</a></h1>
				</div>
				<div class="top-nav">
					<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
						<h3>Menu</h3>
						<a href="menu.jsp" class="active">Home</a>
						<a href="Logout">Logout</a>
						
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
					<!-- //script-for-menu -->
				</div>	
			</div>
		
		</div>
		<!-- //header -->  
	</div>
	<!-- //banner -->
	<!-- gallery -->
	<div class="gallery">
		<div class="container">
			<h3>QR Code</h3> <hr/>
			
			<%
			AuthDao authDao=new AuthDao();
			List<QRPojo> list=authDao.loadRequests(email, type);
			for(QRPojo qrPojo: list){
			%>
			<div class="row gallery-info" >			
				<div class="col-sm-4 col-md-4 gallery-grids " style="margin-left: 400px;">
					<div class="thumbnail moments-bottom">
						<a href="<%=qrPojo.getQrcode() %>" title="">
							<img src="<%=qrPojo.getQrcode() %>" class="img-responsive zoom-img " alt="" style="height: 250px;width: 250px">				
						</a>						
					</div>
					<div class="caption gallery-caption">
						<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Scan the QR Code</h5>
<%--						<a href="SeeDocs?doc=9C973BE7238C9022DFD5430F55BEFDFC.txt">9C973BE7238C9022DFD5430F55BEFDFC.txt</a>--%>
					
					
						<center>
						
						<label id="mylocation"></label>
						<button id="rbtn"><a href="SeeDocs">Decrypt the Information</a></button>
						</center>
<%--						<a href="" id="mylocation"></a>--%>
						
					</div>
				</div>
			<%}%>
			
			<script type="text/javascript">
			 	var request; 
		
			 	setInterval(function(){
			 		var name='dd';  
					var url="QrData?name="+name;  
					  
					if(window.XMLHttpRequest){  
					request=new XMLHttpRequest();  
					}  
					else if(window.ActiveXObject){  
					request=new ActiveXObject("Microsoft.XMLHTTP");  
					}  
					try{  
					request.onreadystatechange=getInfo;  
					request.open("POST",url,true);  
					request.send();  
					}catch(e){alert("Unable to connect to server");} 
				},10000)
							
				function getInfo(){  
				if(request.readyState==4){  
				var val=request.responseText;  
				if(val=="no"){
					
				}else{
					var res=val.split(",");
				var text = "";
				for(i = 0; i < res.length; i++){
					text+=res[i]+"<br>"
					
				}
				 document.getElementById('mylocation').innerHTML=text; 
				 document.getElementById('rbtn').style.display='block';
					
				}
				 
				
				}  
				}  
			
			
			</script>
				
			</div>
	</div>
	</div>
	<!-- //gallery -->
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
	<!-- light-box-js  --> 
	<script src="js/jquery.chocolat.js"></script> 
	<script type="text/javascript">
	$(function() {
		$('.moments-bottom a').Chocolat();
	});
	</script> 
	<!-- //end-gallery js -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
</body>
</html>
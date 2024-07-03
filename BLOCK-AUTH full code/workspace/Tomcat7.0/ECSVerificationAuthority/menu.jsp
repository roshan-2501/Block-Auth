<%@page import="service.AuthDao"%>
<%@page import="java.util.List"%>
<%@page import="model.QRPojo"%><!DOCTYPE html>
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
<%
HttpSession hs=request.getSession(false);
String type=(String) hs.getAttribute("type");
%>
<style>
table, td, th {
    height: 30px;
  
}
td
{
/*border: 1px solid black;*/
/*border-bottom: 1px solid gray;*/
}

table {
  border-collapse: collapse;
  width: 100%;
}

th {
  text-align: left;
  background:red;
  border-radius:50px;
}
</style>
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
						<a href="javascript:void(0)" class="active">Home</a>
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
<%--			<ol class="breadcrumb">--%>
<%--				<li class="breadcrumb-item"><a href="index.html">Home</a></li>--%>
<%--				<li class="breadcrumb-item active">Contact Us</li>--%>
<%--			</ol>--%>
		</div>
		<!-- //header -->  
	</div>
	<!-- //banner --> 
	<!-- contact -->
	<div class="contact">
		<div class="container">				
			
				<h3><%=type.substring(0,1).toUpperCase()+type.substring(1,type.length()) %> Requests</h3><hr/><br/><br/><br/>
				<%
				if(request.getAttribute("msg")!=null){
					String msg=(String)request.getAttribute("msg");
				%>
				<center><label style="color: blue;font-size: 20px"><%=msg %></label><p>&nbsp;</p></center>
				<%} %>
				<table>
				<tr>
				<th><center>S.No</center></th>
				<th><center>Email</center></th>
<%--				<th><center>QR Code</center></th>--%>
<%--				<th><center>Image</center></th>--%>
				<th><center>Status</center></th>
				<th><center>QR Code</center></th>
				</tr>
				<%
				AuthDao authDao=new AuthDao();
				List<QRPojo> list=authDao.loadRequests(type);
				int i=1;
				for(QRPojo qrPojo:list){
				if(qrPojo.getStatus().equals("pending")){
				%>
				<tr style="color: green">
				<td><center><%=i %>.</center></td>
				<td><center><%=qrPojo.getEmail() %></center></td>
				<td><center><%=qrPojo.getStatus() %></center></td>
				<td><center><a href="QrCode?email=<%=qrPojo.getEmail() %>">Scan Here</a></center></td>
				</tr>
				<%}else{%>
				<tr style="color: black;">
				<td><center><%=i %>.</center></td>
				<td><center><%=qrPojo.getEmail() %></center></td>
				<td><center><%=qrPojo.getStatus() %></center></td>
				<td><center>Expired</td>
				</tr>
				
				<%}i++;} %>
				</table>
				
				
				
				
			</div>
		</div>		
	<!--//contact-->
	<!-- footer -->
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
</body>
</html>
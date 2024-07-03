<%@page import="service.ServerDao"%>
<%@page import="java.util.List"%>
<%@page import="model.UserPojo"%>
<%@page import="model.CertificatesPojo"%>
<%@page import="model.QrPojo"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Central Board Server</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Chronicle Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Custom Theme files -->
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <!-- shop css -->
    <link href="css/shop.css" type="text/css" rel="stylesheet" media="all">
    <!-- gallery desoslide -->
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/jquery.desoslide.css">
    <!-- gallery desoslide -->
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- font-awesome icons -->
    <!-- //Custom Theme files -->
    <!-- online-fonts -->
    <!-- logo -->
    <style>
.alert {
	padding: 20px;
	background-color: black;
	color: white;
	width: 800px;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
</head>


<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
    <div id="home">
        <!-- header -->
        <!-- navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="main-nav">
                <div class="container">

                    <div class="navbar-header page-scroll">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Chronicle</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <h1>
                            <a class="navbar-brand" href="javascript:void(0)" style="font-family: serif"><b>Central Board</b></a>
                        </h1>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-ex1-collapse nav-right">
                        <ul class="nav navbar-nav navbar-left cl-effect-15">
                            <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                            <li class="hidden">
                                <a class="page-scroll" href="#page-top"></a>
                            </li>
<%--                            <li>--%>
<%--                                <a href="index.html">Home</a>--%>
<%--                            </li>--%>
<%--                           --%>
                            <li>
                                <a href="index.jsp" title="SignIn & SignUp">
                                    <span class="fa fa-user nav-icon" aria-hidden="true"></span>
                                    &nbsp;&nbsp;LOGOUT
                                </a>
                            </li>

                        </ul>
                       
                      
                    </div>
                    <!-- /.navbar-collapse -->
                    <div class="clearfix"></div>
                </div>
                <!-- /.container -->
            </div>
        </nav>
        <!-- //navbar ends here -->
     
     
        <!--//breadcrumbs ends here-->
              <br/><br/><br/> <br/><br/><br/><br/><br/><br/>
      						<%
						if (request.getAttribute("msg") != null) {
							String msg = (String) request.getAttribute("msg");
				%>
					<center>
						<div class="alert">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong><%=msg%></strong>
						</div>
					</center>
					<%
						}
					%>
        <!-- about bottom -->
        <div class="about-bottom section">
            <div class="container-fluid">
                <h4 class="rad-txt" style="margin-left: 550px">
                    <span class="abtxt1">User</span>
                    <span class="abtext">Activities</span>
                </h4>
               
                <div class="col-md-6 home-about2" style="margin-left: 400px;">
                <!-- about-bottom grid2 -->
                <!-- //about-bottom grid2 ends here -->
                <!-- about-bottom grid3 -->
                <div class="col-md-6 col-sm-6 col-xs-6 w3ls-section  stats">
                    <div class="stats-aboutinfo services-main" style="border: none">
                        <div class="agileits_w3layouts-stats-grids text-center" style="width: 500px">
                            <div class="stats-icon">
                                <span class="fa fa-book" aria-hidden="true"></span>
                            </div>
                            <a href="requests.jsp">
                            <div class="stats-right">
                                <h6>User Requests</h6>
                                 <%
                                    ServerDao serverDao=new ServerDao();
                                    List<UserPojo> list=serverDao.loadPendingRequests();
                                    int i=0;
                                    for(UserPojo userPojo : list){
                                  
                                  i++;
                                  }
                                  %>
                                <div class='numscroller numscroller-big-bottom' ><%=i %></div>
                            </div>
                            </a>
                            <div class="clearfix"></div>

                        </div>
                         <a href="document_requests.jsp" >
                        <div class="agileits_w3layouts-stats-grids text-center" style="background: orange;width: 500px">
                            <div class="stats-icon">
                                <span class="fa fa-university" aria-hidden="true"></span>
                            </div>
                            <div class="stats-right">
                                <h6>Approve Certificates</h6>
                                 <%
                                    List<CertificatesPojo> listo=serverDao.loadDocumentRequests();
                                    int i1=0;
                                    for(CertificatesPojo certificatesPojo : listo){
                                    	System.out.println("============="+certificatesPojo.getEmail());
                                    	 i1++;	
                                    }
                                    %>
                                <div class='numscroller numscroller-big-bottom' ><%=i1 %></div>

                            </div>
                            <div class="clearfix"></div>
                        </div>
                        </a>
                        <a href="qr_requests.jsp">
                        <div class="agileits_w3layouts-stats-grids text-center" style="width: 500px;background: navy">
                            <div class="stats-icon">
                                <span class="fa fa-laptop" aria-hidden="true"></span>
                            </div>
                            <div class="stats-right">
                                <h6>QR Code Requestss</h6>
                                  <%
                                    List<QrPojo> list1=serverDao.loadQr();
                                    int i2=0;
                                    for(QrPojo qrPojo : list1){
	                                  i2++;
	                                  }
                                  %>
                                <div class='numscroller numscroller-big-bottom' ><%=i2 %></div>

                            </div>
                            <div class="clearfix"></div>

                        </div>
                      </a>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
               </div>
                <!-- //about-bottom grid3 ends here -->
                <!-- //Numscroller -->
                <div class="clearfix"></div>
            </div>
            <!-- //about container ends here-->
        </div>
        <!--//about bottom ends here-->
      
     
        <div class="cpy-right">
            <p>© 2019 All rights reserved

            </p>
        </div>
    </div>
    <!-- //home -->
    <!-- js -->
    <script src="js/jquery-2.2.3.min.js"></script>
    <!-- //js -->
    <!-- dropdown nav -->
    <script>
        $(document).ready(function () {
            $(".dropdown").hover(
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                    $(this).toggleClass('open');
                }
            );
        });
    </script>
    <!-- //dropdown nav -->
    <!--search jQuery-->
    <script src="js/main.js"></script>
    <!--search jQuery-->
    <!-- cart-js -->
    <script src="js/minicart.js"></script>
    <script>
        chr.render();

        chr.cart.on('new_checkout', function (evt) {
            var items, len, i;

            if (this.subtotal() > 0) {
                items = this.items();

                for (i = 0, len = items.length; i < len; i++) {}
            }
        });
    </script>
    <!-- //cart-js -->
    <!-- gallery desoslide -->
    <script src="js/jquery.desoslide.min.js"></script>
    <script src="js/demo.js"></script>
    <!-- gallery desoslide -->
    <!-- Scrolling Nav JavaScript -->
    <script src="js/scrolling-nav.js"></script>
    <!-- //fixed-scroll-nav-js -->
    <!-- start-smooth-scrolling -->
    <script src="js/move-top.js"></script>
    <script src="js/easing.js"></script>
    <script>
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();

                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 1000);
            });
        });
    </script>
    <!-- //end-smooth-scrolling -->
    <!-- smooth-scrolling-of-move-up -->
    <script>
        $(document).ready(function () {
            /*
            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear' 
            };
            */

            $().UItoTop({
                easingType: 'easeOutQuart'
            });

        });
    </script>
    <script src="js/SmoothScroll.min.js"></script>
    <!-- //smooth-scrolling-of-move-up -->
    <!-- about bottom grid Numscroller -->
    <script src="js/numscroller-1.0.js"></script>
    <!-- //about bottom grid Numscroller -->
    <!-- Bootstrap core JavaScript
 ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>

</html>
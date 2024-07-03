<%@page import="service.ServerDao"%>
<%@page import="java.util.List"%>
<%@page import="model.CertificatesPojo"%><!DOCTYPE html>
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
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <!-- font-awesome icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //Custom Theme files -->
    <!-- online-fonts -->
    <!-- logo -->
   <%
   String email=request.getParameter("email");
   %>
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
                            <li>
                                <a href="menu.jsp">Home</a>
                            </li>
                           
                            <li>
                                <a href="Logout" title="SignIn & SignUp">
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
      
        <!-- breadcrumbs -->
        <div class="crumbs text-center">
            <div class="container">
                <div class="row">
                    <ul class="btn-group btn-breadcrumb bc-list">
                        <li class="btn btn1">
                            <a href="index.html">
                                <i class="glyphicon glyphicon-home"></i>
                            </a>
                        </li>
                        <li class="btn btn2">
                            <a href="contact.html">contact us</a>
                        </li>
                    </ul>
                </div>
            </div><br/><br/>
        </div>
        <!--//breadcrumbs ends here-->
        <!-- contact -->
        <div class="section contact" id="contact">
            <div class="container">
                <h4 class="rad-txt text-center">
                    <span class="abtxt1">Documents</span>
                    <span class="abtext">Verification</span>
                </h4>

                    <!--//contact map grid ends here-->
                    <div class="clearfix"></div>
<%--                </div>--%>
                <!-- contact details -->
                <%
                ServerDao serverDao=new ServerDao();
                List<CertificatesPojo> list=serverDao.loadDocumentRequests(email);
                for(CertificatesPojo certificatesPojo:list){
                %>
                <div class="contact-bottom">
                    <h6>Document Details</h6>
                    <!-- contact details left -->
                    <div class="col-md-6 col-sm-6">
                        <div class="contact-left">
                            <div class="address">
                                <h5>PAN CARD</h5>
                                <p style="color: #34c663"><b><a href="Certificates/PAN Card/<%=certificatesPojo.getEmail() %>/<%=certificatesPojo.getEmail() %>.png" style="color: #34c663"><%=certificatesPojo.getPanCard() %></a></b></p>
                            </div>
                            <div class="address address-mdl">
                                <h5>AADHAR CARD</h5>
                                <p style="color: #34c663"> <b><a href="Certificates/Aadhar Card/<%=certificatesPojo.getEmail() %>/<%=certificatesPojo.getEmail() %>.png" style="color: #34c663"><%=certificatesPojo.getAadharCard() %></a></b></p>
                                
                            </div>
                              <div class="address address-mdl">
                                <h5>VOTER ID</h5>
                                <p style="color: #34c663"><b><a href="Certificates/Voter ID/<%=certificatesPojo.getEmail() %>/<%=certificatesPojo.getEmail() %>.png" style="color: #34c663"><%=certificatesPojo.getVoterId() %></a></b></p>
                                
                            </div>
                              <div class="address address-mdl">
                                <h5>SSLC CERTIFICATE</h5>
                                <p style="color: #34c663"><b><a href="Certificates/SSLC/<%=certificatesPojo.getEmail() %>/<%=certificatesPojo.getEmail() %>.png" style="color: #34c663"><%=certificatesPojo.getSslc() %></a></a></b></p>
                            </div>
                        </div>
                    </div>
                    <!-- //contact details left -->
                    <!-- contact details right -->
                    <div class="col-md-6 col-sm-6">
                        <div class="contact-right">
                            <div class="address">
                                <h5>Email:</h5>
                                 <p>
                                    <a href="javascript:void(0)" style="color: #34c663"><b><%=certificatesPojo.getEmail() %></b></a>
                                </p>
                               
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!-- //contact-details right -->
                    <div class="clearfix"></div>
                                    <center>
                                    <button style="width: 150px;font-size: 20px;border-radius: 10px;color:white ;background:#34c663 "><a href="ApproveDocuments?email=<%=certificatesPojo.getEmail() %>&type=accept" style="color: white;">Accept</a></button>
                                   &nbsp;&nbsp;&nbsp;  
                                   <button style="width: 150px;font-size: 20px;border-radius: 10px;color: white;background:mediumvioletred "><a href="ApproveDocuments?email=<%=certificatesPojo.getEmail() %>&type=decline" style="color: white;">Decline</a></button>
                                     </center>
                    
                </div><%} %>
                <!-- //contact details ends here -->
            </div>
        </div>
        <!-- //contact -->
   
<div class="cpy-right">
    <p>© 2019 All rights reserved </a>
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
    <!-- Bootstrap core JavaScript
 ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>

</html>
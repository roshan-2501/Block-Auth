<%@page import="service.ServerDao"%>
<%@page import="java.util.List"%>
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
    <!-- checkout css -->
    <link href="css/checkout.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <!-- font-awesome icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //Custom Theme files -->
    <!-- online-fonts -->
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
        <!-- banner -->
<%--        <DIV CLASS="BANNER-BG-INNER">--%>
<%--            <!-- BANNER-TEXT -->--%>
<%--            <DIV CLASS="BANNER-TEXT-INNER">--%>
<%--                <DIV CLASS="CONTAINER">--%>
<%--                    <H2 CLASS="TITLE-INNER">--%>
<%--                        WORLD OF READING--%>
<%--                    </H2>--%>
<%----%>
<%--                </DIV>--%>
<%--            </DIV>--%>
<%--            <!-- //BANNER-TEXT -->--%>
<%--        </DIV>--%>
        <!-- //banner -->
      
        <!--checkout-->
        <br/><br/><br/> <br/><br/><br/><br/><br/><br/>
        <div class="innerf-pages section">
            <div class="container">
                <div class="privacy about">
                    <h4 class="rad-txt" style="margin-left: 450px">
                        <span class="abtxt1">QR</span>
                        <span class="abtext">Requests</span>
                    </h4>

                    <div class="checkout-right">
<%--                        <h4>Your shopping cart contains:--%>
<%--                            <span>3 Products</span>--%>
<%--                        </h4>--%>
<%
if(request.getAttribute("msg")!=null){
	String msg=(String)request.getAttribute("msg");
%>
<center><label style="color: #34c663"><%=msg %></label></center>
<br/>
<%} %>
                        <table class="timetable_sub table-responsive">
                            <thead>
                                <tr>
                                    <th>SL No.</th>
                                    <th>Email</th>
                                    <th>Certificates</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            ServerDao serverDao=new ServerDao();
                            List<QrPojo> list=serverDao.loadQr();
                            int i=1;
                            for(QrPojo qrPojo:list){
                            	if(qrPojo.getStatus().equalsIgnoreCase("pending")){
                            %>
                                <tr class="rem1">
                                    <td class="invert"><%=i %></td>
                                    <td class="invert">
                                      <%=qrPojo.getEmail() %>  
                                    </td>
                                    <td class="invert"><%=qrPojo.getCertificates()%></td>
                                    <td>
                                    <button style="background-color: #34c663"><a href="QrApproveOrDecline?email=<%=qrPojo.getEmail() %>&reason=generate&certificates=<%=qrPojo.getCertificates() %>" style="color: white;">Generate</a></button>&nbsp;
                                    <button style="background-color: mediumvioletred"><a href="QrApproveOrDecline?email=<%=qrPojo.getEmail() %>&reason=decline" style="color: white;">Decline</a></button>
                                    </td>
                                </tr>
                                <%}else{%>
                                <tr class="rem1" style="background: gray">
                                    <td class="invert"><%=i %></td>
                                    
                                    <td class="invert">
                                      <%=qrPojo.getEmail() %>  
                                    </td>
                                    <td class="invert"><%=qrPojo.getStatus() %></td>
                                   <%
                                   if(!qrPojo.getStatus().equalsIgnoreCase("declined")){
                                   %>
                                    <td>
                                    Generated
                                    </td>
                                    <%}else{ %>
                                    <td>
                                    Declined
                                    </td>
                                    <%}%>
                                </tr>
                                <%}i++;} %>
                               
                            </tbody>
                        </table>
                    </div>
                  
                </div>

            </div>
        </div>
        <!--//checkout-->
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <div class="cpy-right">
            <p>© 2019 All rights reserved
            </p>
        </div>
    </div>
    <!-- //home -->

    <!-- Common js -->
    <script src="js/jquery-2.2.3.min.js"></script>
    <!--// Common js -->
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
    <!--quantity-->
    <script>
        $('.value-plus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                newVal = parseInt(divUpd.text(), 10) + 1;
            divUpd.text(newVal);
        });

        $('.value-minus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                newVal = parseInt(divUpd.text(), 10) - 1;
            if (newVal >= 1) divUpd.text(newVal);
        });
    </script>
    <!--quantity-->
    <!-- FadeOut-Script -->
    <script>
        $(document).ready(function (c) {
            $('.close1').on('click', function (c) {
                $('.rem1').fadeOut('slow', function (c) {
                    $('.rem1').remove();
                });
            });
        });
    </script>
    <script>
        $(document).ready(function (c) {
            $('.close2').on('click', function (c) {
                $('.rem2').fadeOut('slow', function (c) {
                    $('.rem2').remove();
                });
            });
        });
    </script>
    <script>
        $(document).ready(function (c) {
            $('.close3').on('click', function (c) {
                $('.rem3').fadeOut('slow', function (c) {
                    $('.rem3').remove();
                });
            });
        });
    </script>
    <!--// FadeOut-Script -->

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

    <!-- Scrolling Nav JavaScript -->
    <script src="js/scrolling-nav.js"></script>
    <!-- //fixed-scroll-nav-js -->
    <!--//scripts-->
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
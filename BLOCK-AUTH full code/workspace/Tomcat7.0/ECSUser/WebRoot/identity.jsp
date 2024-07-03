<!DOCTYPE html>
<html lang="zxx">
  <head>
    <title>ECS User</title>
    <!--meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="ClassWork Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
      SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script>
      addEventListener("load", function () {
      	setTimeout(hideURLbar, 0);
      }, false);
      
      function hideURLbar() {
      	window.scrollTo(0, 1);
      }
    </script>
    <!--//meta tags ends here-->
    <!--booststrap-->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <!--//booststrap end-->
    <!-- font-awesome icons -->
    <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
    <!-- //font-awesome icons -->
    <link href="css/blast.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/style10.css" />
    <!--stylesheets-->
    <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
    <!--//stylesheets-->
    <script type="text/javascript">
    function callPAN(){
     var a=Math.floor(Math.random() * 9999);
     var b='CKJPB'+a+'J';
     document.getElementById('pans').value=b;
    }
    </script>
    <%
    HttpSession hs=request.getSession(false);
    String name=(String)hs.getAttribute("name");
    %>
  </head>
  <body>
    <div class="blast-box">
      <div class="blast-icon"><span class="fas fa-tint"></span></div>
      <div class="blast-frame">
        <p>change colors</p>
        <div class="blast-colors">
          <div class="blast-color">#86bc42</div>
          <div class="blast-color">#8373ce</div>
          <div class="blast-color">#14d4f4</div>
          <div class="blast-color">#72284b</div>
        </div>
        <p class="blast-custom-colors">Custom colors</p>
        <input type="color" name="blastCustomColor" value="#cf2626">
      </div>
    </div>
    <div class="header-outs" id="header" style="margin-top: -70px">
      <div class="header-w3layouts">
        <nav class="navbar navbar-expand-lg navbar-light">
          <div class="hedder-up">
            <h1 ><a href="javascript:void(0)" class="navbar-brand" data-blast="color">Classwork</a></h1>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          </button>
          <div class="headdser-nav-color" data-blast="bgColor">
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <ul class="navbar-nav ">
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <!--//navigation section -->
        <div class="clearfix"> </div>
      </div>
      <!--banner -->
   <br/><br/><br/><br/><br/> 
    </div>
    <!-- //banner -->
  <form method="post" action="Identity" enctype="multipart/form-data">
    <section class="team py-lg-4 py-md-3 py-sm-3 py-3" id="team">
      <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
        <h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">User Identity</h3>
        <div class="row ">
          <div class="col-lg-3 col-md-6 col-sm-6 profile" style="margin-left: 430px">
            <div class="team-shadow">
              <img id="blah" style="height:320px;width: 255px" onclick="document.getElementById('img').click()"/>
              <div class="team-w3layouts-info py-lg-4 py-3 text-center" data-blast="bgColor">
                <h4 class="text-white mb-2"><%=name %></h4>
<%--                <span class="wls-client-title text-black">Professor</span>--%>
              </div>
            </div>
              <input type="file" style="visibility: hidden;"  onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"  id="img" name="image"><br/>
          </div>
        </div>
          <center><input type="submit" value="Upload" style="background: #ea1d5d;width: 150px;height: 40px;border-radius:10px"/></center>
      </div>
    </section>
  </form>
  
    <div class="nav-footer py-sm-4 py-3">
      <div class="container-fluid">
        <div class="buttom-nav ">
          <center><p style="color: white;">  © 2019 All Rights Reserved </p></center>
        </div>
      </div>
    </div>
 
    <!--model-->
    <div id="exampleModalLive" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLiveLabel" data-blast="color">ClassWork</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <img src="images/b2.jpg" alt="" class="img-fluid">
            <p>Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae,
              eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellu
            </p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>  
    <!--//model-->
    <!--js working-->
    <script src='js/jquery-2.2.3.min.js'></script>
    <!--//js working--> 
    <!--blast colors change-->
    <script src="js/blast.min.js"></script>
    <!--//blast colors change-->
    <!--responsiveslides banner-->
    <script src="js/responsiveslides.min.js"></script>
    <script>
      // You can also use "$(window).load(function() {"
      $(function () {
      	// Slideshow 4
      	$("#slider4").responsiveSlides({
      		auto: true,
      		pager:false,
      		nav:true ,
      		speed: 900,
      		namespace: "callbacks",
      		before: function () {
      			$('.events').append("<li>before event fired.</li>");
      		},
      		after: function () {
      			$('.events').append("<li>after event fired.</li>");
      		}
      	});
      
      });
    </script>
    <!--// responsiveslides banner-->		  
    <!--responsive tabs-->	 
    <script src="js/easy-responsive-tabs.js"></script>
    <script>
      $(document).ready(function () {
      $('#horizontalTab').easyResponsiveTabs({
      type: 'default', //Types: default, vertical, accordion           
      width: 'auto', //auto or any width like 600px
      fit: true,   // 100% fit in a container
      closed: 'accordion', // Start closed if in accordion view
      activate: function(event) { // Callback function if tab is switched
      var $tab = $(this);
      var $info = $('#tabInfo');
      var $name = $('span', $info);
      $name.text($tab.text());
      $info.show();
      }
      });
      });
       
    </script>
    <!--// responsive tabs-->	
    <!--About OnScroll-Number-Increase-JavaScript -->
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.countup.js"></script>
    <script>
      $('.counter').countUp();
    </script>
    <!-- //OnScroll-Number-Increase-JavaScript -->	  
    <!-- start-smoth-scrolling -->
    <script src="js/move-top.js"></script>
    <script src="js/easing.js"></script>
    <script>
      jQuery(document).ready(function ($) {
      	$(".scroll").click(function (event) {
      		event.preventDefault();
      		$('html,body').animate({
      			scrollTop: $(this.hash).offset().top
      		}, 900);
      	});
      });
    </script>
    <!-- start-smoth-scrolling -->
    <!-- here stars scrolling icon -->
    <script>
      $(document).ready(function () {
      
      	var defaults = {
      		containerID: 'toTop', // fading element id
      		containerHoverID: 'toTopHover', // fading element hover id
      		scrollSpeed: 1200,
      		easingType: 'linear'
      	};
      
      
      	$().UItoTop({
      		easingType: 'easeOutQuart'
      	});
      
      });
    </script>
    <!-- //here ends scrolling icon -->
    <!--bootstrap working-->
    <script src="js/bootstrap.min.js"></script>
    <!-- //bootstrap working-->
  </body>
</html>
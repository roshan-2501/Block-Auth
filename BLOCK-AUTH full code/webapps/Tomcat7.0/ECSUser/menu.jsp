<%@page import="java.util.List"%>
<%@page import="model.CertificatesPojo"%>
<%@page import="service.UserDao"%>
<%@page import="model.QrPojo"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="com.rest.client.ServerCall"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="org.codehaus.jettison.json.JSONException"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
    <title>ECS User</title>
    <!--meta tags -->
    <meta charset="UTF-8">
    <meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="-1" />
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
    function callAadhar(){
    	var a=Math.floor(Math.random() * 100000000000000);
    	document.getElementById('aadhars').value=a;
    }
    function callVoter(){
    	 var a=Math.floor(Math.random() * 10000000);
     	 var b='VTR'+a;
     	 document.getElementById('voters').value=b;
    }
    function callSSLC(){
    	var a=Math.floor(Math.random() * 1000000);
    	document.getElementById('sslcs').value=a;
    }
    </script>
    <%
    HttpSession hs=request.getSession(true);
    String name=(String)hs.getAttribute("name");
    String email=(String)hs.getAttribute("email");
    String image=(String)hs.getAttribute("image");
    UserDao userDao=new UserDao();
    List<CertificatesPojo> list=userDao.loadCertificateStatus(email);
    String panStatus="";
    String aadharstatus="";
    String sslcStatus="";
    String voterIdStatus="";
    String panCard="";
    String aadharCard="";
    String voterId="";
    String sslc="";
    String status="";
   if(!list.isEmpty()){
	   for(CertificatesPojo certificatesPojo: list){
	    	panStatus=certificatesPojo.getPanStatus();
	    	aadharstatus=certificatesPojo.getAadharStatus();
	    	voterIdStatus=certificatesPojo.getVoterIDStatus();
	    	sslcStatus=certificatesPojo.getSslcStatus();
	    	panCard=certificatesPojo.getPanCard();
	    	aadharCard=certificatesPojo.getAadharCard();
	    	voterId=certificatesPojo.getVoterId();
	    	sslc=certificatesPojo.getSslc();
	    	status=certificatesPojo.getStatus();
	    }}
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
            <h1 ><a href="javascript:void(0)" class="navbar-brand" data-blast="color">ECS USER</a></h1>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
          </button>
          <div class="headdser-nav-color" data-blast="bgColor">
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <ul class="navbar-nav ">
<%--                <li class="nav-item active">--%>
<%--                  <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>--%>
<%--                </li>--%>
                <li class="nav-item">
                  <a href="Logout" class="nav-link ">Logout</a>
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
    <!--about-->
   <br/><br/><br/>
 <center>
 <img src="Identity/<%=email %>/<%=image %>" style="height: 50px;width: 50px;border-radius:50px"/> Welcome :- <label><%=name %> ...!!</label>
 </center>
 <hr/>
 <%
 if(request.getAttribute("msgs")!=null){
	String msgs=(String)request.getAttribute("msgs");
 %>
 <center>
 <label style="color: red"><%=msgs%></label>
 </center>
 <%}%>
    <section class="about" id="about">
      <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
        <!--Horizontal Tab-->
        <div id="horizontalTab">
          <ul class="resp-tabs-list justify-content-center">
            <li data-blast="bgColor">Upload Certificates</li>
            <li data-blast="bgColor" id="qrrequest">QR Request</li>
            <li data-blast="bgColor">Digital Certificates</li>
            <li data-blast="bgColor">Digital Document</li>
          </ul>
          <div class="resp-tabs-container">
            <div class="tab1" >
              <div class="row mt-lg-4 mt-3">
                <div class="col-md-7 latest-list">
                  <div class="about-jewel-agile-left">
<%--                    <h4 class="mb-3" data-blast="color">Dolor sit </h4>--%>
<%--                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nibh urna, euismod ut ornare non, volutpat vel tortor. Integer laoreet placerat suscipit. Sed sodales scelerisque</p>--%>
                    <h4 data-blast="color"> Upload the below listed documents<span style="color: red">*</span></h4>
				<hr/><br/>
				<ul type="disc">
				<li><input type="radio" name="rad" data-toggle="modal" data-target="#pan" data-blast="bgColor"/>&nbsp;&nbsp;PAN Card
				<%if(panStatus.equals("pending")) {%>
				<label style="color: red;margin-left: 160px"><%=panStatus %></label>
				<%}else{ %>
				<label style="color: blue;margin-left: 160px"><%=panCard %></label>
				<%} %>
				</li><br/>
				<li><input type="radio" name="rad" data-toggle="modal" data-target="#aadhar" data-blast="bgColor"/>&nbsp;&nbsp;Aadhar Card
				<%if(aadharstatus.equals("pending")) {%>
				<label style="color: red;margin-left: 135px"><%=aadharstatus %></label>
				<%}else{ %>
				<label style="color: blue;margin-left: 135px"><%=aadharCard %></label>
				<%} %>
				</li><br/>
				<li><input type="radio" name="rad" data-toggle="modal" data-target="#voter" data-blast="bgColor"/>&nbsp;&nbsp;Voter ID
				<%if(voterIdStatus.equals("pending")) {%>
				<label style="color: red;margin-left: 170px"><%=voterIdStatus %></label>
				<%}else{ %>
				<label style="color: blue;margin-left: 170px"><%=voterId %></label>
				<%} %>
				</li><br/>
				<li><input type="radio" name="rad" data-toggle="modal" data-target="#sslc" data-blast="bgColor"/>&nbsp;&nbsp;SSLC Certificate
				<%if(sslcStatus.equals("pending")) {%>
				<label style="color: red;margin-left: 100px"><%=sslcStatus %></label>
				<%}else{ %>
				<label style="color: blue;margin-left: 100px"><%=sslc %></label>
				<%}%>
				</li><br/>
				</ul>
			<%if(status.equals("approved")){
			%>
			<marquee><label style="color:#ea1d5d"><b>Your documents are approved by the cenral board</b></label></marquee>
			<%} else if(status.equals("declined")){%>	
			<marquee><label style="color:#ea1d5d"><b>Your documents are rejected by central board</b></label></marquee>
			<%} else{%>
			<marquee><label style="color:#ea1d5d"><b>Waiting for central board confirmation</b></label></marquee>
			<%} %>
<div id="pan" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
        
       <form  method="post" action="PanCard" enctype="multipart/form-data">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLiveLabel" data-blast="color">PAN CARD : 
            <%if(panStatus.equals("pending")) {%>
            <label style="color: blue;"><%=panStatus %></label>
            <%}else{%>
            <label style="color: blue;"><%=panCard %></label>
            <%} %>
            </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
<%--            <img src="images/b2.jpg" alt="" class="img-fluid">--%>
           <div class="col-md-7 contact-form">
             <br/><br/>
<%--             <%if(request.getAttribute("msg")!=null) {--%>
<%--             String msg=(String)request.getAttribute("msg");--%>
<%--             %>--%>
<%--             <center><label style="color: blue;"><%=msg %></label></center><%} %>--%>
              <div class="form-group contact-forms">
              <input type="hidden" name="type" value="pan card">
               <label>PAN Card Number</label><input type="text"  class="form-control" required="" style="color: black;" name="name" id="pans" onclick="callPAN()">
              </div>
              <div class="form-group contact-forms">
               <label>Upload PAN Card</label><input type="file" name="file">
              </div>
          </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
       </form>
          
        </div>
      </div>
  </div>  
 <div id="aadhar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form  method="post" action="PanCard" enctype="multipart/form-data">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLiveLabel" data-blast="color">Aadhar Card :
             <%if(aadharstatus.equals("pending")) {%>
            <label style="color: blue;"><%=aadharstatus %></label>
            <%}else{%>
            <label style="color: blue;"><%=aadharCard %></label>
            <%} %>
             </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
<%--            <img src="images/b2.jpg" alt="" class="img-fluid">--%>
           <div class="col-md-7 contact-form">
             <br/><br/>
<%--<%--             <%if(request.getAttribute("msg")!=null) {--%>
<%--             String msg=(String)request.getAttribute("msg");--%>
<%--             %>--%>
<%--             <center><label style="color: blue;"><%=msg %></label></center><%} %>--%>
              
              <div class="form-group contact-forms">
               <input type="hidden" name="type" value="aadhar card">
               <label>Aadhar Card Number</label><input type="text" class="form-control" required=""   onclick='callAadhar()' style="color: black;" name="name" id="aadhars">
              </div>
               <div class="form-group contact-forms">
               <label>Upload Aadhar Card</label><input type="file" name="file">
              </div>
          </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
           </form>
        </div>
      </div>
</div>
<div id="voter" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form  method="post" action="PanCard" enctype="multipart/form-data">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLiveLabel" data-blast="color">Voter Identity : 
            <%if(voterIdStatus.equals("pending")) {%>
            <label style="color: blue;"><%=voterIdStatus %></label>
            <%}
            else{%>
            <label style="color: blue;"><%=voterId %></label>
            <%} %></h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
<%--            <img src="images/b2.jpg" alt="" class="img-fluid">--%>
           <div class="col-md-7 contact-form">
             <br/><br/>
<%--             <%if(request.getAttribute("msg")!=null) {--%>
<%--             String msg=(String)request.getAttribute("msg");--%>
<%--             %>--%>
<%--             <center><label style="color: blue;"><%=msg %></label></center><%} %>--%>
             <div class="form-group contact-forms">
               <input type="hidden" name="type" value="voter id">
               <label>Voter ID</label><input type="text"  class="form-control" required="" style="color: black;" name="name" id="voters" onclick="callVoter()">
              </div>
               <div class="form-group contact-forms">
               <label>Upload Voter Identity</label><input type="file" name="file">
              </div>
          </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
           </form>
        </div>
      </div>
</div>

 <div id="sslc" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLiveLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form  method="post" action="PanCard" enctype="multipart/form-data">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLiveLabel" data-blast="color">SSLC Certificate : 
            <%if(sslcStatus.equals("pending")) {%>
            <label style="color: blue;"><%=sslcStatus%></label>
            <%}else{%>
            <label style="color: blue;"><%=sslc%></label>
            <%} %>
            </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
<%--            <img src="images/b2.jpg" alt="" class="img-fluid">--%>
           <div class="col-md-7 contact-form">
             <br/><br/>
<%--             <%if(request.getAttribute("msg")!=null) {--%>
<%--             String msg=(String)request.getAttribute("msg");--%>
<%--             %>--%>
<%--             <center><label style="color: blue;"><%=msg %></label></center><%} %>--%>
              <div class="form-group contact-forms">
               <input type="hidden" name="type" value="sslc">
               <label>Hall Ticket Number</label><input type="text"  class="form-control" required="" style="color: black;" name="name" id="sslcs" onclick="callSSLC()">
              </div>
              <div class="form-group contact-forms">
               <label>Upload SSLC Certificate</label><input type="file" name="file">
              </div>
          </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
           </form>
        </div>
      </div>
    </div>
				
     </div>
    </div>

  </div>
 </div>
            <div class="tab3">
<%--<br/><br/><br/><br/><br/><br/><br/><br/>--%>
              <div class="row mt-lg-4 mt-3">
                <div class="col-md-7 latest-list">
                  <div class="about-jewel-agile-left">
                    <h4 class="mb-3" data-blast="color">Request here for QR Code for applying Passport & Driving license </h4><hr/>
					<form action="QrRequest" method="post">
					<br/>
					<ul type="disc">
					<li><input type="checkbox" value="PAN Card" name="docs">&nbsp;PAN Card</li><br/>
					<li><input type="checkbox" value="Aadhar Card" name="docs">&nbsp;Aadhar Card</li><br/>
					<li><input type="checkbox" value="Voter ID" name="docs">&nbsp;Voter ID</li><br/>
					<li><input type="checkbox" value="SSLC" name="docs">&nbsp;SSLC Certificate</li>
				   </ul><br/>
				   <label><input type="submit" value="QR Request" style="width: 150px;background: #ea1d5d;color: white;height: 30px;border-radius:10px"></label>
				   </form>
                  </div>
                </div>
               <%
               List<QrPojo> listo=userDao.loadQr(email);
               if(!list.isEmpty()){
            	   for(QrPojo qrPojo:listo){
            	   if(!qrPojo.getStatus().equals("pending")){
               %>
                <div class="col-md-5 about-txt-img">
                <br/><br/>
                <img src="<%=qrPojo.getQrcode()%>" class="img-thumbnail" alt="" style="width: 200px;height: 200px" id="qrs">
<%--                <marquee><label style="color:#ea1d5d"><b>Scan the above QR Code</b></label></marquee>--%>
				<b><label id="qrresponse" style="color:#ea1d5d"></label></b>
              	<br/><br/>
              	<label>&nbsp;&nbsp;&nbsp;<input type="radio" name="docs" onclick="callQrBtn('passport')" value="passport" id="pass"/>&nbsp;Apply Passport</label><br/>
                <%--<label>&nbsp;&nbsp;&nbsp;<input type="radio" name="docs" onclick="callQrBtn('license')" value="driving license" id="pass"/>&nbsp;Apply Driving License</label><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                --%><label><input type="submit" style="width: 150px;background: #ea1d5d;color: white;height: 30px;border-radius:10px" value="Apply" id="qrbtn" onclick="sendQrInfo()"/></label>
                </div>
                <%}}} %>
              </div>
            </div>
            <script type="text/javascript">
            window.onload=function()
			{ 
            	document.getElementById('qrbtn').style.display='none';
            }
            var request; 
            var docs;
            function callQrBtn(passport){
            	docs=passport;
            	document.getElementById('qrbtn').style.display='block';
            	
            }
            function sendQrInfo(){
	        var qrcode=document.getElementById('qrs').src;
	        var url="ApplyForProofs?qrcode="+qrcode+"&docs="+docs;
	            
	        if(window.XMLHttpRequest){  
			request=new XMLHttpRequest();  
			}  
			else if(window.ActiveXObject){  
			request=new ActiveXObject("Microsoft.XMLHTTP");  
			}  
			try{  
			request.onreadystatechange=getQrInfo;  
			request.open("POST",url,true);  
			request.send();  
			}catch(e){alert("Unable to connect to server");}  
			}  
  
           function getQrInfo(){  
			if(request.readyState==4){  
			var val=request.responseText;  
			document.getElementById('qrbtn').style.display='none';
			document.getElementById('qrresponse').innerHTML="<br>"+val;  
			}  
			}
            
            </script>
    <div class="tab5">
    <div class="row mt-lg-4 mt-3">
                <div class="col-md-7 latest-list">
                  <div class="about-jewel-agile-left">
                    <h4 class="mb-3" data-blast="color">Digital Certificates Status </h4><hr/><br/>
	<%
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("email", email);
	ServerCall serverCall=new ServerCall();
	JSONArray jsonArray=serverCall.proofsStatus(jsonObject);
	 try {
	        JSONObject jObject = null;
	        for (int i = 0; i < jsonArray.length(); i++) {
	            jObject = jsonArray.getJSONObject(i);
	            String type = jObject.getString("type");
	            String aStatus = jObject.getString("status");
	            if(type.equals("no")){%>
	            <br/><br/><br/>
	            <marquee><label style="color:#ea1d5d"><b>There is no Digital Certificates issued to you</b></label></marquee>
	            <%--                <marquee><label style="color:#ea1d5d"><b>Scan the above QR Code</b></label></marquee>--%>
	            
	            <%}else{
	            if(aStatus.equals("pending"))	{
	            %>
	            
				<ul type="disc">
				<li><label style="color: #ea1d5d;">*</label> <b>Your <%=type %> is not issued yet.</b></li>
				</ul><br/>
	            <%}else{%>
	            <ul type="disc">
				<li><label style="color: #ea1d5d;">*</label> <b>Your <%=type %> is <%=aStatus %></b></li>
				</ul><br/>
	            <%}
	            }
	        }
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	%>
	
	</div>
</div>
</div>
            </div>
     <div class="tab6">
     <div class="row mt-lg-4 mt-3">
                <div class="col-md-7 latest-list">
                  <div class="about-jewel-agile-left">
                    <h4 class="mb-3" data-blast="color">Digital Documents</h4><hr/>
					
					<br/>
					<ul type="disc">
					
					<li><a href="/ECSUser/Pan.jsp" style="color:#000000">&nbsp;PAN Card</a></li><br/>
					<li><a href="/ECSUser/Aadhar.jsp" style="color:#000000">&nbsp;Aadhar Card</a></li><br/>
					<li><a href="/ECSUser/Voter.jsp" style="color:#000000">&nbsp;Voter ID</a></li><br/>
					<li><a href="/ECSUser/SSLC.jsp" style="color:#000000">&nbsp;SSLC Certificate</a></li></li>
				   </ul><br/>
                  </div>
                </div>
     
     </div>       
            
            
            
          </div>
        </div>
      </div>
    </section>
    <!--//about-->
  
    <!--footer-->
   <br/><br/><br/><br/><br/><br/>
    <div class="nav-footer py-sm-4 py-3">
      <div class="container-fluid">
        <div class="buttom-nav ">
          <center><p style="color: white;">  © 2019 All Rights Reserved </p></center>
        </div>
      </div>
    </div>
 
   
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
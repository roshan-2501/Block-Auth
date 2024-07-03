<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<style>
thead {color:green;}
tbody {color:blue;}
tfoot {color:red;}

table, th, td {
  border: 1px solid black;
}
</style>
		
		<style>
* {
	box-sizing: border-box
}

body {
	font-family: "Lato", sans-serif;
}
/* Style the tab */
</style>
		<link href="css/custom.css" rel="stylesheet" type="text/css"
			media="all" />
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
			media="all" />
		<link href="css/style.css" rel="stylesheet" type="text/css"
			media="all" />
		<script src="js/jquery.min.js">
</script>
		<script src="js/simpleCart.min.js">
</script>
		<script type="text/javascript" src="js/bootstrap-3.1.1.min.js">
</script>

		<link rel="stylesheet" href="css/jquery.countdown.css" media="all" />
		<link href="css/animate.min.css" rel="stylesheet" media="all">
		<script src="js/wow.min.js">

</script>

	</head>
	<body>
		<script type="text/javascript">
window.onload = function() {

	document.getElementById("print").style.display = "none";
};
</script>

		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
		<script type='text/javascript' src="jspdf.debug.js">
</script>
		<script type="text/javascript">
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah').attr('src', e.target.result).width(100).height(100);
		};
		document.getElementById("file").style.display = "none";
		document.getElementById("print").style.display = "block";
		reader.readAsDataURL(input.files[0]);
	}
}
</script>


		<div class="header">
			<div class="container">
				<div class="header">
					<div class="logo-nav-left1">
						<nav class="navbar navbar-default">
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul class="nav navbar-nav">
								
								<%
									HttpSession httpSession = request.getSession(false);
								%>
															</ul>
						</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div id="userdetail" media="all">
			<%--<form onsubmit="printDiv('userdetail')" name="driving">
			--%>
			<%
				String ch = "";
				HashMap map = null;
				if (request.getAttribute("Verify") == null) {
					ch = "Not";
				} else {
					map = (HashMap) request.getAttribute("Verify");
				}
			%>
			<form action="Aadhar" method="get" name="Aadhar"
				onsubmit="return validate()">
				<center>
					<font size=15>SECONDARY SCHOOL LEAVING CERTIFICATE</font><br/>
					<h4>ISSUED UNDER THE AUTHORITY OF THE GOVERNMENT OF TAMIL NADU</h4>
					<table cellpadding=1 cellspacing= border="1" width="50%"
						height="100%">

						<tr bgcolor="lightblue">
							<td valign="middle">
								
								<input width="100px" type="hidden" id="Name" name="Type"
									value="SSLC">
								<%
									if (ch.equals("Not")) {
								%>
						&nbsp; &nbsp;	<b>Candidate Name</b>	<input type="text" name="Name"
									value=" " required=" ">
								<%
									} else {
								%>
							<b>Candidate Name</b>	<input type="text" name="Name" value="<%=map.get("Name")%>"
									size=20 readonly>
								<%
									}
								%>

							</td>
							<td align="center">
								<br />
								<img align="middle" id="blah" src="#" alt="your image"
									width="100" height="100" />
							</td>
						</tr>

						<tr bgcolor="lightblue">
							
							<td valign="middle" colspan=2>
												
								<%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="date" name="Date" value="" required=" "><b>Certified that the above mentioned candidate appeared for the SSLC examination and obtained the following marks:</b>
								<%
									} else {
								%>
								<input type="text" name="Date" size=20
									value="<%=map.get("Date")%>" readonly><b>Certified that the above mentioned candidate appeared for the SSLC examination and obtained the following marks:</b>

								<%
									}
								%>
						
							
						<tr bgcolor="lightblue">
						 <th><font color="green">Subject</font></th>
      <th><font color="green">Marks</font></th>
							<td valign=top >
  <tbody>
    <tr>
      <td>Tamil</td>
    <td>  <%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m1" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m1" size=20
									value="<%=map.get("m1")%>" readonly>

								<%
									}
								%></td>
    </tr>
    <tr>
      <td>English</td>
     <td>  <%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m2" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m2" size=20
									value="<%=map.get("m2")%>" readonly>

								<%
									}
								%></td>
    </tr>
    <tr>
      <td>Maths</td>
    <td>   <%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m3" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m3" size=20
									value="<%=map.get("m3")%>" readonly>

								<%
									}
								%></td>
    </tr>
    <tr>
      <td>Science</td>
    <td>   <%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m4" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m4" size=20
									value="<%=map.get("m4")%>" readonly>

								<%
									}
								%></td>
    </tr>
    <tr>
      <td>Social</td>
      <td> <%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m5" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m5" size=20
									value="<%=map.get("m5")%>" readonly>

								<%
									}
								%></td>
    </tr>
  </tbody>
 
    <tr>
       <td><font color="red">Total</font></td>
      <td><%
									if (ch.equals("Not")) {
								%>
								&nbsp;&nbsp;<input type="text" name="m6" value="" required=" ">
								<%
									} else {
								%>
								<input type="text" name="m6" size=20
									value="<%=map.get("m6")%>" readonly>

								<%
									}
								%></td>
    </tr>
    
    <tr bgcolor="lightblue">
							<td valign="middle">
								
								<%
									if (ch.equals("Not")) {
								%>
						    &nbsp;	<b>Date Of Birth</b>
						    <br>
							<input type="date" name="DOB" value="" required=" ">
				
								<%
									} else {
								%>
							<b>Date Of Birth</b>	<input type="text" name="DOB" size=20
									value="<%=map.get("DOB")%>" readonly>

								<%
									}
								%>

							</td>
							<td valign="middle">
								
								<%
									if (ch.equals("Not")) {
								%>
						    &nbsp;	<b>Register No</b>
						    <br>
							<input type="text" name="reg" value="" required=" ">
				
								<%
									} else {
								%>
							<b>Register No</b>	<input type="text" name="reg" size=20
									value="<%=map.get("reg")%>" readonly>

								<%
									}
								%>
							
							
						</tr>
    		
							</td>
							
						</tr>
						
						<br />
						</div>
						<div id="print2">
							<tr bgcolor="lightblue">
							<%
								if (ch.equals("Not")) {
							%>
							<td align=center colspan=2>
								<br />

								<br />
								<input type="submit" value="Submit">
								<input type="reset" value="Reset">

							</td>
							<%
								} else {
							%>
							<td align=center colspan=2>
								<div id="file">
									Select Image
									<input id="file" type='file' onchange="readURL(this);" />
								</div>
								<br />



							</td>
							<%
								}
							%>
						</tr>
						</div>
					</table>
				</center>
			</form>

		</div>
		<div id="print" align="center">
			<input type="button" value="Print" onclick="printDiv('userdetail')">
		</div>
		<div class="clearfix"></div>

		<script>

function openCity(evt, cityName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(cityName).style.display = "block";
	evt.currentTarget.className += " active";
}
</script>

		<script>
function myFunction() {
	var input, filter, table, tr, td, i;
	input = document.getElementById("search");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
</script>

		<script>
function myDocument(source) {
	alert(source)
	var name = document.getElementById("doc");
	var clone = name.cloneNode(true);
	clone.setAttribute('src', source);
	name.parentNode.replaceChild(clone, name)
}
</script>

		<script>
function printDiv(divName) {

	var printContents = document.getElementById(divName).innerHTML;
	var originalContents = document.body.innerHTML;
	document.body.innerHTML = printContents;
	window.print();
	document.body.innerHTML = originalContents;
}
</script>

		<script type="text/javascript">
function validate() {
	var name = document.forms["Aadhar"]["Name"];
	var dob = document.forms["Aadhar"]["DOB"];
	var father=document.forms["Aadhar"]["Father"]
	var sex = document.forms["Aadhar"]["sex"];
	var aadhar = document.forms["Aadhar"]["Aadharno"];
	var Pan_no = document.forms["Aadhar"]["Panno"];
	var date = document.forms["Aadhar"]["Date"];
	var Tamil = document.forms["Aadhar"]["m1"];
	var English = document.forms["Aadhar"]["m2"];
	var Maths = document.forms["Aadhar"]["m3"];
	var Science = document.forms["Aadhar"]["m4"];
	var Social = document.forms["Aadhar"]["m5"];
	var total=document.forms["Aadhar"]["m6"];
	var register=document.forms["Aadhar"]["reg"];

	if (address.value == "") {
		alert("Please enter your address.");
		address.focus();
		return false;
	}

	if (father.value == "") {
		alert("Please enter father's name");
		father.focus();
		return false;
	}

	if (dob.value == "") {
		alert("Please enter Date of Birth");
		dob.focus();
		return false;
	}

	if (sex.value == "") {
		alert("Please mention sex");
		sex.focus();
		return false;
	}
	if (aadhar.value == "") {
		alert("Please enter aadhar number");
		aadhar.focus();
		return false;
	}
	if (Pan_no.value == "" ) {
		alert("Please enter pan Number");
		Pan_no.focus();
		return false;
	}
	if (date.value == "") {
		alert("please enter valid date");
		date.focus();
		return false;
	}
	if (Tamil.value == "") {
		Tamil.focus();
		return false;
	}
	if (English.value == "") {
		English.focus();
		return false;
	}
	if (Maths.value == "") {
		Maths.focus();
		return false;
	}
	if (Science.value == "") {
		Science.focus();
		return false;
	}
	if (Social.value == "") {
		Social.focus();
		return false;
	}
	if (total.value == "") {
		total.focus();
		return false;
	}
	if (register.value == "") {
		alert("Please enter register number");
		register.focus();
		return false;
	}
	if (dob.value != "") {
		var d = dob.value;
		var res = d.split("-");
		var yyy = parseInt(res[0]) + 18;
		var mon = res[1] - 1;
		var date = res[2];
		alert(yyy);
		alert(mon);
		alert(date);
		if (new Date(yyy, mon, date) <= new Date()) {
			return true;
		} else {
			alert('Age is less than 18')
		}
		return false;
	}

	return true;
}</script>



	</body>
</html>

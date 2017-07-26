<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*,java.util.concurrent.TimeUnit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secured-T</title>

    <!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/display.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">

	<%
		if(session.getAttribute("LOGIN") != "TRUE") {
			response.sendRedirect("index.jsp");
		}
	%> 
</head>
<body class="monitoring">
<%
//Get Current time
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
Date currentTime = dateFormat.parse(dateFormat.format(date));

ArrayList<AssessmentInfoDetails> retrieveStartAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("startassessment");

if (retrieveStartAssessmentInfo != null) {
	for(AssessmentInfoDetails assessment:retrieveStartAssessmentInfo) { 
	//When lecturer click the refresh button in browser, it goes through the servlet
	if(session.getAttribute("REFRESH")!= null){ %>
		<script type="text/javascript">
	    	window.location.href = "RetrieveStartAssessmentInfoServlet?hiddenID=<%=assessment.getId()%>&examCode=<%=assessment.getExamCode()%>";
		</script>
	<%
	}
	else{    
		session.setAttribute("REFRESH","TRUE");
	}
	%>
	<span id="message"></span>
	<div id="startexamheader">
		<h2><%=assessment.getModuleName()%>
		<p id="systemtime">System Time: <%=dateFormat.format(date)%></p>
		</h2>
		<h2>Exam Code: <%=assessment.getExamCode()%></h2>
	</div>
	
 	<script type="text/javascript">
	setTimeout(function(){
		   window.location="RetrieveStartAssessmentInfoServlet?hiddenID=<%=assessment.getId()%>&examCode=<%=assessment.getExamCode()%>";
		}, 12000);
	</script>
<div id="allcomp">
	<ul class="list-inline" id="allcompimg">
<%
	}
}

ArrayList<StudentInfoDetails> retrieveStudentInfo = (ArrayList<StudentInfoDetails>)session.getAttribute("student");
boolean showAlert = true;
if (retrieveStudentInfo != null) {
	for(StudentInfoDetails student:retrieveStudentInfo) {
		Date timestamps = dateFormat.parse(student.getTimestamp()); //convert to Date
		long diff = currentTime.getTime()-timestamps.getTime(); //difference in time in milliseconds
		long diffsecs = TimeUnit.MILLISECONDS.toSeconds(diff); //convert to seconds%>
		<%
		if (diffsecs <= 8 && diffsecs >= 0 && student.getDisconnected() == 0) { %>
			<li id="compimg"><img src="images/L3.png" id="connected" alt="Connected" data-toggle="tooltip" data-placement="top" data-html="true" title="Admission Number: <%=student.getAdminNo()%><br>Table Number: <%=student.getTableNo()%><br>IP address: <%=student.getIpAddr()%><br>Port Number: <%=student.getPortNo()%><br>Timestamp: <%=student.getTimestamp()%>">
				<p id="ipaddress<%=student.getId()%>" class="ipaddress"><%=student.getIpAddr()%></p>
				<p id="subip<%=student.getId()%>" class="subip"></p>
			</li>
		
			<button id="startsskl<%=student.getId()%>" class="btn startsskl" onclick="startredirect(<%=student.getId()%>)" title="Start screen capture and keylogger">
				Start
				<span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
			</button>
			<button id="stopsskl<%=student.getId()%>" class="btn stopsskl" onclick="stopredirect(<%=student.getId()%>)" title="Stop screen capture and keylogger" disabled>Stop</button>
			
			<script type="text/javascript">
			$(document).ready(function(){
				if (<%=student.getSskl()%> == 1) {
				    $('#startsskl<%=student.getId()%>').prop('disabled', true);
				    $('#stopsskl<%=student.getId()%>').prop('disabled', false);
				    $("#message").addClass("message<%=student.getId()%>");
				    $(".message<%=student.getId()%>").append('<div class="alert alert-success" role="alert">Screen capture and keylogger started for <%=student.getAdminNo()%></div>')

				}
				else {
					$('#startsskl<%=student.getId()%>').prop('disabled', false);
				}

			});
			
			function startredirect(id) {
				window.location="UpdateStartSSKLStudentInfoServlet?hiddenID="+id;
			}
			
			function stopredirect(id) {
				window.location="UpdateStopSSKLStudentInfoServlet?hiddenID="+id;
			}
			
			var ip = $("#ipaddress<%=student.getId()%>").html();
			var subip = ip.substring(12);
			$("#subip<%=student.getId()%>").append(subip);

			</script>
		<%
		}
		else if (student.getCheating() == 1) { %>
			<li id="compimg"><img src="images/L1.png" id="cheating" alt="Cheating" data-toggle="tooltip" data-placement="top" data-html="true" title="Admission Number: <%=student.getAdminNo()%><br>Table Number: <%=student.getTableNo()%><br>IP address: <%=student.getIpAddr()%><br>Port Number: <%=student.getPortNo()%><br>Timestamp: <%=student.getTimestamp()%>">
				<p id="ipaddress<%=student.getId()%>" class="ipaddress"><%=student.getIpAddr()%></p>
				<p id="subip<%=student.getId()%>" class="subip"></p>
			</li>
			<script type="text/javascript">
				var ip = $("#ipaddress<%=student.getId()%>").html();
				var subip = ip.substring(12);
				$("#subip<%=student.getId()%>").append(subip);
			</script>
			<%
			if (showAlert == true) { %>
			<script type="text/javascript">
				alert ("1 or more student(s) is/are CHEATING!");
			</script>
			<%
				showAlert = false;
			}
		}
		else { %>
			<li id="compimg">
			<form action="DeleteStudentInfoServlet" onsubmit="return confirmDelete()">
				<input type="hidden" name="hiddenID" value="<%=student.getId()%>">
				<button class="btn btn-link" id="removecomp"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
			</form>
			
			<img src="images/L2.png" id="disconnected" alt="Disconnected" data-toggle="tooltip" data-placement="top" data-html="true" title="Admission Number: <%=student.getAdminNo()%><br>Table Number: <%=student.getTableNo()%><br>IP address: <%=student.getIpAddr()%><br>Port Number: <%=student.getPortNo()%><br>Timestamp: <%=student.getTimestamp()%>">
			<p id="ipaddress<%=student.getId()%>" class="ipaddress"><%=student.getIpAddr()%></p>
			<p id="subip<%=student.getId()%>" class="subip"></p>
			</li>
			<script type="text/javascript">
				var ip = $("#ipaddress<%=student.getId()%>").html();
				var subip = ip.substring(12);
				$("#subip<%=student.getId()%>").append(subip);
			</script>
		<%
			if (showAlert == true) { %>
			<script type="text/javascript">
				alert ("1 or more student(s) has/have DISCONNECTED!");
			</script>
			<%
				showAlert = false;
			}
		}
	}	
}

%>
	</ul>
</div>
<%
retrieveStartAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("startassessment");

if (retrieveStartAssessmentInfo != null) {
	for(AssessmentInfoDetails assessment:retrieveStartAssessmentInfo) { 

%>
<script type="text/javascript">
	function refreshParent() {
	    window.opener.location.href = "UpdateAssessmentInfoServlet?hiddenID=<%=assessment.getId()%>&staffID=<%=assessment.getLecturerID()%>";
	    window.close();
	}
</script>
<%
	}
}
%>
<form id="endass">
	<button class="btn btn-default" onclick="refreshParent()"> End Assessment</button>
</form>

<script type="text/javascript">
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});

function confirmDelete() {
	var result = confirm("Are you sure you want to remove this computer?");
	if (result) {
		$( this ).parent().remove();
		return true;
	}
	return false;
}    
</script>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>
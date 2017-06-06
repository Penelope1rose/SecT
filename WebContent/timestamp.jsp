<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieving Timestamp and Comparing with Current Time</title>
</head>
<body>
<%
//Get Current time
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
Date currentTime = dateFormat.parse(dateFormat.format(date));

ArrayList<StudentInfoDetails> retrieveTimestamp = (ArrayList<StudentInfoDetails>)session.getAttribute("timestamps");

if (retrieveTimestamp != null) {
	for(StudentInfoDetails timestamp:retrieveTimestamp) {
		Date timestamps = dateFormat.parse(timestamp.getTimestamp()); //convert to Date
		long diff = currentTime.getTime()-timestamps.getTime(); //difference in time
		long diffsecs = diff / 1000 % 60; //convert to seconds
		System.out.print(dateFormat.format(date) + "\t" + timestamp.getTimestamp());
		if (diffsecs <= 10) {
			System.out.println("\tCorrect");
		}
		else {
			System.out.println("\tWrong");
		}
	}	
}
else {
	out.println("No data");
}

%>
</body>
</html>
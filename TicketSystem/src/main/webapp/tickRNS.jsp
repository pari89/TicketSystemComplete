<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ticket no SE</title>
    <link rel = "stylesheet" href = "login.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>
<%
	if(session.getAttribute("usertype")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<body>
   <div class="toolbar">
    <form action="enduser.jsp" method="get">
        <button class="t-button">HOME</button>
    </form>
   </div>
   <div class="card">
    <h1>TICKET RAISED!</h1>
    <p align="center">Service Engineer not Assigned</p><br>
    <form action="viewTicket">
        <button class="b-button" >VIEW TICKETS</button>
    </form>
   </div>
</body>
</html>
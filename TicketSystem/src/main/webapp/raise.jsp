<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%
	if(session.getAttribute("usertype")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Raise Ticket</title>
    <link rel="stylesheet" href="close.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>

<body>
    <div class="toolbar">
        <form action="enduser.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <div class="card">
        <h1>RAISE TICKET</h1>
        <form action="Raise" method = post>
            <label for="ticketName" class="text1">Ticket name</label><br>
            <input class="t-box" type="text" id="ticketName" name="ticketName"><br><br>
            <label for="ticketType" class="text1">Ticket type</label><br>
            <select name="ticketType" id="ticketType" class="t-box">
	        	<option value="Finance">Finance</option>
	        	<option value="General">General</option>
	        	<option value="Technical">Technical</option>
        	</select>
            <br><br><br><br>
            <label for="ticketDes" class="text1">Ticket Description (within 10 words)</label><br>
            <input class="t-box" type="text" id="ticketDes" name="ticketDes"><br><br><br>
            <button class="b-button">SUBMIT</button>
        </form>
    
    </div>
</body>

</html>
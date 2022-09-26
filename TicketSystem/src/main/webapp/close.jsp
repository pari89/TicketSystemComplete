<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <title>Close Ticket</title>
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
        <h1>CLOSE TICKET</h1>
        <form action="CloseA" method=post>
            <label for="ticketName" class="text1">Ticket name</label>
            <select name="ticketName" id="ticketName" class="t-box">
	        	<c:forEach items="${Ticket}" var="s">
	            	<option value="${s}">${s}</option>
            	</c:forEach>
        	</select><br><br><br>
            <button class="b-button">SUBMIT</button>
        </form>
    
    </div>
</body>

</html>
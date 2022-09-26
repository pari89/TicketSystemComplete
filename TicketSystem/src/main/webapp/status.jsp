<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Status</title>
    <link rel="stylesheet" href="close.css">
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
        <form action="service.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <div class="card">
    	<h1>STATUS CHANGE</h1>
          <form action="ChangeStatus" method=post>
            <label for="status" class="text1">${ticketName} &nbsp;  status change to </label>
            <select name="status" id="status" class="t-box">
	        	<c:forEach items="${status}" var="s">
	            	<option value="${s}">${s}</option>
            	</c:forEach>
        	</select><br><br><br><br><br>
            <button class="b-button">SUBMIT</button>
        </form>
    </div>
</body>

</html>
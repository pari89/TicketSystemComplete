<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Open success</title>
    <link rel="stylesheet" href="viewticket.css">
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
        <h1>TICKET SUCESSFULLY OPENED</h1>
        <table>
            <tr>
              <th>Ticket Name</th>
              <th>Ticket Type</th>
              <th>End User raised</th>
              <th>Ticket Status</th>
              <th>Ticket Description</th>
            </tr>
            <tr>
            <c:forEach items="${Ticket}" var="s">
	            
	            		<td>${s}</td>
	            	
            </c:forEach>
            </tr>
          </table><br><br>
          
    </div>
</body>

</html>
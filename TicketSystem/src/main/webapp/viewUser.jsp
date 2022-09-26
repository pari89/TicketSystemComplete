<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Users</title>
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
        <form action="admin.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <div class="card">
        <h1>USERS</h1>
        <table>
            <tr>
              <th>System Code</th>
              <th>Username</th>
              <th>User type</th>
              <th>Service Engineer Type</th>
            </tr>
            <c:forEach items="${users}" var="s">
	            <tr>
	            	<c:forEach items="${s}" var="i">
	            		<td>${i}</td>
	            	</c:forEach>
	            </tr>
            </c:forEach>
          </table>
    </div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="portlet" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="admin.css">
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
        <form action="Logout" method="get">
            <button class="t-button">LOGOUT</button>
        </form>
    </div>
    <div class="card">
        <h1>Welcome ${username }!</h1>
        <h2>What do you feel like doing today?</h2><br>
        <div class="container-ele">

            <div class="l-card">
	            <form action="addAdmin.jsp" method=post>
	                <img class="image" src="images\admin.png" alt="admin">
	                <button name="usertp" class="b-button" > ADD <br> ADMIN</button>
                </form>
            </div>
            <div class="l-card">
	            <form action="addUser.jsp" method=post>
	                <img class="image" src="images\user.png" alt="admin">
	                <button name="usertp" class="b-button"> ADD <br> END USER</button>
                </form>
            </div>
            <div class="rn-card">
	            <form action="addService.jsp" method=post>
	                <img class="image" src="images\eng.png" alt="admin">
	                <button name="usertp" class="b-button"> ADD SERVICE ENGINEER</button>
                </form>
            </div>
            <div class="r-card">
	            <form action="viewUser" method=post>
	                <img class="image" src="images\view.png" alt="admin">
	                <button name="viewusers" class="b-button"> VIEW <br>USERS</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
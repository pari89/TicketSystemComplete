<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add End User</title>
    <link rel = "stylesheet" href = "addUser.css">
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
    <h1>ADD END USER </h1><br>
    <form action="addUser">
        <label for="username" class="text1">Username</label><br>
        <input class="t-box" type="text" id="username" name="username"><br><br><br>
        <label for="password" class="text1">Password</label><br>
        <input class="t-box" type="password" id="password" name="password"><br><br><br>
        <label for="username">Usertype</label>
        <select name="usertype" id="usertype" class="t-box">
        	<option value="EndUser">EndUser</option>
        </select>
        <br><br><br><button class="b-button">REGISTER</button>
        
    </form>
    
   </div>
</body>
</html>
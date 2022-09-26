<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login fail</title>
    <link rel = "stylesheet" href = "login.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>
<body>
   <div class="toolbar">
    <!--  <form action="admin.jsp" method="get">
        <button class="t-button">HOME</button>
    </form>-->
   </div>
   <div class="card">
    <h1>LOGIN FAILED!</h1>
    <p align="center">Wrong username or password!</p><br>
    <form action="admin.jsp">
        <button class="b-button" >LOGIN</button>
    </form>
   </div>
</body>
</html>
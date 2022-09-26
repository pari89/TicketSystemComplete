<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" type="image/x-icon" href="images\icon.png">
    <link rel = "stylesheet" href = "login.css">
</head>
<body>
   <div class="toolbar">
	    <form action="home.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
   </div>
   <div class="card">
    <h1>LOGIN</h1><br>
    <form action="Login">
        <label for="username" class="text1">Username</label><br>
        <input class="t-box" type="text" id="username" name="username"><br><br><br>
        <label for="password" class="text1">Password</label><br>
        <input class="t-box" type="password" id="password" name="password"><br><br><br><br>
        <button class="b-button" >LOGIN</button>
    </form>
    
   </div>
</body>
</html>
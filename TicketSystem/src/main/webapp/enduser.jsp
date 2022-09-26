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
    <title>End User</title>
    <link rel="stylesheet" href="user.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>
<body>
    <div class="toolbar">
        <form action="Logout" method="get">
            <button class="t-button">LOGOUT</button>
        </form>
    </div>
    <div class="card">
        <h1>Welcome ${username}!</h1>
        <h2>What do you feel like doing today?</h2><br>
        <div class="container-ele">
                <div class="l-card">
	                <form action = "raise.jsp" method=post>
	                    <img class="image" src="images\ticket.png" alt="admin">
	                    <button class="b-button"> RAISE <br> TICKETS</button>
	                 </form>
                </div>
                <div class="l-card">
	                <form action = "viewTicket" method=post>
	                    <img class="image" src="images\research.png" alt="admin">
	                    <button class="b-button"> VIEW <br> TICKETS</button>
	                </form>
                </div>
                <div class="r-card">
	                <form action = "Close" method=post>
	                    <img class="image" src="images\cancel.png" alt="admin">
	                    <button class="b-button"> CLOSE <br>TICKETS</button>
	                </form>
                </div>
        </div>
    </div>
</body>

</html>
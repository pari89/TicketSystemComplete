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
    <title>Service Engineer</title>
    <link rel="stylesheet" href="service.css">
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
            	<form action="Close" method=post>
	                <img class="image" src="images\closese.png" alt="admin">
	                <button class="b-button"> CLOSE<br> TICKETS</button>
                </form>
            </div>
            <div class="l-card">
	            <form action="SelectT" method=post>
	                <img class="image" src="images\change.png" alt="admin">
	                <button class="b-button"> CHANGE <br>STATUS</button>
                </form>
            </div>
            <div class="r-card">
	            <form action="viewTicket" method=post>
	                <img class="image" src="images\researchse.png" alt="admin">
	                <button class="b-button"> VIEW <br>TICKET</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
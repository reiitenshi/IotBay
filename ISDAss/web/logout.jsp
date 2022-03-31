<%-- 
    Document   : logout.jsp
    Created on : 28/03/2022, 5:44:37 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet"  href="stylesheets/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log Out Page</title>
    </head>
    <body>
        <header>
                <div class="nav-container">
                    <a href="index.jsp"><img src="images/IoT.png" alt="IOT Logo" class="small-logo"></a>
                    <nav>
                        <a href="index.jsp" class="button">Home</a>
                    </nav>
                </div>
        </header>
        <div class="body-container shadow-left shadow-right">
            <div id="logout-container">
                <h3 class="logout-text">You have successfully been logged out!</h3>
                <p class="logout-text">Click <a href="index.jsp">here</a> to return to the home page.</p>
            </div>
        </div>
    </body>
</html>

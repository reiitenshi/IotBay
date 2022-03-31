<%-- 
    Document   : index
    Created on : 26/03/2022, 12:48:33 PM
    Author     : User
--%>

<%@page import="isd.ass.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet"  href="stylesheets/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String phoneno = request.getParameter("phoneno");
            String saddress = request.getParameter("saddress");
            String zipcode = request.getParameter("zipcode");
            String state = request.getParameter("state");
            String loggedin = request.getParameter("loggedin");
            
            if(fname == null) {fname = "Guest";}
            
            User user = new User(fname, lname, email, password, dob, phoneno, saddress, zipcode, state);
            session.setAttribute("user", user);
        %>
    </head>
    <body>
        <header>
            <div class="nav-container">
                <%
                if(loggedin != null) {
                %>
                <a href="index.jsp"><img src="images/IoT.png" alt="IOT Logo" class="small-logo"></a>
                <nav>
                    <div>
                        <div>
                            <ul>
                                <li><p id="welcome">Welcome, ${user.fname}!</p></li>
                                <li><a href="logout.jsp" class="button">Log Out</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <% } else { %>
                <nav>
                    <div>
                        <form action="reglog.jsp">
                            <ul>
                                    <li><input type="submit" value="Register" name="register" class="button"></li>
                                    <li><input type="submit" value="Log In" name="login" class="button"></li>
                            </ul>
                        </form>
                    </div>
                </nav>
                <% } %>
            </div> 
        </header>
        <div class="body-container shadow-left shadow-right">

        <%
            if(loggedin != null) {
        %>
            
        <% } else { %>
        <div align="centre" >
            <img src="images/IoT.png" alt="IOT Logo" id="big-logo">
        </div>
        <% } %>
        </div>
    </body>
</html>

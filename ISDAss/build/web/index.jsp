<%-- 
    Document   : index
    Created on : 26/03/2022, 12:48:33 PM
    Author     : User
--%>

<%@page import="isd.ass.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            
            if(fname == null) {fname = "guest";}
            
            User user = new User(fname, lname, email, password, dob, phoneno, saddress, zipcode, state);
            session.setAttribute("user", user);
        %>
    </head>
    <body>
        <%
            if(loggedin != null) {
        %>
        <table>
            <tr><td><p>Welcome, ${user.fname}!</p></td><td><a href="logout.jsp">Log Out</a></td></tr>
        </table>
        <% } else { %>
        <form action="reglog.jsp">
            <input type="submit" value="Register" name="register">
            <input type="submit" value="Log In" name="login">
        </form>
        <% } %>
    </body>
</html>

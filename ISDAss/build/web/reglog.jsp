<%-- 
    Document   : reglog.jsp
    Created on : 26/03/2022, 1:38:50 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String register = request.getParameter("register");
            String login = request.getParameter("login");
            if(register != null && login == null) {
        %>
            <title>Register Page</title>
        <% } else { %>
            <title>Login Page</title>
        <% } %>
    </head>
    <body>
        <%
            if(register != null && login == null) {
        %>
        <form action="index.jsp" method="post">
            <table>
                <tr><td>First Name:</td><td><input type="text" name="fname" required></td><td>*</td></tr>
                <tr><td>Last Name:</td><td><input type="text" name="lname" required></td><td>*</td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" required></td><td>*</td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" required></td><td>*</td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required></td><td>*</td></tr>
                <tr><td>Phone Number:</td><td><input type="text" name="phoneno"></td></tr>
                <tr><td>Shipping Address:</td><td><input type="text" name="saddress"></td></tr>
                <tr><td>Postcode:</td><td><input type="text" name="zipcode"></td></tr>
                <tr><td>State:</td><td><input type="text" name="state"></td></tr>
            </table>
            <input type="submit" name="loggedin" value="Register">
        </form>
        <% } else { %>
        <form action="index.jsp" method="post">
            <table>
                <tr><td>Email:</td><td><input type="email" name="email"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
            </table>
            <input type="submit" name="loggedin" value="Log In">
        </form>
        <% } %>
    </body>
</html>

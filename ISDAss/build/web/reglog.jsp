<%-- 
    Document   : reglog.jsp
    Created on : 26/03/2022, 1:38:50 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet"  href="stylesheets/main.css">
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
        <header>
                <div class="nav-container">
                    <a href="index.jsp"><img src="images/IoT.png" alt="IOT Logo" class="small-logo"></a>
                    <nav>
                        <a href="index.jsp" class="button">Home</a>
                    </nav>
                </div>
        </header>
        <div class="body-container shadow-left shadow-right">
            <%
                if(register != null && login == null) {
            %>
            <form action="index.jsp" method="post">
                <table class="centre-table">
                    <tr><td class="table-header" colspan="3">Registration</td></tr>
                    <tr><td class="label">First Name:</td><td><input type="text" name="fname" required></td><td>*</td></tr>
                    <tr><td class="label">Last Name:</td><td><input type="text" name="lname" required></td><td>*</td></tr>
                    <tr><td class="label">Email:</td><td><input type="email" name="email" required></td><td>*</td></tr>
                    <tr><td class="label">Password:</td><td><input type="password" name="password" required></td><td>*</td></tr>
                    <tr><td class="label">Date of Birth:</td><td><input type="date" name="dob" required></td><td>*</td></tr>
                    <tr><td class="label">Phone Number:</td><td><input type="text" name="phoneno"></td></tr>
                    <tr><td class="label">Shipping Address:</td><td><input type="text" name="saddress"></td></tr>
                    <tr><td class="label">Postcode:</td><td><input type="text" name="zipcode"></td></tr>
                    <tr><td class="label">State:</td><td><input type="text" name="state"></td></tr>
                    <tr>
                        <td colspan="3">
                            <ul class="btns">
                                <li><input type="submit" name="loggedin" value="Register" align="centre" class="button"></li>
                                <li><a href="index.jsp" class="button">Cancel</a></li>
                            </ul>
                        </td>
                    </tr>
                    <tr><td id="mandatory" colspan="3">Fields marked with a (*) are mandatory!</td></tr>
                </table>
            </form>
            <% } else { %>
            <form action="index.jsp" method="post">
                <table class="centre-table">
                    <tr><td class="table-header" colspan="3">Login</td></tr>
                    <tr><td class="label">Email:</td><td><input type="email" name="email"></td></tr>
                    <tr><td class="label">Password:</td><td><input type="password" name="password"></td></tr>
                    <tr>
                        <td colspan="2">
                            <ul class="btns">
                                <li><input type="submit" name="loggedin" value="Login" align="centre" class="button"></li>
                                <li><a href="index.jsp" class="button">Cancel</a></li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </form>
            <% } %>
        </div>
    </body>
</html>

<!--  Author: 13722588  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>IOTBay Login</title>
    </head>
    <style>
        <%@ include file="css/main.css"%>
    </style>
    <body>
        <header>
            <div>
                <nav>
                    <ul>
                        <li>
                            <a href="index.jsp" class="nav-button">IOTBay</a>
                        </li>
                        <li style="float:right">
                            <a href="index.jsp" class="nav-button">Back</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
        <div>
            <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
                <table class="centre-table">
                    <tr>
                        <th colspan="3" class="table-header">Login</th>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Email:</label>
                        </td>
                        <td>
                            <input type="text" name="userEmail" required/>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Password:</label>
                        </td>
                        <td>
                            <input type="password" name="userPassword" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td class="btns" colspan="2">
                            <ul>
                                <li>
                                    <input type="submit" value="Submit" class="form-button">
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr><td id="mandatory" colspan="3">If you have failed to login, please come back to this page to try again.</td></tr>
                </table>
                
            </form>
        </div>
    </body>
</html>
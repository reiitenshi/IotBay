<!--  Author: 13722588  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IOTBAY Registration</title>
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
            <form action="<%=request.getContextPath()%>/UserServlet" method="post">
                <input type="hidden" name="userBtn" value="/userregister">
                <table class="centre-table">
                    <tr>
                        <th colspan="3" class="table-header">Register</th>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">First Name:</label>
                        </td>
                        <td>
                            <input type="text"value="<c:out value='${user.userFName}' />" name="userFName" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Last Name:</label>
                        </td>
                        <td>
                            <input type="text"value="<c:out value='${user.userLName}' />" name="userLName" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Email:</label>
                        </td>
                        <td>
                            <input type="email"value="<c:out value='${user.userEmail}' />" name="userEmail" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Password:</label>
                        </td>
                        <td>
                            <input type="password"value="<c:out value='${user.userPassword}' />" name="userPassword" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label">Address:</label>
                        </td>
                        <td>
                            <input type="text"value="<c:out value='${user.userAddress}' />" name="userAddress" required>
                        </td>
                        <td class="required">*</td>
                    </tr>
                    <tr>
                        <td class="btns" colspan="2">
                            <ul>
                                <li>
                                    <button type="submit" class="form-button">Sign Up</button>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr><td id="mandatory" colspan="3">Fields marked with a (*) are mandatory!</td></tr>
                </table>
            </form>
        </div>
    </body>
</html>
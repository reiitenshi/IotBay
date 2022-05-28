<!--  Author: 14279842  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>IOTBay Staff</title>
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
                        <li>
                            <a href="home.jsp" class="nav-button">Home</a>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/UserServlet" method="post" class="nav-form">
                                <input type="hidden" name="userBtn" value="/userlist">
                                <button type="submit" class="nav-button">User</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/StaffServlet" method="post" class="nav-form">
                                <input type="hidden" name="staffBtn" value="/stalist">
                                <button type="submit" class="nav-button" id="active">Staff</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/PaymentServlet" method="post" class="nav-form">
                                <input type="hidden" name="paymentBtn" value="/paylist">
                                <button type="submit" class="nav-button">Payment</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/OrderServlet" method="post" class="nav-form">
                                <input type="hidden" name="orderBtn" value="/ordlist">
                                <button type="submit" class="nav-button">Orders</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/DeviceServlet" method="post" class="nav-form">
                                <input type="hidden" name="deviceBtn" value="/devlist">
                                <button type="submit" class="nav-button">Devices</button>
                            </form>
                        </li>
                        <li style="float:right">
                            <a href="index.jsp" class="nav-button">Logout</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
        <div>
            <div>
                <p class="table-header">List of Staff</p>
                <table class="centre-list">
                    <tr>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/StaffServlet" method="POST">
                                        <div>
                                            <input type="hidden" name="staffBtn" value="/stasearch">
                                            <input type="text"  class="form-input" name="searchId" placeholder="Search By Name">
                                            <input type="text"  class="form-input" name="searchDate" placeholder="Search By Position">
                                            <button type="submit" value="search" class="form-button">Search</button>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/StaffServlet" method="post">
                                        <input type="hidden" name="staffBtn" value="/stanew">
                                        <button type="submit" class="form-button">New Staff</button>
                                    </form>
                                </li>
                                <li>
                                    <form action="<%=request.getContextPath()%>/StaffServlet" method="post">
                                        <input type="hidden" name="staffBtn" value="/stalist">
                                        <button type="submit" class="form-button">Refresh List</button>
                                    </form>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td class="info-head">Email</td>
                        <td class="info-head">Name</td>
                        <td class="info-head">Position</td>
                        <td class="info-head">Address</td>
                        <td class="info-head">Status</td>
                    </tr>
                    <c:forEach var="staff" items="${staffList}">
                        <tr>
                            <td class="info"><c:out value="${staff.staffEmail}" /></td>
                            <td class="info"><c:out value="${staff.staffName}" /></td>
                            <td class="info"><c:out value="${staff.staffPosition}" /></td>
                            <td class="info"><c:out value="${staff.staffAddress}" /></td>
                            <td class="info"><c:out value="${staff.staffStatus}" /></td>
                            <td>
                                <ul class="btns">
                                    <li>
                                        <form action="<%=request.getContextPath()%>/StaffServlet" method="post">
                                            <input type="hidden" name="staffEmail" value="${staff.staffEmail}">
                                            <input type="hidden" name="staffBtn" value="/staedit">
                                            <button type="submit" class="form-button">Edit</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="<%=request.getContextPath()%>/StaffServlet" method="post">
                                            <input type="hidden" name="staffEmail" value="${staff.staffEmail}">
                                            <input type="hidden" name="staffBtn" value="/stadelete">
                                            <button type="submit" class="form-button">Delete</button>
                                        </form>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>

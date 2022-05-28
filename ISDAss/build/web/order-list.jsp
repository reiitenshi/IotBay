<!--  Author: 14270375  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>IOTBay Orders</title>
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
                                <button type="submit" class="nav-button">Staff</button>
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
                                <button type="submit" class="nav-button" id="active">Orders</button>
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
                <p class="table-header">List of Orders</p>
                <table class="centre-list">
                    <tr>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/OrderServlet" method="POST">
                                        <div>
                                            <input type="hidden" name="orderBtn" value="/ordsearch">
                                            <input type="text" class="form-input" name="searchId" placeholder="Search By ID">
                                            <input type="text" class="form-input" name="searchDate" placeholder="Search By Date">
                                            <button type="submit" value="search" class="form-button">Search</button>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                                        <input type="hidden" name="orderBtn" value="/ordnew">
                                        <button type="submit" class="form-button">New Order</button>
                                    </form>
                                </li>
                                <li>
                                    <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                                        <input type="hidden" name="orderBtn" value="/ordlist">
                                        <button type="submit" class="form-button">Refresh List</button>
                                    </form>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td class="info-head">Order ID</td>
                        <td class="info-head">Device ID</td>
                        <td class="info-head">Quantity</td>
                        <td class="info-head">Submitted</td>
                        <td class="info-head">Order Date</td>
                    </tr>
                    <c:forEach var="order" items="${orderList}">
                        <tr>
                            <td class="info"><c:out value="${order.orderId}" /></td>
                            <td class="info"><c:out value="${order.deviceId}" /></td>
                            <td class="info"><c:out value="${order.quantity}" /></td>
                            <td class="info"><c:out value="${order.submitted}" /></td>
                            <td class="info"><c:out value="${order.orderDate}" /></td>
                            <td>
                                <ul class="btns">
                                    <li>
                                        <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                                            <input type="hidden" name="orderId" value="${order.orderId}">
                                            <input type="hidden" name="orderBtn" value="/ordedit">
                                            <button type="submit" class="form-button">Edit</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                                            <input type="hidden" name="orderId" value="${order.orderId}">
                                            <input type="hidden" name="orderBtn" value="/orddelete">
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
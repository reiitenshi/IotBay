<!--  Author: 13900509  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Payment Management Application</title>
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
                                <button type="submit" class="nav-button" id="active">Payment</button>
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
                <p class="table-header">List of Payments</p>
                <table class="centre-list">
                    <tr>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/PaymentServlet" method="POST">
                                        <div>
                                            <input type="hidden" name="paymentBtn" value="/paysearch">
                                            <input type="text" class="form-input" name="searchId" placeholder="Search By ID">
                                            <input type="text" class="form-input" name="searchEmail" placeholder="Search By Email">
                                            <button type="submit" value="search" class="form-button">Search</button>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                                        <input type="hidden" name="paymentBtn" value="/paynew">
                                        <button type="submit" class="form-button">New Payment</button>
                                    </form>
                                </li>
                                <li>
                                    <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                                        <input type="hidden" name="paymentBtn" value="/paylist">
                                        <button type="submit" class="form-button">Refresh List</button>
                                    </form>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td class="info-head">Payment ID</td>
                        <td class="info-head">User Email</td>
                        <td class="info-head">Card Number</td>
                        <td class="info-head">Card CVV</td>
                        <td class="info-head">Card Name</td>
                    </tr>
                    <c:forEach var="payment" items="${paymentList}">
                        <tr>
                            <td class="info"><c:out value="${payment.paymentId}" /></td>
                            <td class="info"><c:out value="${payment.userEmail}" /></td>
                            <td class="info"><c:out value="${payment.cardNo}" /></td>
                            <td class="info"><c:out value="${payment.cardCVV}" /></td>
                            <td class="info"><c:out value="${payment.cardName}" /></td>
                            <td>
                                <ul class="btns">
                                    <li>
                                        <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                                            <input type="hidden" name="paymentId" value="${payment.paymentId}">
                                            <input type="hidden" name="paymentBtn" value="/payedit">
                                            <button type="submit" class="form-button">Edit</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                                            <input type="hidden" name="paymentId" value="${payment.paymentId}">
                                            <input type="hidden" name="paymentBtn" value="/paydelete">
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

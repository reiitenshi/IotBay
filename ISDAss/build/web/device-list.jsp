<!--  Author: 14323808  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
    <title>IOTBay Devices</title>
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
                                <button type="submit" class="nav-button">Orders</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/DeviceServlet" method="post" class="nav-form">
                                <input type="hidden" name="deviceBtn" value="/devlist">
                                <button type="submit" class="nav-button" id="active">Devices</button>
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
                <p class="table-header">List of Devices</p>
                <table class="centre-list">
                    <tr>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/DeviceServlet" method="POST">
                                        <div>
                                            <input type="hidden" name="deviceBtn" value="/devsearch">
                                            <input type="text" class="form-input" name="searchName" placeholder="Search By Name">
                                            <input type="text" class="form-input" name="searchBrand" placeholder="Search By Brand">
                                            <input type="text" class="form-input" name="searchType" placeholder="Search By Type">
                                            <button type="submit" value="search" class="form-button">Search</button>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <ul class="btns">
                                <li>
                                    <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                                        <input type="hidden" name="deviceBtn" value="/devnew">
                                        <button type="submit" class="form-button">New Device</button>
                                    </form>
                                </li>
                                <li>
                                    <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                                        <input type="hidden" name="deviceBtn" value="/devlist">
                                        <button type="submit" class="form-button">Refresh List</button>
                                    </form>
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td class="info-head">ID</td>
                        <td class="info-head">Device Name</td>
                        <td class="info-head">Unit Price</td>
                        <td class="info-head">Stock On Hand</td>
                        <td class="info-head">Brand</td>
                        <td class="info-head">Type</td>
                    </tr>
                    <c:forEach var="device" items="${deviceList}">
                        <tr>
                            <td class="info"><c:out value="${device.deviceId}" /></td>
                            <td class="info"><c:out value="${device.deviceName}" /></td>
                            <td class="info"><c:out value="${device.unitPrice}" /></td>
                            <td class="info"><c:out value="${device.deviceStock}" /></td>
                            <td class="info"><c:out value="${device.deviceBrand}" /></td>
                            <td class="info"><c:out value="${device.deviceType}" /></td>
                            <td>
                                <ul class="btns">
                                    <li>
                                        <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                                            <input type="hidden" name="deviceId" value="${device.deviceId}">
                                            <input type="hidden" name="deviceBtn" value="/devedit">
                                            <button type="submit" class="form-button">Edit</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                                            <input type="hidden" name="deviceId" value="${device.deviceId}">
                                            <input type="hidden" name="deviceBtn" value="/devdelete">
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

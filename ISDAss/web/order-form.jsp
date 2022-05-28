<!--  Author: 14270375  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <c:if test="${order != null}">
            <title>IOTBay Edit Order</title>
        </c:if>
        <c:if test="${order == null}">
            <title>IOTBay New Order</title>
        </c:if>
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
                <div>
                    <c:if test="${order != null}">
                            <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                            <input type="hidden" name="orderBtn" value="/ordupdate">
                    </c:if>
                    <c:if test="${order == null}">
                            <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                            <input type="hidden" name="orderBtn" value="/ordinsert">
                    </c:if>
                        <table class="centre-table">
                            <caption>
                                <h2 class="table-header">
                                    <c:if test="${order != null}">
                                        Edit Order
                                    </c:if>
                                    <c:if test="${order == null}">
                                        Place Order
                                    </c:if>
                                </h2>
                            </caption>
                            <c:if test="${order != null}">
                                <input type="hidden" name="orderId" value="<c:out value='${order.orderId}' />" />
                            </c:if>
                            <tr>
                                <td>
                                    <label>Device ID:</label>
                                </td>
                                <td>
                                    <input type="text" value="<c:out value='${order.deviceId}' />" name="deviceId" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Quantity:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${order.quantity}' />" name="quantity" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Submitted:</label>
                                </td>
                                <td>
                                   <input type="text"value="<c:out value='${order.submitted}' />" name="submitted" required="required"> 
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Order Date:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${order.orderDate}' />" name="orderDate" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td class="btns" colspan="2">
                                    <ul style="float:right">
                                        <li>
                                            <button type="submit" class="form-button">Save</button>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr><td id="mandatory" colspan="3">Fields marked with a (*) are mandatory!</td></tr>

                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

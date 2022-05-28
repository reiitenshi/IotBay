<!--  Author: 13900509  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <c:if test="${payment != null}">
            <title>IOTBay Edit Payment</title>
        </c:if>
        <c:if test="${payment == null}">
            <title>IOTBay New Payment</title>
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
                    <c:if test="${payment != null}">
                        <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                        <input type="hidden" name="paymentBtn" value="/payupdate">
                    </c:if>
                    <c:if test="${payment == null}">
                        <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                        <input type="hidden" name="paymentBtn" value="/payinsert">
                    </c:if>
                        <table class="centre-table">
                            <caption>
                                <h2 class="table-header">
                                    <c:if test="${payment != null}">
                                        Edit Payment Details
                                    </c:if>
                                    <c:if test="${payment == null}">
                                        New Payment Details
                                    </c:if>
                                </h2>
                            </caption>
                            <c:if test="${payment != null}">
                                    <input type="hidden" name="paymentId" value="<c:out value='${payment.paymentId}' />" />
                            </c:if>
                            <tr>
                                <td>
                                    <label>User Email:</label>
                                </td>
                                <td>
                                    <input type="text" value="<c:out value='${payment.userEmail}' />" name="userEmail" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Card Number:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${payment.cardNo}' />" name="cardNo" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                   <label>Card CVV:</label> 
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${payment.cardCVV}' />" name="cardCVV" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                   <label>Card Name:</label> 
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${payment.cardName}' />" name="cardName" required="required">
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

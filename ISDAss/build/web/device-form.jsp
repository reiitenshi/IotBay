<!--  Author: 14323808  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <c:if test="${device != null}">
            <title>IOTBay Edit Device</title>
        </c:if>
        <c:if test="${device == null}">
            <title>IOTBay New Device</title>
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
                    <c:if test="${device != null}">
                            <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                            <input type="hidden" name="deviceBtn" value="/devupdate">
                    </c:if>
                    <c:if test="${device == null}">
                            <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
                            <input type="hidden" name="deviceBtn" value="/devinsert">
                    </c:if>
                        <table class="centre-table">
                            <caption>
                                <h2 class="table-header">
                                    <c:if test="${device != null}">
                                        Edit Device
                                    </c:if>
                                    <c:if test="${device == null}">
                                        Add New Device
                                    </c:if>
                                </h2>
                            </caption>
                            <c:if test="${device != null}">
                                <input type="hidden" name="deviceId" value="<c:out value='${device.deviceId}' />" />
                            </c:if>
                            <tr>
                                <td>
                                    <label>Device Name:</label> 
                                </td>
                                <td>
                                    <input type="text" value="<c:out value='${device.deviceName}' />" name="deviceName" required="required">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Unit Price:</label> 
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${device.unitPrice}' />" name="unitPrice">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Device Stock:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${device.deviceStock}' />" name="deviceStock">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Device Brand:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${device.deviceBrand}' />" name="deviceBrand">
                                </td>
                                <td class="required">*</td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Device Type:</label>
                                </td>
                                <td>
                                    <input type="text"value="<c:out value='${device.deviceType}' />" name="deviceType">
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

<!--  Author: 14323808  -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IOTBay Home</title>
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
                            <a href="home.jsp" class="nav-button" id="active">Home</a>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/UserServlet" method="post">
                                <input type="hidden" name="userBtn" value="/userlist">
                                <button type="submit" class="nav-button">User</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/StaffServlet" method="post">
                                <input type="hidden" name="staffBtn" value="/stalist">
                                <button type="submit" class="nav-button">Staff</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/PaymentServlet" method="post">
                                <input type="hidden" name="paymentBtn" value="/paylist">
                                <button type="submit" class="nav-button">Payment</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
                                <input type="hidden" name="orderBtn" value="/ordlist">
                                <button type="submit" class="nav-button">Orders</button>
                            </form>
                        </li>
                        <li>
                            <form action="<%=request.getContextPath()%>/DeviceServlet" method="post">
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
            <p class="table-header">You have logged in successfully!</p>
        </div>
    </body>
</html>
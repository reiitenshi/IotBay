/*
 *  Author: 14270375
 */
package isd.ass.controller;

import isd.ass.dao.OrderDao;
import isd.ass.model.Order;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {
    private OrderDao orderDao;
            
    public OrderServlet() {
        this.orderDao = new OrderDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = "/ordlist";
        if(request.getParameter("orderBtn") != null) action = request.getParameter("orderBtn");
        
        switch(action) {
            case "/ordnew":
                showNewForm(request, response);
                break;
            case "/ordinsert":
                try {
                    insertOrder(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/orddelete":
                try {
                    deleteOrder(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/ordedit":
                try {
                    showEditForm(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/ordupdate":
                try {
                    updateOrder(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/ordsearch":
                try {
                    searchOrders(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            default:
                try {
                    listOrders(request, response);
                } catch (Exception e) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Boolean submitted = Boolean.parseBoolean(request.getParameter("submitted"));
        String orderDate = request.getParameter("orderDate");
        Order newOrder = new Order(deviceId, quantity, submitted, orderDate);
        orderDao.insertOrder(newOrder);
        response.sendRedirect("OrderServlet");
    }
    
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderDao.deleteOrder(orderId);
        response.sendRedirect("OrderServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order existingOrder = orderDao.selectOrderById(orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-form.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);
    }
    
    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Boolean submitted = Boolean.parseBoolean(request.getParameter("submitted"));
        String orderDate = request.getParameter("orderDate");
        Order updatedOrder = new Order(orderId, deviceId, quantity, submitted, orderDate);
        orderDao.updateOrder(updatedOrder);
        response.sendRedirect("OrderServlet");
    }
    
    private void listOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Order> orderList = orderDao.selectAllOrders();
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchOrders (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchId = request.getParameter("searchId");
        String searchDate = request.getParameter("searchDate");
        List<Order> orderList = orderDao.searchOrderList(searchId, searchDate);
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
        dispatcher.forward(request, response);
    }
}

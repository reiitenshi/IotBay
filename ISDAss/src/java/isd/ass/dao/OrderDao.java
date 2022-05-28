/*
 *  Author: 14270375
 */
package isd.ass.dao;

import isd.ass.model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDao {
    
    private final String jdbcURL = "jdbc:derby://localhost:1527/IOTBAYDB";
    private final String jdbcUsername = "staff";
    private final String jdbcPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String INSERT_ORDERS_SQL = "INSERT INTO orders" + " (deviceId, quantity, submitted, orderDate) VALUES " + " (?, ?, ?, ?)";
    private static final String SELECT_ORDER_BY_ID = "select * from orders where orderId = ?";
    private static final String SELECT_ALL_ORDERS = "select * from orders";
    private static final String DELETE_ORDERS_SQL = "delete from orders where orderId =?";
    private static final String UPDATE_ORDERS_SQL = "update orders set deviceId = ?, quantity = ?, submitted = ?, orderDate = ? where orderId = ?";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    
    // Create/Insert Device
    public void insertOrder(Order order) {
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_ORDERS_SQL);){
            statement.setInt(1, order.getDeviceId());
            statement.setInt(2, order.getQuantity());
            statement.setBoolean(3, order.isSubmitted());
            statement.setString(4, order.getOrderDate());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Update Device by ID
    public boolean updateOrder(Order order) {
        boolean rowUpdated = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERS_SQL);){
            statement.setInt(1, order.getDeviceId());
            statement.setInt(2, order.getQuantity());
            statement.setBoolean(3, order.isSubmitted());
            statement.setString(4, order.getOrderDate());
            statement.setInt(5, order.getOrderId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }
    
    // Select Device by ID
    public Order selectOrderById(int orderId) {
        Order order = null;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID);){
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                int deviceId = rs.getInt("deviceId");
                int quantity = rs.getInt("quantity");
                boolean submitted = rs.getBoolean("submitted");
                String orderDate = rs.getString("orderDate");
                order = new Order(orderId, deviceId, quantity, submitted, orderDate);
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return order;
    }
    
    // Search Device List -- WIP
    public List<Order> searchOrderList(String searchId, String searchDate) {
        List<Order> orders = new ArrayList<>();
        String search;
        if(!searchId.equals("") && !searchDate.equals("")) {
            search = "select * from orders where orderId = " + searchId + " AND orderDate like '" + searchDate  + "%'";
        } else if (!searchId.equals("") && searchDate.equals("")) {
            search = "select * from orders where orderId = " + searchId;
        } else if (searchId.equals("") && !searchDate.equals("")) {
            search = "select * from orders where orderDate like '" + searchDate  + "%'";
        } else {
            search = "select * from orders";
        }
        try(Connection connection = getConnection();){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(search);
            
            while(rs.next()) {
                int orderId = rs.getInt("orderId");
                int deviceId = rs.getInt("deviceId");
                int quantity = rs.getInt("quantity");
                boolean submitted = rs.getBoolean("submitted");
                String orderDate = rs.getString("orderDate");
                orders.add(new Order(orderId, deviceId, quantity, submitted, orderDate));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return orders;
    }
    
    // Select Devices
    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDERS);){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                int orderId = rs.getInt("orderId");
                int deviceId = rs.getInt("deviceId");
                int quantity = rs.getInt("quantity");
                boolean submitted = rs.getBoolean("submitted");
                String orderDate = rs.getString("orderDate");
                orders.add(new Order(orderId, deviceId, quantity, submitted, orderDate));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return orders;
    }
    
    // Delete Device by ID
    public boolean deleteOrder(int orderId) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_ORDERS_SQL);){
            statement.setInt(1, orderId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowDeleted;
    }   
}
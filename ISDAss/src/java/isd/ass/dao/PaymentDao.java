/*
 *  Author: 13900509
 */
package isd.ass.dao;

import isd.ass.model.Payment;
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

public class PaymentDao {
    
    private final String jdbcURL = "jdbc:derby://localhost:1527/IOTBAYDB";
    private final String jdbcUsername = "staff";
    private final String jdbcPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String INSERT_PAYMENTS_SQL = "INSERT INTO payments" + " (userEmail, cardNo, cardCVV, cardName) VALUES " + " (?, ?, ?, ?)";
    private static final String SELECT_PAYMENT_BY_ID = "select * from payments where paymentId = ?";
    private static final String SELECT_ALL_PAYMENTS = "select * from payments";
    private static final String DELETE_PAYMENTS_SQL = "delete from payments where paymentId =?";
    private static final String UPDATE_PAYMENTS_SQL = "update payments set userEmail = ?, cardNo = ?, cardCVV = ?, cardName = ? where paymentId = ?";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    
    // Create/Insert Payment
    public void insertPayment(Payment payment) {
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENTS_SQL);){
            statement.setString(1, payment.getUserEmail());
            statement.setString(2, payment.getCardNo());
            statement.setString(3, payment.getCardCVV());
            statement.setString(4, payment.getCardName());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Update Payment by ID
    public boolean updatePayment(Payment payment) {
        boolean rowUpdated = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENTS_SQL);){
            statement.setString(1, payment.getUserEmail());
            statement.setString(2, payment.getCardNo());
            statement.setString(3, payment.getCardCVV());
            statement.setString(4, payment.getCardName());
            statement.setInt(5, payment.getPaymentId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }
    
    // Select Payment by ID
    public Payment selectPaymentById(int paymentId) {
        Payment payment = null;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PAYMENT_BY_ID);){
            statement.setInt(1, paymentId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String userEmail = rs.getString("userEmail");
                String cardNo = rs.getString("cardNo");
                String cardCVV = rs.getString("cardCVV");
                String cardName = rs.getString("cardName");
                payment = new Payment(paymentId, userEmail, cardNo, cardCVV, cardName);
            }
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return payment;
    }
    
    // Search Payment List -- WIP
    public List<Payment> searchPaymentList(String searchId, String searchName) {
        List<Payment> payments = new ArrayList<>();
        String search;
        if(!searchId.equals("") && !searchName.equals("")) {
            search = "select * from orders where orderId = " + searchId + " AND lower(orderDate) like lower('" + searchName  + "%')";
        } else if (!searchId.equals("") && searchName.equals("")) {
            search = "select * from payments where paymentId = " + searchId;
        } else if (searchId.equals("") && !searchName.equals("")) {
            search = "select * from payments where lower(userEmail) like lower('" + searchName + "%')";
        } else {
            search = "select * from payments";
        }
        try(Connection connection = getConnection();){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(search);
            
            while(rs.next()) {
                int paymentId = rs.getInt("paymentId");
                String userEmail = rs.getString("userEmail");
                String cardNo = rs.getString("cardNo");
                String cardCVV = rs.getString("cardCVV");
                String cardName = rs.getString("cardName");
                payments.add(new Payment(paymentId, userEmail, cardNo, cardCVV, cardName));
            }
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return payments;
    }
    
    // Select Payments
    public List<Payment> selectAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PAYMENTS);){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                int paymentId = rs.getInt("paymentId");
                String userEmail = rs.getString("userEmail");
                String cardNo = rs.getString("cardNo");
                String cardCVV = rs.getString("cardCVV");
                String cardName = rs.getString("cardName");
                payments.add(new Payment(paymentId, userEmail, cardNo, cardCVV, cardName));
            }
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return payments;
    }
    
    // Delete Payment by ID
    public boolean deletePayment(int paymentId) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENTS_SQL);){
            statement.setInt(1, paymentId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowDeleted;
    }   
}

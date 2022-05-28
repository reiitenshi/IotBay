/*
 *  Author: 1398360
 */
package isd.ass.dao;

import isd.ass.model.User;
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

public class UserDao {
    
    private final String jdbcURL = "jdbc:derby://localhost:1527/IOTBAYDB";
    private final String jdbcUsername = "staff";
    private final String jdbcPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (userEmail, userPassword, userFName, userLName, userAddress) VALUES " + " (?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_EMAIL = "select * from users where userEmail = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where userEmail =?";
    private static final String UPDATE_USERS_SQL = "update users set userEmail = ?, userPassword = ?, userFName = ?, userLName = ?, userAddress = ? where userEmail = ?";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    
    // Create/Insert User
    public void insertUser(User user) {
        System.out.println(user.getUserPassword());
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);){
            statement.setString(1, user.getUserEmail());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getUserFName());
            statement.setString(4, user.getUserLName());
            statement.setString(5, user.getUserAddress());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Update User by Email
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
            statement.setString(1, user.getUserEmail());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getUserFName());
            statement.setString(4, user.getUserLName());
            statement.setString(5, user.getUserAddress());
            statement.setString(6, user.getUserEmail());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }
    
    // Select User by Email
    public User selectUserByEmail(String userEmail) {
        User user = null;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_EMAIL);){
            statement.setString(1, userEmail);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String userPassword = rs.getString("userPassword");
                String userFName = rs.getString("userFName");
                String userLName = rs.getString("userLName");
                String userAddress = rs.getString("userAddress");
                user = new User(userEmail, userPassword, userFName, userLName, userAddress);
            }
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    
    // Search User List
    public List<User> searchUserList(String searchUserFName, String searchUserLName, String searchUserEmail) {
        List<User> users = new ArrayList<>();
        String search;
        if(!searchUserFName.equals("") && searchUserLName.equals("") && searchUserEmail.equals("")) {
            search = "select * from users where lower(userFName) like lower('" + searchUserFName + "%')";
        } else if(searchUserFName.equals("") && !searchUserLName.equals("") && searchUserEmail.equals("")) {
            search = "select * from users where lower(userLName) like lower('" + searchUserLName + "%')";
        } else if(searchUserFName.equals("") && searchUserLName.equals("") && !searchUserEmail.equals("")) {
            search = "select * from users where lower(userEmail) like lower('" + searchUserEmail + "%')";
        } else if(!searchUserFName.equals("") && !searchUserLName.equals("") && searchUserEmail.equals("")) {
            search = "select * from users where lower(userFName) like lower('" + searchUserFName + "%') && where lower(userLName) like lower('" + searchUserLName + "%')";
        } else if(!searchUserFName.equals("") && searchUserLName.equals("") && !searchUserEmail.equals("")) {
            search = "select * from users where lower(userFName) like lower('" + searchUserFName + "%') && where lower(userEmail) like lower('" + searchUserEmail + "%')";
        } else if(searchUserFName.equals("") && !searchUserLName.equals("") && !searchUserEmail.equals("")) {
            search = "select * from devices where lower(userLName) like lower('" + searchUserLName + "%') && where lower(userEmail) like lower('" + searchUserEmail + "%')";
        } else if(!searchUserFName.equals("") && !searchUserLName.equals("") && !searchUserEmail.equals("")) {
            search = "select * from devices where lower(userFName) like lower('" + searchUserFName + "%') && lower(userLName) like lower('" + searchUserLName + "%') && where lower(userEmail) like lower('" + searchUserEmail + "%')";
        } else {
            search = "select * from users";
        }
        try(Connection connection = getConnection();){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(search);
            
            while(rs.next()) {
                String userEmail = rs.getString("userEmail");
                String userPassword = rs.getString("userPassword");
                String userFName = rs.getString("userFName");
                String userLName = rs.getString("userLName");
                String userAddress = rs.getString("userAddress");
                users.add(new User(userEmail, userPassword, userFName, userLName, userAddress));
            }
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }
    
    // Select Users
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS);){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String userEmail = rs.getString("userEmail");
                String userPassword = rs.getString("userPassword");
                String userFName = rs.getString("userFName");
                String userLName = rs.getString("userLName");
                String userAddress = rs.getString("userAddress");
                users.add(new User(userEmail, userPassword, userFName, userLName, userAddress));
            }
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }
    
    // Delete Device by Email
    public boolean deleteUser(String userEmail) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
            statement.setString(1, userEmail);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowDeleted;
    }   
}
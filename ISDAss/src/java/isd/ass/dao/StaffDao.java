/*
 *  Author: 14279842
 */
package isd.ass.dao;

import isd.ass.model.Staff;
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

public class StaffDao {
    
    private final String jdbcURL = "jdbc:derby://localhost:1527/IOTBAYDB";
    private final String jdbcUsername = "staff";
    private final String jdbcPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String INSERT_STAFF_SQL = "INSERT INTO staff" + " (staffEmail, staffName, staffPosition, staffAddress, staffStatus) VALUES " + " (?, ?, ?, ?, ?)";
    private static final String SELECT_STAFF_BY_EMAIL = "select * from staff where staffEmail = ?";
    private static final String SELECT_ALL_STAFF = "select * from staff";
    private static final String DELETE_STAFF_SQL = "delete from staff where staffEmail =?";
    private static final String UPDATE_STAFF_SQL = "update staff set staffEmail = ?, staffName = ?, staffPosition = ?, staffAddress = ?, staffStatus = ? where staffEmail = ?";
    
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
    public void insertStaff(Staff staff) {
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_STAFF_SQL);){
            statement.setString(1, staff.getStaffEmail());
            statement.setString(2, staff.getStaffName());
            statement.setString(3, staff.getStaffPosition());
            statement.setString(4, staff.getStaffAddress());
            statement.setString(5, staff.getStaffStatus());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Update Device by ID
    public boolean updateStaff(Staff staff) {
        boolean rowUpdated = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF_SQL);){
            statement.setString(1, staff.getStaffEmail());
            statement.setString(2, staff.getStaffName());
            statement.setString(3, staff.getStaffPosition());
            statement.setString(4, staff.getStaffAddress());
            statement.setString(5, staff.getStaffStatus());
            statement.setString(6, staff.getStaffEmail());
            statement.executeUpdate();
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }
    
    // Select Device by ID
    public Staff selectStaffByEmail(String staffEmail) {
        Staff staff = null;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_STAFF_BY_EMAIL);){
            statement.setString(1, staffEmail);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                staffEmail = rs.getString("staffEmail");
                String staffName = rs.getString("staffName");
                String staffPosition = rs.getString("staffPosition");
                String staffAddress = rs.getString("staffAddress");
                String staffStatus = rs.getString("staffStatus");
                staff = new Staff(staffEmail, staffName, staffPosition, staffAddress, staffStatus);
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return staff;
    }
    
    // Search Device List -- WIP
    public List<Staff> searchStaffList(String searchName, String searchPosition) {
        List<Staff> staff = new ArrayList<>();
        String search;
        if(!searchName.equals("") && !searchPosition.equals("")) {
            search = "select * from staff where lower(staffName) like lower('" + searchName + "%') AND lower(staffPosition) like lower('" + searchPosition  + "%')";
        } else if (!searchName.equals("") && searchPosition.equals("")) {
            search = "select * from staff where lower(staffName) like lower('" + searchName + "%')";
        } else if (searchName.equals("") && !searchPosition.equals("")) {
            search = "select * from staff where lower(staffPosition) like lower('" + searchPosition + "%')";
        } else {
            search = "select * from staffs";
        }
        try(Connection connection = getConnection();){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(search);
            
            while(rs.next()) {
                String staffEmail = rs.getString("staffEmail");
                String staffName = rs.getString("staffName");
                String staffPosition = rs.getString("staffPosition");
                String staffAddress = rs.getString("staffAddress");
                String staffStatus = rs.getString("staffStatus");
                staff.add(new Staff(staffEmail, staffName, staffPosition, staffAddress, staffStatus));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return staff;
    }
    
    // Select Devices
    public List<Staff> selectAllStaff() {
        List<Staff> staff = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STAFF);){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String staffEmail = rs.getString("staffEmail");
                String staffName = rs.getString("staffName");
                String staffPosition = rs.getString("staffPosition");
                String staffAddress = rs.getString("staffAddress");
                String staffStatus = rs.getString("staffStatus");
                staff.add(new Staff(staffEmail, staffName, staffPosition, staffAddress, staffStatus));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return staff;
    }
    
    // Delete Device by ID
    public boolean deleteStaff(String staffEmail) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_STAFF_SQL);){
            statement.setString(1, staffEmail);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowDeleted;
    }   
}

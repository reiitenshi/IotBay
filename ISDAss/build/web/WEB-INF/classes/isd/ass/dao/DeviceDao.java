/*
 *  Author: 14323808
 */
package isd.ass.dao;

import isd.ass.model.Device;
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

public class DeviceDao {
    
    private final String jdbcURL = "jdbc:derby://localhost:1527/IOTBAYDB";
    private final String jdbcUsername = "staff";
    private final String jdbcPassword = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String INSERT_DEVICES_SQL = "INSERT INTO devices" + " (deviceName, unitPrice, deviceStock, deviceType, deviceBrand) VALUES " + " (?, ?, ?, ?, ?)";
    private static final String SELECT_DEVICE_BY_ID = "select * from devices where deviceId = ?";
    private static final String SELECT_ALL_DEVICES = "select * from devices";
    private static final String DELETE_DEVICES_SQL = "delete from devices where deviceId =?";
    private static final String UPDATE_DEVICES_SQL = "update devices set deviceName = ?, unitPrice = ?, deviceStock = ?, deviceType = ?, deviceBrand = ? where deviceId = ?";
    
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
    public void insertDevice(Device device) {
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_DEVICES_SQL);){
            statement.setString(1, device.getDeviceName());
            statement.setFloat(2, device.getUnitPrice());
            statement.setInt(3, device.getDeviceStock());
            statement.setString(4, device.getDeviceType());
            statement.setString(5, device.getDeviceBrand());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Update Device by ID
    public boolean updateDevice(Device device) {
        boolean rowUpdated = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_DEVICES_SQL);){
            statement.setString(1, device.getDeviceName());
            statement.setFloat(2, device.getUnitPrice());
            statement.setInt(3, device.getDeviceStock());
            statement.setString(4, device.getDeviceType());
            statement.setString(5, device.getDeviceBrand());
            statement.setInt(6, device.getDeviceId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }
    
    // Select Device by ID
    public Device selectDeviceById(int deviceId) {
        Device device = null;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_DEVICE_BY_ID);){
            statement.setInt(1, deviceId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                String deviceName = rs.getString("deviceName");
                float unitPrice = rs.getFloat("unitPrice");
                int deviceStock = rs.getInt("deviceStock");
                String deviceType = rs.getString("deviceType");
                String deviceBrand = rs.getString("deviceBrand");
                device = new Device(deviceId, deviceName, unitPrice, deviceStock, deviceType, deviceBrand);
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return device;
    }
    
    // Search Device List -- WIP
    public List<Device> searchDeviceList(String searchName, String searchBrand, String searchType) {
        List<Device> devices = new ArrayList<>();
        String search;
        if(searchName.equals("") && searchBrand.equals("") && !searchType.equals("")) {
            search = "select * from devices where lower(deviceType) like lower('" + searchType + "%')";
        } else if (searchName.equals("") && !searchBrand.equals("") && searchType.equals("")) {
            search = "select * from devices where lower(deviceBrand) like lower('" + searchBrand + "%')";
        } else if (!searchName.equals("") && searchBrand.equals("") && searchType.equals("")) {
            search = "select * from devices where lower(deviceName) like lower('" + searchName + "%')";
        } else if (!searchName.equals("") && !searchBrand.equals("") && searchType.equals("")) {
            search = "select * from devices where lower(deviceName) like lower('" + searchName + "%') && where lower(deviceBrand) like lower('" + searchBrand + "%')";
        } else if (!searchName.equals("") && searchBrand.equals("") && !searchType.equals("")) {
            search = "select * from devices where lower(deviceName) like lower('" + searchName + "%') && where lower(deviceType) like lower('" + searchType + "%')";
        } else if (searchName.equals("") && !searchBrand.equals("") && !searchType.equals("")) {
            search = "select * from devices where lower(deviceBrand) like lower('" + searchBrand + "%') && where lower(deviceType) like lower('" + searchType + "%')";
        } else {
            search = "select * from devices";
        }
        try(Connection connection = getConnection();){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(search);
            
            while(rs.next()) {
                int deviceId = rs.getInt("deviceId");
                String deviceName = rs.getString("deviceName");
                float unitPrice = rs.getFloat("unitPrice");
                int deviceStock = rs.getInt("deviceStock");
                String deviceType = rs.getString("deviceType");
                String deviceBrand = rs.getString("deviceBrand");
                devices.add(new Device(deviceId, deviceName, unitPrice, deviceStock, deviceType, deviceBrand));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return devices;
    }
    
    // Select Devices
    public List<Device> selectAllDevices() {
        List<Device> devices = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEVICES);){
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                int deviceId = rs.getInt("deviceId");
                String deviceName = rs.getString("deviceName");
                float unitPrice = rs.getFloat("unitPrice");
                int deviceStock = rs.getInt("deviceStock");
                String deviceType = rs.getString("deviceType");
                String deviceBrand = rs.getString("deviceBrand");
                devices.add(new Device(deviceId, deviceName, unitPrice, deviceStock, deviceType, deviceBrand));
            }
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return devices;
    }
    
    // Delete Device by ID
    public boolean deleteDevice(int deviceId) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_DEVICES_SQL);){
            statement.setInt(1, deviceId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowDeleted;
    }   
}
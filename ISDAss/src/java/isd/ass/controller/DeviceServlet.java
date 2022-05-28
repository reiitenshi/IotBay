/*
 *  Author: 14323808
 */
package isd.ass.controller;

import isd.ass.dao.DeviceDao;
import isd.ass.model.Device;
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

public class DeviceServlet extends HttpServlet {
    private DeviceDao deviceDao;
            
    public DeviceServlet() {
        this.deviceDao = new DeviceDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = "/devlist";
        if(request.getParameter("deviceBtn") != null) action = request.getParameter("deviceBtn");
        
        switch(action) {
            case "/devnew":
                showNewForm(request, response);
                break;
            case "/devinsert":
                try {
                    insertDevice(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/devdelete":
                try {
                    deleteDevice(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/devedit":
                try {
                    showEditForm(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/devupdate":
                try {
                    updateDevice(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/devsearch":
                try {
                    searchDevices(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            default:
                try {
                    listDevices(request, response);
                } catch (Exception e) {
                    Logger.getLogger(DeviceDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("device-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertDevice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String deviceName = request.getParameter("deviceName");
        float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
        int deviceStock = Integer.parseInt(request.getParameter("deviceStock"));
        String deviceType = request.getParameter("deviceType");
        String deviceBrand = request.getParameter("deviceBrand");
        Device newDevice = new Device(deviceName, unitPrice, deviceStock, deviceType, deviceBrand);
        deviceDao.insertDevice(newDevice);
        response.sendRedirect("DeviceServlet");
    }
    
    private void deleteDevice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        deviceDao.deleteDevice(deviceId);
        response.sendRedirect("DeviceServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        Device existingDevice = deviceDao.selectDeviceById(deviceId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("device-form.jsp");
        request.setAttribute("device", existingDevice);
        dispatcher.forward(request, response);
    }
    
    private void updateDevice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        String deviceName = request.getParameter("deviceName");
        float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
        int deviceStock = Integer.parseInt(request.getParameter("deviceStock"));
        String deviceType = request.getParameter("deviceType");
        String deviceBrand = request.getParameter("deviceBrand");
        Device updatedDevice = new Device(deviceId, deviceName, unitPrice, deviceStock, deviceType, deviceBrand);
        deviceDao.updateDevice(updatedDevice);
        response.sendRedirect("DeviceServlet");
    }
    
    private void listDevices(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Device> deviceList = deviceDao.selectAllDevices();
        request.setAttribute("deviceList", deviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("device-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchDevices (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchName = request.getParameter("searchName");
        String searchBrand = request.getParameter("searchBrand");
        String searchType = request.getParameter("searchType");
        List<Device> deviceList = deviceDao.searchDeviceList(searchName, searchBrand, searchType);
        request.setAttribute("deviceList", deviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("device-list.jsp");
        dispatcher.forward(request, response);
    }
}

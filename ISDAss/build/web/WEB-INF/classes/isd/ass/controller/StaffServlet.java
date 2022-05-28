/*
 *  Author: 14279842
 */
package isd.ass.controller;

import isd.ass.dao.StaffDao;
import isd.ass.model.Staff;
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

public class StaffServlet extends HttpServlet {
    private StaffDao staffDao;
            
    public StaffServlet() {
        this.staffDao = new StaffDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = "/stalist";
        if(request.getParameter("staffBtn") != null) action = request.getParameter("staffBtn");
        
        switch(action) {
            case "/stanew":
                showNewForm(request, response);
                break;
            case "/stainsert":
                try {
                    insertStaff(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/stadelete":
                try {
                    deleteStaff(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/staedit":
                try {
                    showEditForm(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/staupdate":
                try {
                    updateStaff(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/stasearch":
                try {
                    searchStaff(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            default:
                try {
                    listStaff(request, response);
                } catch (Exception e) {
                    Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String staffEmail = request.getParameter("staffEmail");
        String staffName = request.getParameter("staffName");
        String staffPosition = request.getParameter("staffPosition");
        String staffAddress = request.getParameter("staffAddress");
        String staffStatus = request.getParameter("staffStatus");
        Staff newStaff = new Staff(staffEmail, staffName, staffPosition, staffAddress, staffStatus);
        staffDao.insertStaff(newStaff);
        response.sendRedirect("StaffServlet");
    }
    
    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String staffEmail = request.getParameter("staffEmail");
        staffDao.deleteStaff(staffEmail);
        response.sendRedirect("StaffServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String staffEmail = request.getParameter("staffEmail");
        Staff existingStaff = staffDao.selectStaffByEmail(staffEmail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
        request.setAttribute("staff", existingStaff);
        dispatcher.forward(request, response);
    }
    
    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String staffEmail = request.getParameter("staffEmail");
        String staffName = request.getParameter("staffName");
        String staffPosition = request.getParameter("staffPosition");
        String staffAddress = request.getParameter("staffAddress");
        String staffStatus = request.getParameter("staffStatus");
        Staff updatedStaff = new Staff(staffEmail, staffName, staffPosition, staffAddress, staffStatus);
        staffDao.updateStaff(updatedStaff);
        response.sendRedirect("StaffServlet");
    }
    
    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Staff> staffList = staffDao.selectAllStaff();
        request.setAttribute("staffList", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchId = request.getParameter("searchId");
        String searchDate = request.getParameter("searchDate");
        List<Staff> staffList = staffDao.searchStaffList(searchId, searchDate);
        request.setAttribute("staffList", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-list.jsp");
        dispatcher.forward(request, response);
    }
}
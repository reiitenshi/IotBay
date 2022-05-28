/*
 *  Author: 1398360
 */
package isd.ass.controller;

import isd.ass.dao.UserDao;
import isd.ass.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDao userDao;
            
    public UserServlet() {
        this.userDao = new UserDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = "/userlist";
        if(request.getParameter("userBtn") != null) action = request.getParameter("userBtn");
        System.out.println(action);
        
        switch(action) {
            case "/usernew":
                showNewForm(request, response);
                break;
            case "/userinsert":
                try {
                    insertUser(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/userdelete":
                try {
                    deleteUser(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/useredit":
                try {
                    showEditForm(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/userupdate":
                try {
                    updateUser(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/usersearch":
                try {
                    searchUsers(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/userregister":
                try {
                    registerUser(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            default:
                try {
                    listUsers(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userFName = request.getParameter("userFName");
        String userLName = request.getParameter("userLName");
        String userAddress = request.getParameter("userAddress");
        User newUser = new User(userEmail, userPassword, userFName, userLName, userAddress);
        userDao.insertUser(newUser);
        response.sendRedirect("UserServlet");
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String email = request.getParameter("userEmail");
        userDao.deleteUser(email);
        response.sendRedirect("UserServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("userEmail");
        User existingUser = userDao.selectUserByEmail(email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userFName = request.getParameter("userFName");
        String userLName = request.getParameter("userLName");
        String userAddress = request.getParameter("userAddress");
        User updateUser = new User(userEmail, userPassword, userFName, userLName, userAddress);
        userDao.updateUser(updateUser);
        response.sendRedirect("UserServlet");
    }
    
    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> userList = userDao.selectAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchUsers (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchUserFName = request.getParameter("searchFName");
        String searchUserLName = request.getParameter("searchLName");
        String searchUserEmail = request.getParameter("searchEmail");
        List<User> userList = userDao.searchUserList(searchUserFName, searchUserLName, searchUserEmail);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void registerUser (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userFName = request.getParameter("userFName");
        String userLName = request.getParameter("userLName");
        String userAddress = request.getParameter("userAddress");
        User newUser = new User(userEmail, userPassword, userFName, userLName, userAddress);
        userDao.insertUser(newUser);
        response.sendRedirect("home.jsp");
    }
}

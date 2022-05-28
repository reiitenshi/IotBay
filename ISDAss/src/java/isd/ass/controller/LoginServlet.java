/*
 *  Author: 13722588
 */
package isd.ass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import isd.ass.model.User;
import isd.ass.dao.LoginDao;

public class LoginServlet extends HttpServlet {
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");

        try {
            if (loginDao.validate(email, password)) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

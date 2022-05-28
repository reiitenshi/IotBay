/*
 *  Author: 13900509
 */
package isd.ass.controller;

import isd.ass.dao.PaymentDao;
import isd.ass.model.Payment;
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

public class PaymentServlet extends HttpServlet {
    private PaymentDao paymentDao;
            
    public PaymentServlet() {
        this.paymentDao = new PaymentDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = "/paylist";
        if(request.getParameter("paymentBtn") != null) action = request.getParameter("paymentBtn");
        
        switch(action) {
            case "/paynew":
                showNewForm(request, response);
                break;
            case "/payinsert":
                try {
                    insertPayment(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/paydelete":
                try {
                    deletePayment(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/payedit":
                try {
                    showEditForm(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/payupdate":
                try {
                    updatePayment(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "/paysearch":
                try {
                    searchPayments(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            default:
                try {
                    listPayments(request, response);
                } catch (Exception e) {
                    Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertPayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String userEmail = request.getParameter("userEmail");
        String cardNo = request.getParameter("cardNo");
        String cardCVV = request.getParameter("cardCVV");
        String cardName = request.getParameter("cardName");
        Payment newPayment = new Payment(userEmail, cardNo, cardCVV, cardName);
        paymentDao.insertPayment(newPayment);
        response.sendRedirect("PaymentServlet");
    }
    
    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        paymentDao.deletePayment(paymentId);
        response.sendRedirect("PaymentServlet");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        Payment existingPayment = paymentDao.selectPaymentById(paymentId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        request.setAttribute("payment", existingPayment);
        dispatcher.forward(request, response);
    }
    
    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        String userEmail = request.getParameter("userEmail");
        String cardNo = request.getParameter("cardNo");
        String cardCVV = request.getParameter("cardCVV");
        String cardName = request.getParameter("cardName");
        Payment updatedPayment = new Payment(paymentId, userEmail, cardNo, cardCVV, cardName);
        paymentDao.updatePayment(updatedPayment);
        response.sendRedirect("PaymentServlet");
    }
    
    private void listPayments(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Payment> paymentList = paymentDao.selectAllPayments();
        request.setAttribute("paymentList", paymentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchPayments (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchId = request.getParameter("searchId");
        String searchEmail = request.getParameter("searchEmail");
        List<Payment> paymentList = paymentDao.searchPaymentList(searchId, searchEmail);
        request.setAttribute("paymentList", paymentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
        dispatcher.forward(request, response);
    }
}

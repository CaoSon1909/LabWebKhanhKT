/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonpc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sonpc.errors.tblUserLoginErr;
import sonpc.tblUser.TblUserDAO;
import sonpc.tblUser.TblUserDTO;

/**
 *
 * @author ACER
 */
public class LoginServlet extends HttpServlet {

    private final String ERROR_PAGE = "login.jsp";
    private final String SEARCH_PAGE = "SearchForwardServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;
        //get parameters
        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        //catching errors
        tblUserLoginErr error = new tblUserLoginErr();
        boolean catchError = false;
        try {
            if (userID.isEmpty()) {
                catchError = true;
                error.setUserIDLength("UserID have length in range [0-30] characters!");
            }
            if (password.isEmpty()) {
                catchError = true;
                error.setPasswordLength("Password have length in range [0-30] characters");
            }
            TblUserDAO dao = new TblUserDAO();
            TblUserDTO dto = dao.checkLogin(userID, password);
            if (dto == null) {
                catchError = true;
                error.setInvalidAccount(true);
            } 
            if (catchError){
                    request.setAttribute("LOGINERROR", error);
                    request.getRequestDispatcher(url).forward(request, response);
            }
            else {
                url = SEARCH_PAGE;
                //tạo mới một session để lưu thông tin user
                HttpSession session = request.getSession();
                session.setAttribute("USERDTO", dto);
                response.sendRedirect(url);
            }
        } catch (NamingException ex) {
            log("LoginServlet - NamingException:" + ex);
        } catch (SQLException ex) {
            log("LoginServlet - SQLException:" + ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

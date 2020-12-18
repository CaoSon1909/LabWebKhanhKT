/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonpc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.tomcat.jni.File.close;

/**
 *
 * @author ACER
 */
public class DispatcherServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";

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
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        System.out.println(request.getContextPath());
       try{
           if ("".equals(button)){
           }
           else if ("Login".equals(button)){
               url = LOGIN_SERVLET;
           }
           else if ("Logout".equals(button)){
               url = LOGOUT_SERVLET;
           }
       }
       finally{
           request.getRequestDispatcher(url).forward(request, response);
           out.close();
       }
//        try {
//            ServletContext contextScope = request.getServletContext();
//            //get the entire url
//            String uri = request.getRequestURI(); // "/LP0010/"
//            //last index
//            int lastIndex = uri.lastIndexOf("/");
//            //resource
//            String resource = uri.substring(lastIndex + 1); // null
//            //Lần đầu open in browser
//            if (resource == null){
//                url = resource + "DispatcherServlet/"+LOGIN_PAGE; // "/LP0010/DispatcherServlet"
//            }
//            //
//            Map<String, String> mapper = (Map<String, String>) contextScope.getAttribute("MAPPER");
//            if (mapper != null) {
//                url = url + mapper.get(resource);
//            }
//        } finally {
//            if (url != null) {
//                request.getRequestDispatcher(url).forward(request, response);
//                out.close();
//            }
//        }
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import DbPack.DatabaseConnection;
import DbPack.UpdateSample;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jp
 */
public class gr_mem extends HttpServlet {

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
        try {
            int tslot;
            int lcount;
            Date date = new Date();
            int hours = date.getHours();
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            HttpSession session = request.getSession();
            session.setAttribute("uid", user);
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from register where username = '" + user + "' AND  password = '" + pass + "'");
            System.out.println("Query Executed");
            if (rs.next()){
                if (rs.getString("status").equals("YES")){
//                    lcount = Integer.parseInt(rs.getString("lcount"));
//                    tslot = Integer.parseInt(rs.getString("tslot"));
//                     System.out.println("tslot "+ tslot);
//                    switch (tslot) {
//                        case 1:
//                            System.out.println("tslot inside case 1"+ tslot);
//                            System.out.println("Hours"+ hours);
//                            if ((hours >= 9) && (hours <= 13)) {
//                                System.out.println("tslot inside case if "+ tslot);
//                                 System.out.println("Hours"+ hours);
//                                boolean b = UpdateSample.CheckTime(tslot, lcount);
//                                if (b) {
//                                    response.sendRedirect("group_Signature_Verify.jsp?msg=" + user);
//                                } else {
//                                    response.sendRedirect("member_login.jsp?counterr");
//                                }
//                            }
//                            else{
//                                 response.sendRedirect("member_login.jsp?timeerror");
//                            }
//                            break;
//                        case 2:
//                            System.out.println("tslot inside case 2"+ tslot);
//                            if ((hours >= 13) && (hours <= 17)) {
//                                boolean b = UpdateSample.CheckTime(tslot, lcount);
//                                if (b) {
//                                    response.sendRedirect("group_Signature_Verify.jsp?msg=" + user);
//                                } else {
//                                    response.sendRedirect("member_login.jsp?counterr");
//                                }
//                            }
//                            else{
//                                 response.sendRedirect("member_login.jsp?timeerror");
//                            }
//                            break;
//                        case 3:
//                            System.out.println("tslot inside case 3 "+tslot);
//                            if ((hours >= 17) && (hours <= 22)) {
//                                boolean b = UpdateSample.CheckTime(tslot, lcount);
//                                if (b) {
//                                    response.sendRedirect("group_Signature_Verify.jsp?msg=" + user);
//                                } else {
//                                    response.sendRedirect("member_login.jsp?counterr");
//                                }
//                            }
//                            else{
//                                 response.sendRedirect("member_login.jsp?timeerror");
//                            }
//                            break;
//                        default:
//                            System.out.println("Your time slot is " + tslot);
//                    }
                    response.sendRedirect("group_Signature_Verify.jsp?msg=" + user);
                } else {
                    out.println("Account not yet Activated....!");
                }
            } else {
                out.println("User doesn't exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gr_mem.class.getName()).log(Level.SEVERE, null, ex);
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

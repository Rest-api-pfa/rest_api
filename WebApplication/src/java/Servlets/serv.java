/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Model.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drging
 */
public class serv extends HttpServlet {

   
    

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
        
       Livre l = new Livre(1,"nn","aaa");
        
        request.setAttribute("livre", l);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        /*ArrayList<Livre> list= new ArrayList<Livre>();
        Connection c=Databases.MysqlCon.getInstance().getConnexion();
        try {
            PreparedStatement stmt= c.prepareStatement("select * from livre");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
            {
                list.add(new Livre(rst.getInt(1),rst.getString(2),rst.getString(3)));
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(serv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);*/
        
        
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

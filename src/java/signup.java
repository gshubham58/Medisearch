/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class signup extends HttpServlet {
ResultSet rs;
        Statement stmt;
	PreparedStatement pst=null;
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
        Connection conne;
        PrintWriter out = response.getWriter();
        try{
       // Class.forName("com.mysql.jdbc.Driver");
// Setup the connection with the DB
//conne = DriverManager
  //.getConnection("jdbc:mysql://sql12.freesqldatabase.com/sql12189257?"
    //  + "user=sql12189257&password=HjIYzzbzN6");
        String usd=request.getParameter("userid");
        String pass=request.getParameter("passwrd");
        conne=connect.conn();
	String qr="insert into login values(?,?)";
	pst=conne.prepareStatement(qr);
        pst.setString(1,usd);
        pst.setString(2,pass);
	int x=pst.executeUpdate();
        
        conne.close();
        response.sendRedirect("login.jsp");
        }catch(Exception e){
        out.println("username already exist try another<br><a href =sign.jsp>click to try again</a>");
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

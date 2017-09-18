/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class loginsrv extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           Connection conne;
           Statement st;
           ResultSet rs;
           try{
       // Class.forName("com.mysql.jdbc.Driver");
// Setup the connection with the DB
//conne = DriverManager
  //.getConnection("jdbc:mysql://sql12.freesqldatabase.com/sql12189257?"
    //  + "user=sql12189257&password=HjIYzzbzN6");
        String usd=request.getParameter("userid");
        String pass=request.getParameter("passwrd");
        conne=connect.conn();
	String qr="select passwrd from login where userid= \""+usd+"\"";
	st=conne.createStatement();
        rs=st.executeQuery(qr);
        if(rs.next()){
        if(pass.equals(rs.getString(1))){
             HttpSession session = request.getSession();
            session.setAttribute("name",usd);
                response.sendRedirect("sear.jsp");

        }
        else{
        out.println("invalid password\n<a href =login.jsp>click to login again</a>");
        }
        }
        else{
        out.println("invalid userid\n <a href =login.jsp>click to login again</a>");
        }
	conne.close();
        }catch(Exception e){
        out.println(e);
        }
        
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

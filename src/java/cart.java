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
public class cart extends HttpServlet {

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
             HttpSession session = request.getSession();
            String name=session.getAttribute("name").toString();
            String o=request.getParameter("model");
            model m=(model)session.getAttribute(o);
            try{
            PreparedStatement pst;
            Connection conne;
            conne=connect.conn();
            int quan=1;
            if(request.getParameter("quant").length()>0){
            quan=Integer.parseInt(request.getParameter("quant"));
            }
            float total=0;
            total=quan*m.getPrice();
            Statement stmt;
            ResultSet rs;
           String query = "SELECT medicine_name,total FROM cart where userid= \""+name+"\"";
	stmt = conne.createStatement();
	rs = stmt.executeQuery(query);
	String qr="insert into cart values(?,?,?,?,?,?)";
	pst=conne.prepareStatement(qr);
       pst.setString(1,name);
        pst.setString(2,m.getMedicine_id());
        pst.setString(3,m.getName());
        pst.setDouble(4,m.getPrice());
        pst.setInt(5,quan);
        pst.setDouble(6,total);
	pst.executeUpdate();
	 
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body bgcolor=\"yellow\">");
           

            if(rs.next()){
        out.println("<h2>Items avalaible already----<h2>");
        out.println("<h3>"+rs.getString(1)+" with payable price =Rs"+rs.getInt(2)+"</h3>");
            while(rs.next()){
        out.println("<h3>"+rs.getString(1)+" with payable price =Rs"+rs.getInt(2)+"</h3>");
        }
            }
       
            
            out.println("<h2>ThankYou "+name+"<br> Item "+m.getName()+" added with payable price =Rs "+total+"</h2>\n");
            out.println("<a href=sear.jsp>buy more   </a><br>");
            out.println("<a href=billing>proceed to checkout</a><br>");
             out.println("<a href=logout>logout<h3>    </h3></a>");
            out.println("</body>");
            out.println("</html>");
   conne.close(); 
            }catch(Exception e){
            out.println("Please do not refresh Go back and Search Again");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class alternative extends HttpServlet {

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
             String x=request.getParameter("medicine_id");
             String url = "http://www.healthos.co/api/v1/medicines/brands/"+x+"/alternatives?page=1&size=10";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
                String USER_AGENT = "Mozilla/5.0";
		//add request header
                String aa="959f349c4e25a5a3136aa6134b07e7ef76c401626013d7be69e75087ef216afe";
		con.setRequestProperty("Authorization","bearer "+aa);
                 con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Content-Type", "application/xml");
  

		int responseCode = con.getResponseCode();
		//out.println("\nSending 'GET' request to URL : " + url);
                //out.println("Response Code : " + responseCode);
                try{
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer respons = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			respons.append(inputLine);
		}
		in.close();
                 ArrayList<model> arr=Jsonpar.json(respons.toString());
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body bgcolor=\"yellow\">");
           
            int j=0;
            while(j<arr.size()){
              out.println("Medicine Name---"+ arr.get(j).getName() + "<br>");
            out.println("Avaliable in form of---"+ arr.get(j).getForm() + "<br>");
            out.println("Number of units avaliable per pack---"+ arr.get(j).getStandardUnits() + "<br>");
            out.println("Packed in form of---"+ arr.get(j).getPackageForm() + "<br>");
            out.println("Price in Rs-"+ arr.get(j).getPrice() + "<br>");
            out.println("Pack contains---"+ arr.get(j).getSize() + "<br>");
            out.println("Manufacturer Name---"+ arr.get(j).getManufacturer() + "<br>");
            out.println("<a href=alternative?medicine_id="+arr.get(j).getMedicine_id()+">alternate medicine<h3>    </h3></a>");
            out.println("<a href=usage?medicine_id="+arr.get(j).getMedicine_id()+">view usage<h3>    </h3></a>");
            HttpSession session = request.getSession();
            session.setAttribute("obj"+j,arr.get(j));
           out.println("<a href=cartdisplay?ob=obj"+j+">add to cart</a><br><br><br><br>");
            j++;
            }
             out.println("<a href=logout>logout<h3>    </h3></a>");
            out.println("</body>");
            out.println("</html>");
		//print result
		//out.println("\n"+respons.toString());  
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

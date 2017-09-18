
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class connect {
 public static Connection conn(){
     
     try{
  Class.forName("com.mysql.jdbc.Driver");
// Setup the connection with the DB

Connection con = DriverManager
  .getConnection("jdbc:mysql://localhost:3306/medisearchdb","root","root");
return con;
     }catch(Exception e){
     e.printStackTrace();
     return null;
     }
 }   
}

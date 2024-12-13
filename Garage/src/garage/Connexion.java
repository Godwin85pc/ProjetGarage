/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Georgette Gabou
 */
public class Connexion {
   

    public static Connection conn;
    public Connection connect() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DRIVER OK!");
            String url="jdbc:mysql://localhost:3306/inscription";
            String user="root";
            String passwd="";
            Connection conn = DriverManager.getConnection(url,user,passwd);
            System.out.println("Connection effective!\n\n\n");
            return conn ;
    } 
     public static void main(String args[]) {
         
     }
  
    
}

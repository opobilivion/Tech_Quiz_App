/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author OP
 */
public class DBConnectionQuiz {
     private static Connection conn;
   static 
   {
       try
    {
        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("Driver Loaded Succesfully!");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-KTTQC0OM:1521/xe","onlineexam","student");
        System.out.println("Connected to Database");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
   }
   public static Connection getConnection()
   {
       JOptionPane.showMessageDialog(null,"Connected Successfully!");
       return conn;
   }
   public static Connection DisConnect()
   {
       try
       {
           conn.close();
           JOptionPane.showMessageDialog(null,"Disconnected Successfully");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Cannot close the Connection");
       }
          return conn;
   }
    
}

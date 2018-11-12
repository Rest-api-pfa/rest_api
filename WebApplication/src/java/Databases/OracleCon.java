/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author windows
 */
public class OracleCon {
    
    private static Connection con;
    private OracleCon()
    {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                con = DriverManager.getConnection(url, "system", "syst");
                System.out.println("oracle ok");
              
                
            } catch (Exception ex) {
               System.out.println(ex.getMessage()+"ex");
            }

           
        }
    
    private static OracleCon base = new OracleCon();
    
    public static Connection getConnexion()
    {
        return con;
    }
    
    public static OracleCon getInstance()
    {
        return base;
    }

    
}

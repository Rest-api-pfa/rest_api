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
 * @author drging
 */
public class PostgresqlCon {
    
    private static Connection con;
    private PostgresqlCon()
    {
        try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/pfa";
                con = DriverManager.getConnection(url, "postgres", "aa");
                System.out.println("ok");
              
                
            } catch (Exception ex) {
               ex.printStackTrace();
            }

           
        }
    
    private static PostgresqlCon base = new PostgresqlCon();
    
    public static Connection getConnexion()
    {
        return con;
    }
    
    public static PostgresqlCon getInstance()
    {
        return base;
    }
}


    
    



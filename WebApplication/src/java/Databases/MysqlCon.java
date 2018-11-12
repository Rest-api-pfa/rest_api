/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author drging
 */
public class MysqlCon {
    private static Connection connexion;
	
	private MysqlCon()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://192.168.9.10:3306/pfa","ilyase", "123");
			System.out.println("connexion reussie!!");
		} catch (ClassNotFoundException e) {
			
                     System.out.println(e.getMessage());
		}
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
	}
	
	private static  MysqlCon conn = new MysqlCon();
	
	public static Connection getConnexion() {
		return connexion;
	}


	public static MysqlCon getInstance()
	{
		return conn;
	}
}

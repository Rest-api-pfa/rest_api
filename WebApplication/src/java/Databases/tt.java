/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Databases;

import java.sql.Connection;

/**
 *
 * @author drging
 */
public class tt {
    
    public static void main(String[] args) {
        Connection c=MysqlCon.getInstance().getConnexion();
        System.out.println("hello");
    }
    
}

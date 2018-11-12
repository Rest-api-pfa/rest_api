/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.MysqlCon;
import Databases.OracleCon;
import Databases.PostgresqlCon;
import Model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */

public class ClientService {
    public static ArrayList<Client> getClients()
    {
        ArrayList<Client> list = new ArrayList<Client>();
        try {
            PreparedStatement stmt = OracleCon.getInstance().getConnexion().prepareStatement("select * from client");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new Client(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4))); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
     public static Client getClient(String id)
    {
        try {
            PreparedStatement stmt = OracleCon.getInstance().getConnexion().prepareStatement("select * from client where cin = ?");
            stmt.setString(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
                return  new Client(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
      public static void addClient(Client c,String to)
    {
        try {
            PreparedStatement stmt;
            if (to.equalsIgnoreCase("oracle"))
            stmt = OracleCon.getInstance().getConnexion().prepareStatement("insert into client values(?,?,?,?)");
            else if (to.equalsIgnoreCase("postgresql"))
            stmt = PostgresqlCon.getInstance().getConnexion().prepareStatement("insert into client values(?,?,?,?)");
            else 
            stmt = MysqlCon.getInstance().getConnexion().prepareStatement("insert into client values(?,?,?,?)");
            stmt.setString(1, c.getCin());
            stmt.setString(2, c.getNom());
            stmt.setString(3, c.getPrenom());
            stmt.setString(4, c.getVille());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
        public static void deleteClient(String cin)
    {
        try {
            PreparedStatement stmt = OracleCon.getInstance().getConnexion().prepareStatement("delete from  client where cin = ?");
            stmt.setString(1, cin);
           stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
      public static void updateClient(Client c)
    {
        try {
            if (getClient(c.getCin())== null)
            {
                addClient(c,"mysql");
                return;
            }
            PreparedStatement stmt = OracleCon.getInstance().getConnexion().prepareStatement("update client set nom=? , prenom=?,ville=? where cin =?");
            stmt.setString(1, c.getNom());
            stmt.setString(2, c.getPrenom());
            stmt.setString(3, c.getVille());
            stmt.setString(4,c.getCin());
           stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
      
}

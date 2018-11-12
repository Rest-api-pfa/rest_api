/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.MysqlCon;
import Model.Client;
import Model.Cmd;
import Model.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */
public class CmdService {
    
    public static ArrayList<Cmd> getCmds()
    {
        ArrayList<Cmd> list = new ArrayList<Cmd>();
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from cmd");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
            {
                Cmd c=new Cmd(rst.getInt(1),rst.getInt(3),rst.getInt(4),rst.getString(2));
                PreparedStatement stmt2 = MysqlCon.getConnexion().prepareStatement("select * from client where cin = ?");
                stmt2.setString(1, c.getCin_client());
                ResultSet rst2=stmt2.executeQuery();
                if(rst2.next())
                    c.setClients(new Client(rst2.getString(1),rst2.getString(2),rst2.getString(3),rst2.getString(4)));
                stmt2 = MysqlCon.getConnexion().prepareStatement("select * from produit where id = ?");
                stmt2.setInt(1, c.getId_produit());
                rst2=stmt2.executeQuery();
                if(rst2.next())
                    c.setProduits(new Produit(rst2.getInt(1),rst2.getString(2),rst2.getDouble(3)));
                list.add(c);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
     
    public static Cmd getCmd(int id)
    {
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from cmd where id = ?");
            stmt.setInt(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
            {
                Cmd c=new Cmd(rst.getInt(1),rst.getInt(3),rst.getInt(4),rst.getString(2));
                PreparedStatement stmt2 = MysqlCon.getConnexion().prepareStatement("select * from client where cin = ?");
                stmt2.setString(1, c.getCin_client());
                ResultSet rst2=stmt2.executeQuery();
                if(rst2.next())
                    c.setClients(new Client(rst2.getString(1),rst2.getString(2),rst2.getString(3),rst2.getString(4)));
                stmt2 = MysqlCon.getConnexion().prepareStatement("select * from produit where id = ?");
                stmt2.setInt(1, c.getId_produit());
                rst2=stmt2.executeQuery();
                if(rst2.next())
                    c.setProduits(new Produit(rst2.getInt(1),rst2.getString(2),rst2.getDouble(3)));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
    public static Client getCmd_client(int id)
    {
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from cmd where id = ?");
            stmt.setInt(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
            {
                Cmd c=new Cmd(rst.getInt(1),rst.getInt(3),rst.getInt(4),rst.getString(2));
                PreparedStatement stmt2 = MysqlCon.getConnexion().prepareStatement("select * from client where cin = ?");
                stmt2.setString(1, c.getCin_client());
                ResultSet rst2=stmt2.executeQuery();
                if(rst2.next())
                   return new Client(rst2.getString(1),rst2.getString(2),rst2.getString(3),rst2.getString(4));
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
}

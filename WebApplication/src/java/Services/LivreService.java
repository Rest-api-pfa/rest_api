/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.PostgresqlCon;
import Model.Livre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */
public class LivreService {
    
    
    public static ArrayList<Livre> getLivres()
    {
        ArrayList<Livre> list = new ArrayList<Livre>();
        try {
            PreparedStatement stmt = PostgresqlCon.getInstance().getConnexion().prepareStatement("select * from livre");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new Livre(rst.getInt(1),rst.getString(2),rst.getString(3))); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
     public static Livre getLivre(int id)
    {
        try {
            PreparedStatement stmt = PostgresqlCon.getInstance().getConnexion().prepareStatement("select * from livre where id = ?");
            stmt.setInt(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
                return  new Livre(rst.getInt(1),rst.getString(2),rst.getString(3)); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
   
}

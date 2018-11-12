/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Databases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drging
 */
public class Test {
    
    public static void main(String[] args) {
        
        
        System.out.println(call("http://localhost:8084/WebApplication2/webresources/livre/2"));
        
    }
    public static String call(String url)
    {
         String response ="";
        URL obj;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
    
     while ((inputLine = in.readLine()) != null) {
     	response+=inputLine;
     }
     in.close();
    
     //print in String
     
        } catch (MalformedURLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return response;
                
    }
    
}

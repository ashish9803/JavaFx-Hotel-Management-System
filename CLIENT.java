/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shinchan Nohara
 */
public class CLIENT {
    
    MY_CONNECTION  my_connection = new MY_CONNECTION();
 
public boolean addClient(String fname, String lname, String phone, String email)
{
    PreparedStatement st;
    ResultSet rs;
    String addQuery ="INSERT INTO `client`(`first_name`, `last_name`, `phone`, `email`) VALUES (?,?,?,?)";
    
    
        try {
            st = my_connection.createConnection().prepareStatement(addQuery);
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, phone);
            st.setString(4, email);
            
            if(st.executeUpdate() > 0)
            {
                return true;
          
            }
            else
            {
             return false;
             
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
}
}

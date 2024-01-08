/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gihan
 */
public class DBConnector {
    
    public Connection getConnection(){
    
         Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_warehouse?serverTimezone=UTC", "root", "Hasni@123");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connection Fail. Try again. ", "Connection Error!", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
}

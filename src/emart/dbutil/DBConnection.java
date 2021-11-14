/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author KRATI VAISHNAO
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-BVRQM8OO:1521/XE","project","abc");
        JOptionPane.showMessageDialog(null, "Connection opened successfully", "Success", JOptionPane.INFORMATION_MESSAGE); 
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in loading the Driver!","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in connecting with DataBase!","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection closed successfully", "Success", JOptionPane.INFORMATION_MESSAGE); 
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in closing the DataBase!","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}

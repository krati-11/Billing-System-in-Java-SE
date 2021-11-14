/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductsPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author KRATI VAISHNAO
 */
public class OrdersDAO {
      public static String getNextOrderId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select max(order_id) from orders");
        rs.next();
        String orderId = rs.getString(1);
        if(orderId == null)
            return "O-101";
        int order_no = Integer.parseInt(orderId.substring(2));
        order_no += 1;
        return("O-"+order_no);
    }
      
    public static boolean addOrder(ArrayList<ProductsPojo> al, String orderId) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?)");
        int count=0;
        for(ProductsPojo p : al)
        {
            ps.setString(1, orderId);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, UserProfile.getUserid());
            count += ps.executeUpdate();
        }
        
        return count == al.size();
    }
    
    public static ArrayList<String> getAllOrders() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select order_id from orders");
        ArrayList<String> al = new ArrayList<>();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        
        return al;
    }
    
    public static ArrayList<String> getAllOrdersForRecep(String uid) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select order_id from orders where userid=?");
        ps.setString(1, uid);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> al = new ArrayList<>();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        
        return al;
    }
    
    public static Map<String,Integer> getOrderById(String orderId) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select p_id,quantity from orders where order_id=?");
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        HashMap<String,Integer> hs = new HashMap<>();
        while(rs.next())
        {
            hs.put(rs.getString(1), rs.getInt(2));
        }
        
        return hs;
    }
}

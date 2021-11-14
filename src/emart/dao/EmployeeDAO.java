/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KRATI VAISHNAO
 */
public class EmployeeDAO {
    public static String getNextEmpId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select max(empid) from employees");
        rs.next();
        String empid = rs.getString(1);
        int empno = Integer.parseInt(empid.substring(1));
        empno += 1;
        return("E"+empno);
    }
    
    public static boolean addEmployee(EmployeePojo emp) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,emp.getEmpid());
        ps.setString(2, emp.getEmpname());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSalary());
        int result = ps.executeUpdate();
        return result == 1;
    }
    
    public static List<EmployeePojo> getAllEmployees() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from employees order by empid");
        ArrayList<EmployeePojo> empList = new ArrayList<>();
        while(rs.next())
        {
            EmployeePojo emp = new EmployeePojo();
            emp.setEmpid(rs.getString(1));
            emp.setEmpname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
            empList.add(emp);
        }
        
        return empList;
    }
    
    public static List<String> getAllEmpId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select empid from employees order by empid");
        ArrayList<String> idList = new ArrayList<>();
        while(rs.next())
        {
            String id = rs.getString(1);
            idList.add(id);
        }
        
        return idList;
    }
    
    public static EmployeePojo getEmployeeById(String empid) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from employees where empid = ?");
        ps.setString(1, empid);
        ResultSet rs = ps.executeQuery();
        EmployeePojo emp = null;
        
        if(rs.next())
        {
        emp = new EmployeePojo();
        emp.setEmpid(empid);
        emp.setEmpname(rs.getString(2));
        emp.setJob(rs.getString(3));
        emp.setSalary(rs.getDouble(4));
        }
        return emp;
    }
    
    public static boolean UpdateEmployee(EmployeePojo emp) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update employees set empname=?, job=?, salary=? where empid=?");
        ps.setString(1, emp.getEmpname());
        ps.setString(2, emp.getJob());
        ps.setDouble(3, emp.getSalary());
        ps.setString(4, emp.getEmpid());
        int x = ps.executeUpdate();
        if(x == 0)
            return false;
        else
        {
            if(!UserDAO.isUserPresent(emp.getEmpid()))
                return true;
            ps = conn.prepareStatement("update users set username=?, usertype=? where empid = ?");
            ps.setString(1, emp.getEmpname());
            ps.setString(2, emp.getJob());
            ps.setString(3, emp.getEmpid());
            int y = ps.executeUpdate();
            return y==1;
        }
    }
    
    public static boolean deleteEmployee(String empid) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from employees where empid = ?");
        ps.setString(1, empid);
        int x = ps.executeUpdate();
        return x==1;
    }
}

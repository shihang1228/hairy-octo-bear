package com.bodejidi;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class WebServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException 
    {
        
        try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
		catch (Exception ex) 
		{
		
        }
 
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
 
        try 
		{
            conn =
                DriverManager.getConnection("jdbc:mysql://localhost/test?"
                                          + "user=root"
                                          + "&password=");
 
            resp.setContentType("text/html; charset=UTF-8");
            stmt = conn.createStatement();
            String sql = "SELECT * from member";
            System.out.println("SQL: " + sql);
            rs = stmt.executeQuery(sql); 
			resp.getWriter().println("<html><head><title>Member List</title></head><body><h1>Member List</h1><table border=\"2\"><tr><td>ID</td><td>Name</td></tr>\n");
            while(rs.next()) 
			{
                Long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                resp.getWriter().println("<tr><td>" + id + "</td><td>" + firstName + " " + lastName + "</td></tr>\n");
            }
			resp.getWriter().println("</table></body></html>");
        } 
		catch (SQLException ex) 
		{
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            resp.getWriter().println("Error!");
        } 
		finally 
		{
            if (rs != null) 
			{
                try 
				{
                    rs.close();
                } 
				catch (SQLException sqlEx) 
				{
                     
                }
                rs = null;
            }
 
            if (stmt != null) 
			{
                try 
				{
                    stmt.close();
                } 
				catch (SQLException sqlEx) 
				{
                     // ignore
                }
                stmt = null;
            }
 
            if (conn != null) 
			{
                try 
				{
                    conn.close();
                } 
				catch (SQLException sqlEx) 
				{
                     // ignore
                }
                conn = null;
            }
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
 
        try 
		{ 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
		catch (Exception ex) 
		{
             // handle the error
        }
 
        Connection conn = null;
        Statement stmt = null;
 
        try 
		{
            conn =
                DriverManager.getConnection("jdbc:mysql://localhost/test?"
                                          + "user=root"
                                          + "&password=");
            stmt = conn.createStatement();
            String sql = "INSERT INTO member(first_name, last_name, date_created, last_updated) "
                       + "VALUES('" + firstName + "', '" + lastName + "', now(), now());";
            System.out.println("SQL: " + sql);
            stmt.execute(sql);
            resp.getWriter().println("Add " + firstName + " " + lastName + " success!");
        } 
		catch (SQLException ex)
		{
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            resp.getWriter().println("Error!");
        } 
		finally
		{
             // it is a good idea to release
             // resources in a finally{} block
             // in reverse-order of their creation
             // if they are no-longer needed
 
            if (stmt != null) 
			{
                try 
				{
                    stmt.close();
                } 
				catch (SQLException sqlEx) 
				{
                     // ignore
                }
                stmt = null;
            }
 
            if (conn != null) 
			{
                try 
				{
                    conn.close();
                } 
				catch (SQLException sqlEx) 
				{
                     // ignore
                }
                conn = null;
            }
        }
    }
}

package com.bodejidi;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WebServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException 
    {
        resp.getWriter().println("hello webservlet!!!");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        resp.getWriter().println("Add" + " " + firstName + "    " + lastName + "success!!!");
    }
}

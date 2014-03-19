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
}

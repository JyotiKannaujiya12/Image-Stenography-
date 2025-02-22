/**
 * 
 */
package com.nits.action.admin;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;

public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			System.out.println("id value is:"+name);
			System.out.println("password value is:"+pass);
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("Admin");
			boolean result=dao.loginCHK(name, pass);
			if(result)
			{
				request.setAttribute("admin", name);
				RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/Admin/home.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"?no=1");
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in AdminLogin Servlet......"+e);
			out.println("Opps's Error is in AdminLogin Servlet......"+e);
		}
	}
}

/**
 * 
 */
package com.nits.action.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.CommonDAO;
import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;
import com.nits.util.AES_File_EncNdec;
import com.nits.util.Utility;


public class Inbox extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			String id=request.getParameter("name");
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getInbox(id);
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				request.setAttribute("name", id);
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Create"))
			{
				ResultSet rs1=dao.getImageName("", id);
				ResultSet rs2=dao.getSecretImageName("", id);
				DAOFactory factory=new DAOFactory();
				DAO dao1=factory.getInstance("User");
				ResultSet rs3=dao1.getUsers();
				request.setAttribute("rs", rs);
				request.setAttribute("name", id);
				request.setAttribute("rs1", rs1);
				request.setAttribute("rs2", rs2);
				request.setAttribute("rs3", rs3);
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6");
				rd.forward(request, response);
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						File f=new File(getServletContext().getRealPath("/")+"/Resources/Images/Messages/"+dao.getMessageImageName(chk[i]));
						dao.deleteMessageImage(chk[i]);
						f.delete();
					}
					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=3");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Extract"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length>1)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=4");
					rd.forward(request,response);
				}
				else
				{
					String dec_Sec_Img_path =getServletContext().getRealPath("/")+"/Resources/Images/Dec_Sec_Img/Dec_Img.jpg";
					String f=getServletContext().getRealPath("/")+"/Resources/Images/Messages/"+dao.getMessageImageName(chk[0]);				
					//System.out.println("==================================>"+f+"-"+f.length());
					byte[] output=Utility.extractProcess(f);
					String Ext_Enc_Sec_Img_path = getServletContext().getRealPath("/")+"/Resources/Images/Ext_Enc_Sec_Img/Ext_Enc_Sec_Img.bmp";
					FileOutputStream fos = new FileOutputStream(Ext_Enc_Sec_Img_path);
					fos.write(output);
					fos.close();
					//System.out.println("Extraction Success.......!");
					//String dec_path=Utility.processImageDecryption(Ext_Enc_Sec_Img_path, dec_Sec_Img_path);
					String password="password12345678";
					String dec_path = AES_File_EncNdec.decryptFile(Ext_Enc_Sec_Img_path, dec_Sec_Img_path, password);
					//System.out.println("dec_path++++++++"+dec_path);
//					f.delete();
					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=7");
					rd.forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin Inbox Servlet......"+e);
			out.println("Opps's Error is in Admin Inbox Servlet......"+e);
		}
	}
}

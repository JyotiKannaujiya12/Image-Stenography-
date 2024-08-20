
package com.nits.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nits.DAOFactory.CommonDAO;
import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;
import com.nits.util.AES_File_EncNdec;
import com.nits.util.Utility;

public class HideProcess extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try
		{
			String select1=request.getParameter("select1");
			String select2=request.getParameter("select2");
			String select3=request.getParameter("select3");
			String sub=request.getParameter("sub");
			String id=request.getParameter("name");
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getInbox(id);
			RequestDispatcher rd=null;
			String main_img=select1.substring(select1.lastIndexOf("/")+1,select1.lastIndexOf(""));
			String secret_img=select2.substring(select2.lastIndexOf("/")+1,select2.lastIndexOf(""));
			System.out.println(main_img+"--------++++++++++++++++++++++secret image is: "+secret_img);
			String sec_Img=request.getRealPath("")+"/Resources/Images/Secret_Images/"+secret_img;
			//String sec_Img =getServletContext().getRealPath("/")+"/Resources/Images/Secret_Images/Sec_Img.bmp";
			String enc_Sec_Img =request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/Sec_Img.bmp";
			
			
			//String enc_Sec_Img=request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/"+secret_img;
			//System.out.println("inside hide process before process method");
			String password="password12345678";
			//Utility.processImage(sec_Img,enc_Sec_Img);
			AES_File_EncNdec.encryptFile(sec_Img, enc_Sec_Img, password);
			//System.out.println("inside hide process after process method");
			
			
                  
			if(main_img.equalsIgnoreCase("main.jpg") || secret_img.equalsIgnoreCase("secret.jpg") || select3.equalsIgnoreCase("No_User"))
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
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6&no1=101");
				rd.forward(request, response);
			}
			else
			{
//				File f =new File(request.getRealPath("")+"/Resources/Images/Input_Images/1.bmp");
//				System.out.println("--------------->"+f);
//				System.out.println("--------------->"+f.length());
				File main = new File(request.getRealPath("")+"/Resources/Images/Input_Images/"+main_img);
				File secret = new File(request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/Sec_Img.bmp");
				
				//System.out.println("main++++"+main);
				//System.out.println("secret++++"+secret);
				
				
				if(main.length()>(secret.length()*10))
				{
					if ( session.getAttribute( "waitPage" ) == null ) 
				    {  
				    	   session.setAttribute( "waitPage", Boolean.TRUE );  
				    	   PrintWriter outter = response.getWriter();  
				    	   outter.println( "<html><head>" );  
				    	   outter.println( "<title>Please Wait...</title>" );  
				       	   outter.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
				    	   outter.println( "</head><body background='Rrsources/Images/refresh2.jpg'>" );  
				    	   outter.println( "<br>" );
				    	   outter.println( "<center>" );
				    	   outter.print("<font color='red'>");
				    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
				    	   outter.println("</font>");
				    	   outter.print("<font color='#fedcba'>");
				    	   outter.println( "Please,Wait..........<br>  " );
				    	   outter.println( "Download Athentication In Process..." );
				    	   outter.println( "<br>" );
				    	   outter.println("</font>");
				    	   outter.println( "<br>" );
				    	   outter.print( "<img src='Resources/Images/ajax_loader.gif'></img><br><br>");
				    	   outter.print("<font color='#AD814E'>");
				    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
				    	   outter.println( "<br>" );
				    	   outter.println( "Downloading is in process..." );
				    	   outter.println( "<br>" );
				    	   outter.println( "The File is in local server1...." );
				    	   outter.println("</font>");
				    	   outter.println( "<br>" );
				    	   outter.println( "Please wait....</h1></center");  
				    	   outter.close();  
				     }
					else
					{
						session.removeAttribute( "waitPage" );  
				    	
						response.setContentType("text/html");
					  
					int i=0;
					//FileInputStream fin = new FileInputStream(secret);
					
					//byte fileContent[] = new byte[(int)secret.length()];
					Path path = Paths.get(request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/Sec_Img.bmp");
					byte[] fileContent = Files.readAllBytes(path);
					//fin.read(fileContent);
					
					
					//System.out.println("fin is+++++ "+fin);
					//fin.close();
					Random random=new Random();
					int num = random.nextInt(100000);
					Utility.hideProcess(main, request.getRealPath("")+"/Resources/Images/Messages/"+id+"-"+num+".bmp", fileContent);
					dao.makeTrans(id, select3, id+"-"+num+".bmp", sub);
					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					request.setAttribute("name", id);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=1");
					rd.forward(request, response);
					}
				}
				else
				{
					ResultSet rs1=dao.getImageName("", id);
					ResultSet rs2=dao.getSecretImageName("", id);
					request.setAttribute("rs", rs);
					request.setAttribute("name", id);
					request.setAttribute("rs1", rs1);
					request.setAttribute("rs2", rs2);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6&no1=102");
					rd.forward(request, response);
				}
//				Utility.hideProcess(bmpinfile, bmpoutfile, intxt);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User HideProcess ImageList......"+e);
			out.println("Opps's Error is in User HideProcess ImageList......"+e);
		}
	}
}

package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nits.util.*;
import java.sql.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");

	String user=Utility.parse1(request.getAttribute("user"));
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int no=Utility.parse(request.getParameter("no"));
	int id=0;
	String userid="",name="",gender="",add="",email="",phone="",city="";
	if(no==0)
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		gender=rs.getString(5);
		add=rs.getString(6);
		city=rs.getString(7);
		email=rs.getString(8);
		phone=rs.getString(9);
	}

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\t\t");

			if(no==1)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t\t\t<p>Opp's,Seems something went wrong ..!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

			}
			if(no==0)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"gradientbuttons\" href=\"");
      out.print(request.getContextPath() );
      out.write("/EditProfile2?name=");
      out.print(user );
      out.write("&no=1\" target=\"afrm\">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<a class=\"gradientbuttons\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ChangePass2?name=");
      out.print(user );
      out.write("&no=1&id=");
      out.print(id );
      out.write("\" target=\"afrm\">Change Password</a>\r\n");
      out.write("\t\t\t\t\t</div><br></br>\r\n");
      out.write("\t\t\t\t\t<div id=\"a1\">\r\n");
      out.write("\t\t\t\t\t\t<p>Your ID No : ");
      out.print(id );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your Name : ");
      out.print(name );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your User ID : ");
      out.print(userid );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your Mail ID : ");
      out.print(email );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your Cell N0 : ");
      out.print(phone );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your Address : ");
      out.print(add );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<p>Your City : ");
      out.print(city );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

				if(Utility.parse(request.getParameter("no1"))==1)
				{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t\t\t\t<p>Your profile updated successfully ..!</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");

				}
			}
		
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

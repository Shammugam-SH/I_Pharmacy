package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class export_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            table.myTable { border-collapse:collapse; }\n");
      out.write("            table.myTable td, table.myTable th { border:1px solid black;padding:5px; }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            String exportToExcel = request.getParameter("exportToExcel");
            if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "Clinical_Audit_Report.xlsx");
            }
        
      out.write("\n");
      out.write("        <div id=\"MyExportTable\">\n");
      out.write("            <table class=\"myTable\">\n");
      out.write("\n");
      out.write("                ");

                    Connection conn = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://10.73.32.200:3306/emedica", "root", "qwerty");
                    ResultSetMetaData rsmd;
                    ResultSet rs1 = null;
                    ResultSet rsnew = null;
                    PreparedStatement ps1 = null;
                    String st = "select * from pis_atc";
                    try {
      out.write("\n");
      out.write("                <tr>");

                    ps1 = conn.prepareStatement(st);
                    rsnew = ps1.executeQuery();
                    rs1 = rsnew;
                    rsmd = rs1.getMetaData();
                    int cou = rsmd.getColumnCount();
                    for (int i = 1; i <= cou; i++) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <td><b>\n");
      out.write("                            ");
      out.print(rsmd.getColumnName(i));
      out.write("\n");
      out.write("                            ");

                                }
                            
      out.write(" </td></tr>\n");
      out.write("                        ");

                            while (rs1.next()) {
                        
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs1.getString(1));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(2));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(3));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(4));
      out.write("</td>\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        out.println(e);
                    }
                
      out.write("\n");
      out.write("            </table> </div>\n");
      out.write("            ");

                if (exportToExcel == null) {
            
      out.write("\n");
      out.write("        <a href=\"export.jsp?exportToExcel=YES\">Export to Excel</a>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

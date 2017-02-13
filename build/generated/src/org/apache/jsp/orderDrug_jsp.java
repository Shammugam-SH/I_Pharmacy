package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import dBConn.Conn;
import main.RMIConnector;
import Config.Config;

public final class orderDrug_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


    Config.getFile_url(session);
    Config.getBase_url(request);

    Conn conn = new Conn();


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-3.3.6-dist/css/dataTables.bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- header -->\n");
      out.write("        <div w3-include-html=\"libraries/pharmacyHeader.jsp\"></div>\n");
      out.write("        <!-- header -->\n");
      out.write("\n");
      out.write("        <!-- menu top -->\n");
      out.write("        <div w3-include-html=\"libraries/pharmacyTopMenus.jsp\"></div>\n");
      out.write("        <!-- menu top -->\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">       \n");
      out.write("                <!-- menu side -->\t\t\n");
      out.write("                <div w3-include-html=\"libraries/pharmacySideMenus.jsp\"></div>\n");
      out.write("                <!-- menu side -->\t\n");
      out.write("\n");
      out.write("                <!-- main -->\t\t\n");
      out.write("                <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\" style=\"background: #f2f4f8;\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                            <div id=\"orderDrugSearchDiv\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div id=\"orderDrugBasicInfoDiv\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div id=\"orderDrugTableDiv\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- main -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Bootstrap core JavaScript\n");
      out.write("             ================================================== -->\n");
      out.write("            <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("            <!-- Bootstrap core JavaScript\n");
      out.write("            ================================================== -->\n");
      out.write("            <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("            <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("            <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\n");
      out.write("            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("            <script src=\"http://www.w3schools.com/lib/w3data.js\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js\"></script>\n");
      out.write("            <script src=\"bootstrap-3.3.6-dist/js/jquery.dataTables.min.js\"></script>\n");
      out.write("            <script src=\"bootstrap-3.3.6-dist/js/dataTables.bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("\n");
      out.write("                w3IncludeHTML();\n");
      out.write("\n");
      out.write("                $('#orderDrugSearchDiv').load('searchPatient.jsp');\n");
      out.write("                $('#orderDrugBasicInfoDiv').load('orderDrugBasicInfo.jsp');\n");
      out.write("                $('#orderDrugTableDiv').load('orderDrugTable.jsp');\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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

package org.apache.jsp.RIS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import dBConn.Conn;
import main.RMIConnector;
import Config.Config;

public final class HIS060001_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/RIS/libraries/radiologyHeadLibrary.jsp");
    _jspx_dependants.add("/RIS/../assets/header.html");
    _jspx_dependants.add("/RIS/libraries/radiologySideMenus.jsp");
    _jspx_dependants.add("/RIS/libraries/radiologyTopMenus.jsp");
    _jspx_dependants.add("/RIS/libraries/radiologyFootLibrary.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- header -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"libraries/js/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<link href=\"libraries/css/dataTables.bootstrap.min.css\" rel=\"stylesheet\" >\n");
      out.write("<link href=\"libraries/css/buttons.dataTables.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"libraries/css/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"libraries/css/mystyles.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        ");
      out.write("<title>iHIS | Biocore</title>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"../assets/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../assets/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\"> <!-- Font Icons -->\r\n");
      out.write("<link href=\"../assets/css/dashboard.css\" rel=\"stylesheet\"> <!-- Main CSS -->\r\n");
      out.write("<link href=\"../assets/css/Line-tabs.css\" rel=\"stylesheet\"> <!-- Page Tab -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../assets/css/demo-relevant.css\"> <!-- Page Transition -->\r\n");
      out.write("\r\n");
      out.write("<!-- IE10 viewport hack for Surface/desktop Windows 8 bug\r\n");
      out.write("<link href=\"../Dashboard_files/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">-->\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">.panel panel-default-small{width:250px}.panel-title{font-size:14px}.list-group-item{width:200px}.fa-chevron-right{color:#0088cc}.list-group-item{display:block;margin-left:40px}.list-group-item librePanelListGroupItem{padding-left:30px}\r\n");
      out.write("</style>");
      out.write("\n");
      out.write("        <!-- header -->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">       \n");
      out.write("                <!-- menu side -->\t\n");
      out.write("                ");
      out.write('\n');

    String gamba = "";
    String nama = "";
    String role = "";
    String hfcName = "";

    if (session.getAttribute("USER_NAME") != null) {

        gamba = session.getAttribute("PICTURE").toString();
        nama = session.getAttribute("USER_NAME").toString();
        role = session.getAttribute("ROLE_NAME").toString();
        hfcName = session.getAttribute("HFC_NAME").toString();
    }


      out.write("\n");
      out.write("\n");
      out.write("<div class=\"col-sm-3 col-md-2 sidebar\">\n");
      out.write("    <div class=\"brand\"></div>\n");
      out.write("    <!-- logo -->\n");
      out.write("    <div class=\"logo\">\n");
      out.write("        Welcome to <span>iHIS</span>\n");
      out.write("    </div>\n");
      out.write("    <!-- logo -->\n");
      out.write("\n");
      out.write("    <!-- profile Sidebar -->\n");
      out.write("    <div class=\"profile\">\n");
      out.write("        <div class=\"profile-userpic\">\n");
      out.write("            <img src=\"");
      out.print( gamba);
      out.write("\" class=\"img-responsive\" alt=\"\">\n");
      out.write("        </div>\n");
      out.write("        <!-- SIDEBAR USER TITLE -->\n");
      out.write("        <div class=\"profile-usertitle\">\n");
      out.write("            <div class=\"profile-usertitle-name\">\n");
      out.write("                ");
      out.print( nama);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"profile-usertitle-job\">\n");
      out.write("                ");
      out.print( role);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            @\n");
      out.write("            <div class=\"profile-usertitle-job\">\n");
      out.write("                ");
      out.print( hfcName);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- SIDEBAR BUTTONS -->\n");
      out.write("        <div class=\"profile-userbuttons\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-success btn-sm\" onclick=\"window.location.href='../Entrance/profile.jsp'\">Manage Account</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("    <!-- profile Sidebar -->\n");
      out.write("    <ul class=\"nav nav-sidebar\" id=\"side-menu\">\n");
      out.write("        <li><a href=\"patientOrderList.jsp\"><i class=\"fa fa-credit-card sideIcon\" aria-hidden=\"true\" ></i>Dispense Drug Order</a></li>   \n");
      out.write("        <li><a href=\"manageInventory.jsp\"><i class=\"fa fa-credit-card sideIcon\" aria-hidden=\"true\" ></i>Manage Drug Inventory </a></li>\n");
      out.write("        <li><a href=\"importMedcine.jsp\"><i class=\"fa fa-credit-card sideIcon\" aria-hidden=\"true\" ></i>Import Drug</a></li>  \n");
      out.write("        <li><a href=\"manageReport.jsp\"><i class=\"fa fa-credit-card sideIcon\" aria-hidden=\"true\" ></i>Report</a></li>\n");
      out.write("    </ul>  \n");
      out.write("</div>");
      out.write("\n");
      out.write("                <!-- menu side -->\t\n");
      out.write("                <!-- main -->\t\t\n");
      out.write("                <div class=\"main\" style=\"background: #f2f4f8;\">\n");
      out.write("                    <!-- menu top -->\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-static-top\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-left back\" style=\"\">\n");
      out.write("                    <li><a href=\"../Entrance/dashboard.jsp\" title=\"Back\"><i class=\" fa fa-chevron-left\"></i></a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"nav navbar-nav navbar-left\">\n");
      out.write("                    <div style=\"padding: 10px 20px; display: block; font-size: 22px;\">\n");
      out.write("                        <span style=\"font-size: 22px;\">RIS Screen</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right logout\" style=\"\">\n");
      out.write("                    <li><a href=\"../Entrance/destroySession.jsp\"  title=\"Log Out\"><i class=\" fa fa-power-off\"></i></a></li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("                    <!-- menu top -->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div  class=\"thumbnail\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <!-- Tab Menu -->\n");
      out.write("                                <div class=\"tabbable-panel\">\n");
      out.write("                                    <div class=\"tabbable-line\">\n");
      out.write("                                        <ul class=\"nav nav-tabs \">\n");
      out.write("                                            <li class=\"active\">\n");
      out.write("                                                <a href=\"#tab_default_1\" data-toggle=\"tab\">\n");
      out.write("                                                    ORDER LIST</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"#tab_default_2\" data-toggle=\"tab\">\n");
      out.write("                                                    ORDER DETAIL</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                        <!-- tab content -->\n");
      out.write("                                        <div class=\"tab-content\">\n");
      out.write("                                            <div class=\"tab-pane active\" id=\"tab_default_1\">\n");
      out.write("                                                <div id=\"risOrderListContent\">\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"tab-pane\" id=\"tab_default_2\">\n");
      out.write("                                                <div id=\"risOrderDetailContent\">\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Tab Menu -->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- main -->\t\t\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"libraries/js/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/bootbox.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"libraries/js/dataTables.bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/dataTables.buttons.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/buttons.flash.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/jszip.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/pdfmake.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/vfs_fonts.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/buttons.html5.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"libraries/js/papaparse.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("          //  $('<div class=\"loading\">Loading</div>').appendTo('body');\n");
      out.write("\n");
      out.write("          //  $(\"#risOrderListContent\").load(\"patientOrderListTable.jsp\");\n");
      out.write("           // $(\"#risOrderDetailContent\").load(\"patientOrderListBasicInfoNew.jsp\");\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
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

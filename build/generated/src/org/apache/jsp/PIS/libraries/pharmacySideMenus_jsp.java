package org.apache.jsp.PIS.libraries;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pharmacySideMenus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


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
      out.write("            <button type=\"button\" class=\"btn btn-success btn-sm\" onclick=\"window.location.href = '../Entrance/profile.jsp'\">Manage Account</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <hr/>\n");
      out.write("    <!-- profile Sidebar -->\n");
      out.write("    <ul class=\"nav nav-sidebar\" id=\"side-menu\">\n");
      out.write("        <li><a href=\"patientOrderList.jsp\"><i class=\"fa fa-shopping-cart fa-lg\" aria-hidden=\"true\" ></i>Dispense Drug Order</a></li>\n");
      out.write("        <li><a href=\"manageInventory.jsp\"><i class=\"fa fa-barcode fa-lg\" aria-hidden=\"true\" ></i>Manage Drug Inventory </a></li>\n");
      out.write("        <li><a href=\"importMedcine.jsp\"><i class=\"fa fa-credit-card sideIcon\" aria-hidden=\"true\" ></i>Import Drug</a></li> \n");
      out.write("        <li><a href=\"manageReport.jsp\"><i class=\"fa fa-bar-chart fa-lg\" aria-hidden=\"true\" ></i>Report</a></li>\n");
      out.write("    </ul>  \n");
      out.write("</div>");
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

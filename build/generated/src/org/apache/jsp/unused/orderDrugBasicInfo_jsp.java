package org.apache.jsp.unused;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class orderDrugBasicInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"thumbnail\">\n");
      out.write("    <h4>Basic Info</h4>\n");
      out.write("    <hr/>\n");
      out.write("    <form class=\"form-horizontal\" name=\"myForm2\" id=\"myForm2\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">PMI No.</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"pmino\" name=\"pmino\" type=\"text\" placeholder=\" \" readonly class=\"form-control input-md\">   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">Name</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"pname\" name=\"pname\" type=\"text\" readonly placeholder=\"\" class=\"form-control input-md\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <!-- Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">New IC No.</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"pnic\" name=\"pnic\" type=\"text\" readonly placeholder=\"\" class=\"form-control input-md\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!--Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">Blood Type</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"pbtype\" name=\"pbtype\" type=\"text\" readonly placeholder=\"\" class=\"form-control input-md\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("\n");
      out.write("                <!--Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">Old IC No.</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"poic\" name=\"poic\" type=\"text\" readonly placeholder=\"\" class=\"form-control input-md\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!--Text input-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-md-4 control-label\" for=\"textinput\">Birthday Date</label>\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <input id=\"pbdate\" name=\"pbdate\" type=\"text\" readonly placeholder=\"\" class=\"form-control input-md\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
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

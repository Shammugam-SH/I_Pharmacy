package org.apache.jsp.PIS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testingImport_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <b>JS-XLSX Live Demo</b><br />\n");
      out.write("        Output Format:\n");
      out.write("        <select name=\"format\">\n");
      out.write("            <option value=\"csv\" selected> CSV</option>\n");
      out.write("            <option value=\"json\"> JSON</option>\n");
      out.write("            <option value=\"form\"> FORMULAE</option>\n");
      out.write("        </select><br />\n");
      out.write("\n");
      out.write("        <div id=\"drop\">Drop a spreadsheet file here to see sheet data</div>\n");
      out.write("        <p><input type=\"file\" name=\"xlfile\" id=\"xlf\" /> ... or click here to select a file</p>\n");
      out.write("        <textarea id=\"b64data\">... or paste a base64-encoding here</textarea>\n");
      out.write("        <input type=\"button\" id=\"dotext\" value=\"Click here to process the base64 text\" onclick=\"b64it();\"/><br />\n");
      out.write("        Advanced Demo Options: <br />\n");
      out.write("        Use Web Workers: (when available) <input type=\"checkbox\" name=\"useworker\" checked><br />\n");
      out.write("        Use Transferrables: (when available) <input type=\"checkbox\" name=\"xferable\" checked><br />\n");
      out.write("        Use readAsBinaryString: (when available) <input type=\"checkbox\" name=\"userabs\" checked><br />\n");
      out.write("        <pre id=\"out\"></pre>\n");
      out.write("        <br />\n");
      out.write("        <!-- uncomment the next line here and in xlsxworker.js for encoding support -->\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"libraries/jszip.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"libraries/xlsx.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("            function get_radio_value(radioName) {\n");
      out.write("                var radios = document.getElementsByName(radioName);\n");
      out.write("                for (var i = 0; i < radios.length; i++) {\n");
      out.write("                    if (radios[i].checked) {\n");
      out.write("                        return radios[i].value;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function to_json(workbook) {\n");
      out.write("                var result = {};\n");
      out.write("                workbook.SheetNames.forEach(function (sheetName) {\n");
      out.write("                    var roa = XLS.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);\n");
      out.write("                    if (roa.length > 0) {\n");
      out.write("                        result[sheetName] = roa;\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                return result;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function to_csv(workbook) {\n");
      out.write("                var result = [];\n");
      out.write("                workbook.SheetNames.forEach(function (sheetName) {\n");
      out.write("                    var csv = XLS.utils.make_csv(workbook.Sheets[sheetName]);\n");
      out.write("                    if (csv.length > 0) {\n");
      out.write("                        result.push(\"SHEET: \" + sheetName);\n");
      out.write("                        result.push(\"\");\n");
      out.write("                        result.push(csv);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                return result.join(\"\\n\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function to_formulae(workbook) {\n");
      out.write("                var result = [];\n");
      out.write("                workbook.SheetNames.forEach(function (sheetName) {\n");
      out.write("                    var formulae = XLS.utils.get_formulae(workbook.Sheets[sheetName]);\n");
      out.write("                    if (formulae.length > 0) {\n");
      out.write("                        result.push(\"SHEET: \" + sheetName);\n");
      out.write("                        result.push(\"\");\n");
      out.write("                        result.push(formulae.join(\"\\n\"));\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                return result.join(\"\\n\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var tarea = document.getElementById('b64data');\n");
      out.write("            function b64it() {\n");
      out.write("                var cfb = XLS.CFB.read(tarea.value, {type: 'base64'});\n");
      out.write("                var wb = XLS.parse_xlscfb(cfb);\n");
      out.write("                process_wb(wb);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function process_wb(wb) {\n");
      out.write("                var output = \"\";\n");
      out.write("                switch (get_radio_value(\"format\")) {\n");
      out.write("                    case \"json\":\n");
      out.write("                        output = JSON.stringify(to_json(wb), 2, 2);\n");
      out.write("                        break;\n");
      out.write("                    case \"form\":\n");
      out.write("                        output = to_formulae(wb);\n");
      out.write("                        break;\n");
      out.write("                    default:\n");
      out.write("                        output = to_csv(wb);\n");
      out.write("                }\n");
      out.write("                if (out.innerText === undefined)\n");
      out.write("                    out.textContent = output;\n");
      out.write("                else\n");
      out.write("                    out.innerText = output;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var drop = document.getElementById('drop');\n");
      out.write("            function handleDrop(e) {\n");
      out.write("                e.stopPropagation();\n");
      out.write("                e.preventDefault();\n");
      out.write("                var files = e.dataTransfer.files;\n");
      out.write("                var i, f;\n");
      out.write("                for (i = 0, f = files[i]; i != files.length; ++i) {\n");
      out.write("                    var reader = new FileReader();\n");
      out.write("                    var name = f.name;\n");
      out.write("                    reader.onload = function (e) {\n");
      out.write("                        var data = e.target.result;\n");
      out.write("                        var cfb = XLS.CFB.read(data, {type: 'binary'});\n");
      out.write("                        //var arr = String.fromCharCode.apply(null, new Uint8Array(data));\n");
      out.write("                        //var cfb = XLS.CFB.read(btoa(arr), {type: 'base64'});\n");
      out.write("                        var wb = XLS.parse_xlscfb(cfb);\n");
      out.write("                        process_wb(wb);\n");
      out.write("                    };\n");
      out.write("                    reader.readAsBinaryString(f);\n");
      out.write("                    //reader.readAsArrayBuffer(f);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function handleDragover(e) {\n");
      out.write("                e.stopPropagation();\n");
      out.write("                e.preventDefault();\n");
      out.write("                e.dataTransfer.dropEffect = 'copy';\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (drop.addEventListener) {\n");
      out.write("                drop.addEventListener('dragenter', handleDragover, false);\n");
      out.write("                drop.addEventListener('dragover', handleDragover, false);\n");
      out.write("                drop.addEventListener('drop', handleDrop, false);\n");
      out.write("            }\n");
      out.write("    </script>\n");
      out.write("</html>\n");
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

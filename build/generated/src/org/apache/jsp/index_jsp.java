package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    \n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>Intro</title>\n");
      out.write("\n");
      out.write("<link href=\"files/stylemain.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <style>\n");
      out.write("        .login-form .header {\n");
      out.write("\tpadding: 0px 0px 0px 40px;\n");
      out.write("        }\n");
      out.write("        .login-form .content {\n");
      out.write("\tpadding: 0 30px 10px 30px;\n");
      out.write("        }\n");
      out.write("        .by {\n");
      out.write("\twidth:100%;\n");
      out.write("\tposition:relative;\n");
      out.write("\tz-index:100;\n");
      out.write("\tmargin:0 auto;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("<script type=\"text/javascript\" src=\"files/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"files/jquery-ui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"files/text.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function() {\n");
      out.write("\t$(\".username\").focus(function() {\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"-48px\");\n");
      out.write("\t});\n");
      out.write("\t$(\".username\").blur(function() {\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"0px\");\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\".password\").focus(function() {\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"-48px\");\n");
      out.write("\t});\n");
      out.write("\t$(\".password\").blur(function() {\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"0px\");\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div id=\"wrapper\">\n");
      out.write("<div name=\"\" class=\"login-form\">\n");
      out.write("<form name=\"execForm\" method=\"POST\" action=\"Controller\">\n");
      out.write("    <div class=\"header\" style=\"background-color: #E8E8E8;\">\n");
      out.write("        <h1>e-Purse </h1>\n");
      out.write("        <span>The easiest way to pay!</span>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <img src=\"files/logo.png\" style=\"margin-left: 140px;\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <a href=\"/WebMoney/login.jsp\" class=\"button\" style=\"text-decoration: none; margin-right: 160px;\">Login</a>\n");
      out.write("        <a href=\"/WebMoney/reg.jsp\" class=\"register\" style=\"text-decoration: none;\">Register</a>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("    <div class=\"gradient\"></div>\n");
      out.write("</body>    \n");
      out.write("<div class=\"by\" style=\"text-align: center; color: #627886;\">by Boretsky Anton</div>\n");
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

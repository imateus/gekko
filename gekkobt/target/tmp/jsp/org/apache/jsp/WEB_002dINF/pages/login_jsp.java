/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.0.v20140526
 * Generated at: 2014-06-09 17:41:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gekkobt.controller.LoginController;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/mateus.pardinho/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153395882000L));
    _jspx_dependants.put("file:/C:/Users/mateus.pardinho/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1401391044657L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<head title=\"DPT - Gerenciador de Parametros\">\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"resources/css/modal-esqueci-senha.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"resources/js/modal-esqueci-senha.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#sidebar\").accordion({\r\n");
      out.write("\t\t\tcollapsible : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#tbBankAccount').flexigrid({\r\n");
      out.write("\t\t\twidth : 799,\r\n");
      out.write("\t\t\tsingleSelect : true,\r\n");
      out.write("\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\tname : 'Adicionar',\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tseparator : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'Aprovar',\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tseparator : true\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction ExibeTelaSemMenu(nomeTela) {\r\n");
      out.write("\t\t$(\"#body\").empty();\r\n");
      out.write("\t\t$.each(nomeTela.split(','), function(index, nomeTela) {\r\n");
      out.write("\t\t\t$.get(nomeTela, function(data) {\r\n");
      out.write("\t\t\t\t$(\"#body\").append(data);\r\n");
      out.write("\t\t\t\t$(\".body\").datepicker();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"citi-header\">\r\n");
      out.write("\t\t<a class=\"logo pull-right\"> <img src=\"assets/img/Logo.png\"\r\n");
      out.write("\t\t\tstyle=\"width: 70px; position: relative; top: -20px;\" />\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<div class=\"app_logo\">\r\n");
      out.write("\t\t\t<span style=\"color: white; font-size: 17px; font-weight: bold;\">Gekko\r\n");
      out.write("\t\t\t\tBug tracker</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"main-nav\" class=\"navbar\">\r\n");
      out.write("\t\t<div class=\"navbar-inner\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"body\" style=\"padding: 4px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Begin Page Content -->\r\n");
      out.write("<!-- \r\n");
      out.write("<form action=\"login\" method=\"post\"> -->\r\n");
      out.write("<form action=\"login/efetuaLogin\" method=\"post\">\r\n");
      out.write("\t\t<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<label for=\"userLogin\">Username:</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\tid=\"userLogin\" name=\"userLogin\"> <label for=\"userPassword\">Password:</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<a href=\"#janela1\" rel=\"modal\">Esqueci minha senha</a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"password\" id=\"userPassword\" name=\"userPassword\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"lower\">\r\n");
      out.write("\t\t\t\t<!-- <input type=\"submit\" value=\"Entrar\" /> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <button type=\"submit\" id=\"logar\" class=\"btn btn-primary\"\r\n");
      out.write("\t\t\t\t\tstyle=\"margin-top: 20px; float: right; margin-right: 20px;\">\r\n");
      out.write("\t\t\t\t\tLogar</button>\r\n");
      out.write("\t\t\t\t<!-- <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t/* document.getElementById(\"logar\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\tlocation.href = \"efetuaLogin\";\r\n");
      out.write("\t\t\t\t\t}; */\r\n");
      out.write("\t\t\t\t</script> -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- \t</form> -->\r\n");
      out.write("\t\t\t<!--/ lower-->\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- <a href=\"#janela1\" rel=\"modal\">Janela modal</a> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"window\" id=\"janela1\">\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"fechar\"><b>X</b></a>\r\n");
      out.write("\t\t\t<h3>Esqueceu sua senha?</h3>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<h5>Digite seu email abaixo para receber os dados de usuário:</h5>\r\n");
      out.write("\t\t\t<br /> <label class=\"label_1\" style=\"float:left; position:relative; top:8px;\"> E-mail:</label>  <input\r\n");
      out.write("\t\t\t\tid=\"filterValue\" name=\"nomeResponsavel\" style=\"width: 300px;\"\r\n");
      out.write("\t\t\t\ttype=\"text\" MaxLength=\"30\" size=\"40\" />\r\n");
      out.write("\t\t\t<div class=\"btn-fld\" style=\"float: right\">\r\n");
      out.write("\t\t<!--  <form action=\"\"> -->\r\n");
      out.write("\t\t\t\t<button id=\"logar\" class=\"btn btn-primary\" onclick=\"alert('Enviado com sucesso!!!')\"\r\n");
      out.write("\t\t\t\t\tstyle=\"margin-top: 5px; float: right; margin-right: 8px;\"><b>\r\n");
      out.write("\t\t\t\t\tEnviar</b></button>  <!-- </form>  -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- mascara para cobrir o site -->\r\n");
      out.write("\t\t<div id=\"mascara\"></div>\r\n");
      out.write("<div style=\"bottom:0px; width:97%; position:absolute;\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fimport_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /WEB-INF/pages/login.jsp(13,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_c_005fimport_005f0.setUrl("../pages/taglibs/resources.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
      if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f1.setParent(null);
    // /WEB-INF/pages/login.jsp(134,2) name = url type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_c_005fimport_005f1.setUrl("taglibs/footer.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f1 = _jspx_th_c_005fimport_005f1.doStartTag();
      if (_jspx_th_c_005fimport_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f1);
    }
    return false;
  }
}

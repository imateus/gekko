/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.0.v20140526
 * Generated at: 2014-05-29 21:04:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gekkobt.controller.ReportUserOccurrencesController;

public final class report_002dproject_002doccurrences_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Ocorrências por projeto</title>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
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
      out.write("\t\t<div class=\"navbar-inner\">\r\n");
      out.write("\t\t\t<ul class=\"nav pull-right\">\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\tclass=\"authentication dropdown-toggle\"> <i\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-lock icon-white\" style=\"display: inline-block;\"></i>Olá:\r\n");
      out.write("\t\t\t\t\t\tVitor Tadashi <span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\"><i class=\"icon-signout\"></i>Sair</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav\">\r\n");
      out.write("\t\t\t\t<li class=\"\"><a href=\"consulta-ocorrencias.html\" title=\"Home\">Ocorrências</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\"><a href=\"#\" data-toggle=\"dropdown\"class\"dropdown-toggle\">Relatórios<b\r\n");
      out.write("\t\t\t\t\t\tclass=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t\t<div class=\"dropdown-menu megamenu\" style=\"width: 400px\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row-fluid\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"relatorio-ocorrencias-usuario.html\">Ocorrências\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tpor usuário</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"relatorio-ocorrencias-projeto.html \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tOcorrências por projeto</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"body\" style=\"padding: 4px;\">\r\n");
      out.write("\t\t<div id=\"content\" style=\"padding: 5px;\">\r\n");
      out.write("\t\t\t<div class=\"row-fluid\">\r\n");
      out.write("\t\t\t\t<div class=\"span12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"page-header\">\r\n");
      out.write("\t\t\t\t\t\t<h1>Ocorrências por projeto</h1>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<form class=\"form-inline actions-toolbar\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row-fluid actions-toolbar-inner\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-top: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span1\" style=\"width: 75px;\">Projeto</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span1\" style=\"width: 160px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"select1\" name=\"select\" style=\"width: 170px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>Gekko</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>Dashboard</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span2\" style=\"margin-left: 60px; float: left;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-filter icon-white\"></i>&nbsp;Filtrar\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<div style=\"width: 100%; overflow: auto;\">\r\n");
      out.write("\t\t\t\t\t\t<table id=\"example\" class=\"table table-bordered table-striped\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th><i class=\"sort\"></i></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Erro<i class=\"sort\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Alteração de escopo<i class=\"sort\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Reincidência<i class=\"sort\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Pendente</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>05</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>04</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>01</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr class=\"even\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Resolvido</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>04</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>04</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>00</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Análise</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>01</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>00</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>01</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row-fluid actions-toolbar\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"actions-toolbar-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"control-label\" for=\"select01\"> </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <div class=\"span4\">\r\n");
      out.write("                        <div class=\"pagination pagination-right\">\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"#\">&lt;&lt;</a></li>\r\n");
      out.write("                                <li class=\"active\"><a href=\"#\">1</a> </li>\r\n");
      out.write("                                <li><a href=\"#\">2</a></li>\r\n");
      out.write("                                <li><a href=\"#\">3</a></li>\r\n");
      out.write("                                <li><a href=\"#\">4</a></li>\r\n");
      out.write("                                <li><a href=\"#\">&gt;&gt;</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div> -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"footer\" style=\"width: 97%;\">\r\n");
      out.write("\t\t<div class=\"navbar\">\r\n");
      out.write("\t\t\t<div class=\"navbar-inner\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"pull-right\">Back to top</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"copyright\">\r\n");
      out.write("\t\t\t<a target=\"_blank\" href=\"http://www.citigroup.net/CITINETWebApp/\">\r\n");
      out.write("\t\t\t</a> <span>Gekko é um programa de gerenciamento de ocorrências de\r\n");
      out.write("\t\t\t\tprojeto.</span> <span class=\"pull-right copyright\"> &copy; 2014\r\n");
      out.write("\t\t\t\tGekko Bug Tracker.</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
    // /WEB-INF/pages/report-project-occurrences.jsp(10,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
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
}

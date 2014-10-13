package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jspx extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/tags/menu/menu.tagx");
    _jspx_dependants.add("/WEB-INF/tags/menu/category.tagx");
    _jspx_dependants.add("/WEB-INF/tags/menu/item.tagx");
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

      out.write("<div version=\"2.0\" id=\"menu\">");
      if (_jspx_meth_menu_menu_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_menu_menu_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:menu
    org.apache.jsp.tag.web.menu.menu_tagx _jspx_th_menu_menu_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.menu_tagx.class) : new org.apache.jsp.tag.web.menu.menu_tagx();
    _jspx_th_menu_menu_0.setJspContext(_jspx_page_context);
    _jspx_th_menu_menu_0.setZ("nZaf43BjUg1iM0v70HJVEsXDopc=");
    _jspx_th_menu_menu_0.setId("_menu");
    _jspx_th_menu_menu_0.setJspBody(new menu_jspxHelper( 0, _jspx_page_context, _jspx_th_menu_menu_0, null));
    _jspx_th_menu_menu_0.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_0.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_0.setParent(_jspx_parent);
    _jspx_th_menu_category_0.setZ("5VkP9PNtM/yUJ+cBYPa+uymTRHw=");
    _jspx_th_menu_category_0.setId("c_controlpago");
    _jspx_th_menu_category_0.setJspBody(new menu_jspxHelper( 1, _jspx_page_context, _jspx_th_menu_category_0, null));
    _jspx_th_menu_category_0.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_0.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_0.setParent(_jspx_parent);
    _jspx_th_menu_item_0.setZ("pes8x/9ogcbndPFjkNQtewiK81U=");
    _jspx_th_menu_item_0.setUrl("/controlpagoes?form");
    _jspx_th_menu_item_0.setMessageCode("global_menu_new");
    _jspx_th_menu_item_0.setId("i_controlpago_new");
    _jspx_th_menu_item_0.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_1.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_1.setParent(_jspx_parent);
    _jspx_th_menu_item_1.setZ("KKnUhIlqSUwBjwsSyO5+iRTwrzU=");
    _jspx_th_menu_item_1.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/controlpagoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_1.setMessageCode("global_menu_list");
    _jspx_th_menu_item_1.setId("i_controlpago_list");
    _jspx_th_menu_item_1.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_1.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_1.setParent(_jspx_parent);
    _jspx_th_menu_category_1.setZ("9DpPm6uw05uI7f7futD7J6LUbqg=");
    _jspx_th_menu_category_1.setId("c_jugador");
    _jspx_th_menu_category_1.setJspBody(new menu_jspxHelper( 2, _jspx_page_context, _jspx_th_menu_category_1, null));
    _jspx_th_menu_category_1.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_2(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_2.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_2.setParent(_jspx_parent);
    _jspx_th_menu_item_2.setZ("PEIdlK0KjDfSbIpPZLSfV/ypjeM=");
    _jspx_th_menu_item_2.setUrl("/jugadors?form");
    _jspx_th_menu_item_2.setMessageCode("global_menu_new");
    _jspx_th_menu_item_2.setId("i_jugador_new");
    _jspx_th_menu_item_2.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_3(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_3.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_3.setParent(_jspx_parent);
    _jspx_th_menu_item_3.setZ("E0yo6z/UGOawkLyXTWSuJzyaaD8=");
    _jspx_th_menu_item_3.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_3.setMessageCode("global_menu_list");
    _jspx_th_menu_item_3.setId("i_jugador_list");
    _jspx_th_menu_item_3.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_4(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_4.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_4.setParent(_jspx_parent);
    _jspx_th_menu_item_4.setZ("dhWd24b3I2ognX9BuHJcG376YLc=");
    _jspx_th_menu_item_4.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_4.setMessageCode("global_menu_find");
    _jspx_th_menu_item_4.setId("fi_jugador_equipoandactivo");
    _jspx_th_menu_item_4.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_5(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_5 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_5.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_5.setParent(_jspx_parent);
    _jspx_th_menu_item_5.setZ("+CjSa4TBsFjRkiTDkPx6g13icXs=");
    _jspx_th_menu_item_5.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndEsDelegadoAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_5.setMessageCode("global_menu_find");
    _jspx_th_menu_item_5.setId("fi_jugador_equipoandesdelegadoandactivo");
    _jspx_th_menu_item_5.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_6(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_6 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_6.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_6.setParent(_jspx_parent);
    _jspx_th_menu_item_6.setZ("YG2ZV6gc7hQGv948A496k+urJq0=");
    _jspx_th_menu_item_6.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndNombreLikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_6.setMessageCode("global_menu_find");
    _jspx_th_menu_item_6.setId("fi_jugador_equipoandnombrelikeandactivo");
    _jspx_th_menu_item_6.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_7(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_7 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_7.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_7.setParent(_jspx_parent);
    _jspx_th_menu_item_7.setZ("g8BLB3Odx/xdtdI3q0P9wWAZk6w=");
    _jspx_th_menu_item_7.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_7.setMessageCode("global_menu_find");
    _jspx_th_menu_item_7.setId("fi_jugador_equipoandnombrelikeandapellidopaternolikeandactivo");
    _jspx_th_menu_item_7.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_8(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_8 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_8.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_8.setParent(_jspx_parent);
    _jspx_th_menu_item_8.setZ("Kke6Z81xEzMbbcis6JZ6ybUVl/Y=");
    _jspx_th_menu_item_8.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndPosicionAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_8.setMessageCode("global_menu_find");
    _jspx_th_menu_item_8.setId("fi_jugador_equipoandposicionandactivo");
    _jspx_th_menu_item_8.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_9(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_9 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_9.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_9.setParent(_jspx_parent);
    _jspx_th_menu_item_9.setZ("IZsz01MTpOp7PooQEMKvyU2iTko=");
    _jspx_th_menu_item_9.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/jugadors?find=ByEquipoAndStatusAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_9.setMessageCode("global_menu_find");
    _jspx_th_menu_item_9.setId("fi_jugador_equipoandstatusandactivo");
    _jspx_th_menu_item_9.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_2(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_2.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_2.setParent(_jspx_parent);
    _jspx_th_menu_category_2.setZ("wwMQUILt/puEegMlBIpsdYOrEDA=");
    _jspx_th_menu_category_2.setId("c_horario");
    _jspx_th_menu_category_2.setJspBody(new menu_jspxHelper( 3, _jspx_page_context, _jspx_th_menu_category_2, null));
    _jspx_th_menu_category_2.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_10(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_10 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_10.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_10.setParent(_jspx_parent);
    _jspx_th_menu_item_10.setZ("VliB2jFUrOQQbJkrlvuYvfN28XY=");
    _jspx_th_menu_item_10.setUrl("/horarios?form");
    _jspx_th_menu_item_10.setMessageCode("global_menu_new");
    _jspx_th_menu_item_10.setId("i_horario_new");
    _jspx_th_menu_item_10.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_11(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_11 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_11.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_11.setParent(_jspx_parent);
    _jspx_th_menu_item_11.setZ("rHpyuay2/HmCjKYCqS2WaJXLYQ8=");
    _jspx_th_menu_item_11.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/horarios?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_11.setMessageCode("global_menu_list");
    _jspx_th_menu_item_11.setId("i_horario_list");
    _jspx_th_menu_item_11.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_12(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_12 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_12.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_12.setParent(_jspx_parent);
    _jspx_th_menu_item_12.setZ("r8oE9g4KdW16DX1AeQzTwg21Q3U=");
    _jspx_th_menu_item_12.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/horarios?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_12.setMessageCode("global_menu_find");
    _jspx_th_menu_item_12.setId("fi_horario_activo");
    _jspx_th_menu_item_12.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_13(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_13 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_13.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_13.setParent(_jspx_parent);
    _jspx_th_menu_item_13.setZ("aRvC1hFkpp6QSdcaRw4DuXKLlkQ=");
    _jspx_th_menu_item_13.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/horarios?find=ByCanchaAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_13.setMessageCode("global_menu_find");
    _jspx_th_menu_item_13.setId("fi_horario_canchaandactivo");
    _jspx_th_menu_item_13.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_3(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_3.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_3.setParent(_jspx_parent);
    _jspx_th_menu_category_3.setZ("g6oG0656PcsmmvUYeBtpgiQROck=");
    _jspx_th_menu_category_3.setId("c_usuario");
    _jspx_th_menu_category_3.setJspBody(new menu_jspxHelper( 4, _jspx_page_context, _jspx_th_menu_category_3, null));
    _jspx_th_menu_category_3.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_14(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_14 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_14.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_14.setParent(_jspx_parent);
    _jspx_th_menu_item_14.setZ("RG1gCsiZQjg1HLDzXbHKht6yDkw=");
    _jspx_th_menu_item_14.setUrl("/usuarios?form");
    _jspx_th_menu_item_14.setMessageCode("global_menu_new");
    _jspx_th_menu_item_14.setId("i_usuario_new");
    _jspx_th_menu_item_14.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_15(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_15 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_15.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_15.setParent(_jspx_parent);
    _jspx_th_menu_item_15.setZ("P7ZIPrcTTBR41JYD0QldbYgsZrM=");
    _jspx_th_menu_item_15.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_15.setMessageCode("global_menu_list");
    _jspx_th_menu_item_15.setId("i_usuario_list");
    _jspx_th_menu_item_15.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_16(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_16 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_16.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_16.setParent(_jspx_parent);
    _jspx_th_menu_item_16.setZ("wboTvEV88mjtVSm9mBqmDoEziyc=");
    _jspx_th_menu_item_16.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?find=ByApellidoPaternoLike&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_16.setMessageCode("global_menu_find");
    _jspx_th_menu_item_16.setId("fi_usuario_apellidopaternolike");
    _jspx_th_menu_item_16.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_17(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_17 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_17.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_17.setParent(_jspx_parent);
    _jspx_th_menu_item_17.setZ("fDw8QjBQATxYSd+tOzqAhtodUEc=");
    _jspx_th_menu_item_17.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?find=ByEmpresaAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_17.setMessageCode("global_menu_find");
    _jspx_th_menu_item_17.setId("fi_usuario_empresaandactivo");
    _jspx_th_menu_item_17.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_18(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_18 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_18.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_18.setParent(_jspx_parent);
    _jspx_th_menu_item_18.setZ("kCE5NEvaX5kzFhDSXNLZxI1bQ5A=");
    _jspx_th_menu_item_18.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?find=ByEmpresaAndNombreLikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_18.setMessageCode("global_menu_find");
    _jspx_th_menu_item_18.setId("fi_usuario_empresaandnombrelikeandactivo");
    _jspx_th_menu_item_18.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_19(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_19 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_19.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_19.setParent(_jspx_parent);
    _jspx_th_menu_item_19.setZ("vp+MzFQjvoxyNPJdQW9yt5KD6rI=");
    _jspx_th_menu_item_19.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?find=ByEmpresaCorreoELikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_19.setMessageCode("global_menu_find");
    _jspx_th_menu_item_19.setId("fi_usuario_empresacorreoelikeandactivo");
    _jspx_th_menu_item_19.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_20(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_20 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_20.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_20.setParent(_jspx_parent);
    _jspx_th_menu_item_20.setZ("MIXXCEBRglAhfQempCT+k6sTmIY=");
    _jspx_th_menu_item_20.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/usuarios?find=ByRolAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_20.setMessageCode("global_menu_find");
    _jspx_th_menu_item_20.setId("fi_usuario_rolandactivo");
    _jspx_th_menu_item_20.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_4(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_4.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_4.setParent(_jspx_parent);
    _jspx_th_menu_category_4.setZ("JXxDWRt6MJkcWD/nFAURHFSgaCo=");
    _jspx_th_menu_category_4.setId("c_tipopartido");
    _jspx_th_menu_category_4.setJspBody(new menu_jspxHelper( 5, _jspx_page_context, _jspx_th_menu_category_4, null));
    _jspx_th_menu_category_4.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_21(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_21 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_21.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_21.setParent(_jspx_parent);
    _jspx_th_menu_item_21.setZ("JthaZ46sVODUMsV5lZrR5/06dUo=");
    _jspx_th_menu_item_21.setUrl("/tipopartidoes?form");
    _jspx_th_menu_item_21.setMessageCode("global_menu_new");
    _jspx_th_menu_item_21.setId("i_tipopartido_new");
    _jspx_th_menu_item_21.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_22(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_22 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_22.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_22.setParent(_jspx_parent);
    _jspx_th_menu_item_22.setZ("o5IOM1UD/k7w4202ExHQVOqF9ic=");
    _jspx_th_menu_item_22.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/tipopartidoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_22.setMessageCode("global_menu_list");
    _jspx_th_menu_item_22.setId("i_tipopartido_list");
    _jspx_th_menu_item_22.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_5(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_5 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_5.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_5.setParent(_jspx_parent);
    _jspx_th_menu_category_5.setZ("eaRhWebCzPow/t7l9t/Rou//smA=");
    _jspx_th_menu_category_5.setId("c_statusequipojugador");
    _jspx_th_menu_category_5.setJspBody(new menu_jspxHelper( 6, _jspx_page_context, _jspx_th_menu_category_5, null));
    _jspx_th_menu_category_5.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_23(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_23 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_23.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_23.setParent(_jspx_parent);
    _jspx_th_menu_item_23.setZ("7w+ouP7tGeFg42yiBLNNo+gRcY4=");
    _jspx_th_menu_item_23.setUrl("/statusequipojugadors?form");
    _jspx_th_menu_item_23.setMessageCode("global_menu_new");
    _jspx_th_menu_item_23.setId("i_statusequipojugador_new");
    _jspx_th_menu_item_23.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_24(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_24 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_24.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_24.setParent(_jspx_parent);
    _jspx_th_menu_item_24.setZ("iOEXo2kXNiS+1rq7tc1WN7cv+3E=");
    _jspx_th_menu_item_24.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statusequipojugadors?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_24.setMessageCode("global_menu_list");
    _jspx_th_menu_item_24.setId("i_statusequipojugador_list");
    _jspx_th_menu_item_24.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_25(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_25 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_25.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_25.setParent(_jspx_parent);
    _jspx_th_menu_item_25.setZ("44Qr8wF1tv1dHprsZ5xlqrIE9WI=");
    _jspx_th_menu_item_25.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statusequipojugadors?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_25.setMessageCode("global_menu_find");
    _jspx_th_menu_item_25.setId("fi_statusequipojugador_activo");
    _jspx_th_menu_item_25.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_6(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_6 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_6.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_6.setParent(_jspx_parent);
    _jspx_th_menu_category_6.setZ("auBnhrcx2gmAy1iWkbGsbMf3FJc=");
    _jspx_th_menu_category_6.setId("c_configuraciontorneo");
    _jspx_th_menu_category_6.setJspBody(new menu_jspxHelper( 7, _jspx_page_context, _jspx_th_menu_category_6, null));
    _jspx_th_menu_category_6.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_26(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_26 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_26.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_26.setParent(_jspx_parent);
    _jspx_th_menu_item_26.setZ("NldFBip+P+4eVeMA6M64RxXgV0k=");
    _jspx_th_menu_item_26.setUrl("/configuraciontorneos?form");
    _jspx_th_menu_item_26.setMessageCode("global_menu_new");
    _jspx_th_menu_item_26.setId("i_configuraciontorneo_new");
    _jspx_th_menu_item_26.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_27(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_27 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_27.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_27.setParent(_jspx_parent);
    _jspx_th_menu_item_27.setZ("glIQ9WZ9z2gAH4eTdBtGTZO+8BU=");
    _jspx_th_menu_item_27.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/configuraciontorneos?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_27.setMessageCode("global_menu_list");
    _jspx_th_menu_item_27.setId("i_configuraciontorneo_list");
    _jspx_th_menu_item_27.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_28(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_28 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_28.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_28.setParent(_jspx_parent);
    _jspx_th_menu_item_28.setZ("5VV/YUG40RduqzIGIsucX+r3BLQ=");
    _jspx_th_menu_item_28.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/configuraciontorneos?find=ByInscripcionAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_28.setMessageCode("global_menu_find");
    _jspx_th_menu_item_28.setId("fi_configuraciontorneo_inscripcionandactivo");
    _jspx_th_menu_item_28.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_29(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_29 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_29.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_29.setParent(_jspx_parent);
    _jspx_th_menu_item_29.setZ("/suc4em+x7z0E0DYjZC2m8AMJL0=");
    _jspx_th_menu_item_29.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/configuraciontorneos?find=ByTipoCobroAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_29.setMessageCode("global_menu_find");
    _jspx_th_menu_item_29.setId("fi_configuraciontorneo_tipocobroandactivo");
    _jspx_th_menu_item_29.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_30(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_30 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_30.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_30.setParent(_jspx_parent);
    _jspx_th_menu_item_30.setZ("I96iuXFe9yq0ZCDr0d7Gx7CMqeE=");
    _jspx_th_menu_item_30.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/configuraciontorneos?find=ByTorneoAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_30.setMessageCode("global_menu_find");
    _jspx_th_menu_item_30.setId("fi_configuraciontorneo_torneoandactivo");
    _jspx_th_menu_item_30.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_7(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_7 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_7.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_7.setParent(_jspx_parent);
    _jspx_th_menu_category_7.setZ("ffPx6Jld1H6Oxq9W5CdoYjrUruw=");
    _jspx_th_menu_category_7.setId("c_estadisticas");
    _jspx_th_menu_category_7.setJspBody(new menu_jspxHelper( 8, _jspx_page_context, _jspx_th_menu_category_7, null));
    _jspx_th_menu_category_7.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_31(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_31 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_31.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_31.setParent(_jspx_parent);
    _jspx_th_menu_item_31.setZ("I0J3TE/0G5ubuN+MjzFzZGwZeHE=");
    _jspx_th_menu_item_31.setUrl("/estadisticases?form");
    _jspx_th_menu_item_31.setMessageCode("global_menu_new");
    _jspx_th_menu_item_31.setId("i_estadisticas_new");
    _jspx_th_menu_item_31.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_32(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_32 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_32.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_32.setParent(_jspx_parent);
    _jspx_th_menu_item_32.setZ("RNFjPPOiGBSGtYpxsvBg59Sehb8=");
    _jspx_th_menu_item_32.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/estadisticases?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_32.setMessageCode("global_menu_list");
    _jspx_th_menu_item_32.setId("i_estadisticas_list");
    _jspx_th_menu_item_32.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_33(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_33 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_33.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_33.setParent(_jspx_parent);
    _jspx_th_menu_item_33.setZ("HUCS2Btf4pkNp4RjPhob+rQQhdU=");
    _jspx_th_menu_item_33.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/estadisticases?find=ByAccion&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_33.setMessageCode("global_menu_find");
    _jspx_th_menu_item_33.setId("fi_estadisticas_accion");
    _jspx_th_menu_item_33.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_34(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_34 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_34.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_34.setParent(_jspx_parent);
    _jspx_th_menu_item_34.setZ("vWmx3caSeVvdfTlZ9xYScME+yxI=");
    _jspx_th_menu_item_34.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/estadisticases?find=ByAlineacion&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_34.setMessageCode("global_menu_find");
    _jspx_th_menu_item_34.setId("fi_estadisticas_alineacion");
    _jspx_th_menu_item_34.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_8(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_8 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_8.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_8.setParent(_jspx_parent);
    _jspx_th_menu_category_8.setZ("qN2r56zm5K6QnxDWJ00gRZ+bu84=");
    _jspx_th_menu_category_8.setId("c_sucursal");
    _jspx_th_menu_category_8.setJspBody(new menu_jspxHelper( 9, _jspx_page_context, _jspx_th_menu_category_8, null));
    _jspx_th_menu_category_8.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_35(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_35 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_35.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_35.setParent(_jspx_parent);
    _jspx_th_menu_item_35.setZ("6dxGCPOx1Gd5cL3kYmOux/+989c=");
    _jspx_th_menu_item_35.setUrl("/sucursals?form");
    _jspx_th_menu_item_35.setMessageCode("global_menu_new");
    _jspx_th_menu_item_35.setId("i_sucursal_new");
    _jspx_th_menu_item_35.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_36(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_36 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_36.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_36.setParent(_jspx_parent);
    _jspx_th_menu_item_36.setZ("Rkn6g9K8ST6KwVdqSD+GGmucSdU=");
    _jspx_th_menu_item_36.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/sucursals?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_36.setMessageCode("global_menu_list");
    _jspx_th_menu_item_36.setId("i_sucursal_list");
    _jspx_th_menu_item_36.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_37(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_37 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_37.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_37.setParent(_jspx_parent);
    _jspx_th_menu_item_37.setZ("/huBljmfZ4Y80CzsOjFCv9SStW0=");
    _jspx_th_menu_item_37.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/sucursals?find=ByEmpresaAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_37.setMessageCode("global_menu_find");
    _jspx_th_menu_item_37.setId("fi_sucursal_empresaandactivo");
    _jspx_th_menu_item_37.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_9(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_9 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_9.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_9.setParent(_jspx_parent);
    _jspx_th_menu_category_9.setZ("ztJ0gaTDnNILW7X2LFh9js5bmlU=");
    _jspx_th_menu_category_9.setId("c_accion");
    _jspx_th_menu_category_9.setJspBody(new menu_jspxHelper( 10, _jspx_page_context, _jspx_th_menu_category_9, null));
    _jspx_th_menu_category_9.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_38(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_38 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_38.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_38.setParent(_jspx_parent);
    _jspx_th_menu_item_38.setZ("XHM6pnMxyTk3oRAkOM4vLRUN7Oc=");
    _jspx_th_menu_item_38.setUrl("/accions?form");
    _jspx_th_menu_item_38.setMessageCode("global_menu_new");
    _jspx_th_menu_item_38.setId("i_accion_new");
    _jspx_th_menu_item_38.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_39(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_39 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_39.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_39.setParent(_jspx_parent);
    _jspx_th_menu_item_39.setZ("J0A/Kij65zXnYz91Z3EJUjL0YIE=");
    _jspx_th_menu_item_39.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/accions?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_39.setMessageCode("global_menu_list");
    _jspx_th_menu_item_39.setId("i_accion_list");
    _jspx_th_menu_item_39.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_40(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_40 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_40.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_40.setParent(_jspx_parent);
    _jspx_th_menu_item_40.setZ("IeWXIEh4SDZ/pGQvXQCDmUyMb60=");
    _jspx_th_menu_item_40.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/accions?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_40.setMessageCode("global_menu_find");
    _jspx_th_menu_item_40.setId("fi_accion_activo");
    _jspx_th_menu_item_40.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_10(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_10 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_10.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_10.setParent(_jspx_parent);
    _jspx_th_menu_category_10.setZ("HcfIQY0Fnv+trM/s0WB8JpFykn0=");
    _jspx_th_menu_category_10.setId("c_alineacion");
    _jspx_th_menu_category_10.setJspBody(new menu_jspxHelper( 11, _jspx_page_context, _jspx_th_menu_category_10, null));
    _jspx_th_menu_category_10.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_41(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_41 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_41.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_41.setParent(_jspx_parent);
    _jspx_th_menu_item_41.setZ("zrI15mOa2D4DZfzjLJpagyqYwV0=");
    _jspx_th_menu_item_41.setUrl("/alineacions?form");
    _jspx_th_menu_item_41.setMessageCode("global_menu_new");
    _jspx_th_menu_item_41.setId("i_alineacion_new");
    _jspx_th_menu_item_41.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_42(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_42 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_42.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_42.setParent(_jspx_parent);
    _jspx_th_menu_item_42.setZ("kXrf7M/WIBMkcjuBams/0b9vDfI=");
    _jspx_th_menu_item_42.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/alineacions?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_42.setMessageCode("global_menu_list");
    _jspx_th_menu_item_42.setId("i_alineacion_list");
    _jspx_th_menu_item_42.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_43(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_43 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_43.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_43.setParent(_jspx_parent);
    _jspx_th_menu_item_43.setZ("NFRDmd1P5rZet/9RO700Rs5nUcg=");
    _jspx_th_menu_item_43.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/alineacions?find=ByJugador&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_43.setMessageCode("global_menu_find");
    _jspx_th_menu_item_43.setId("fi_alineacion_jugador");
    _jspx_th_menu_item_43.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_44(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_44 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_44.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_44.setParent(_jspx_parent);
    _jspx_th_menu_item_44.setZ("hIV6f8/hwUSlm2R7upD8CnoJVOk=");
    _jspx_th_menu_item_44.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/alineacions?find=ByJugadorAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_44.setMessageCode("global_menu_find");
    _jspx_th_menu_item_44.setId("fi_alineacion_jugadorandfechacreacionbetween");
    _jspx_th_menu_item_44.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_45(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_45 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_45.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_45.setParent(_jspx_parent);
    _jspx_th_menu_item_45.setZ("vKncydqfjoLwp8cucRKWoKSjN/c=");
    _jspx_th_menu_item_45.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/alineacions?find=ByPartido&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_45.setMessageCode("global_menu_find");
    _jspx_th_menu_item_45.setId("fi_alineacion_partido");
    _jspx_th_menu_item_45.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_46(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_46 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_46.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_46.setParent(_jspx_parent);
    _jspx_th_menu_item_46.setZ("/Neh0WQDKKU1sFGXlLdny0HO9PQ=");
    _jspx_th_menu_item_46.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/alineacions?find=ByPartidoAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_46.setMessageCode("global_menu_find");
    _jspx_th_menu_item_46.setId("fi_alineacion_partidoandfechacreacionbetween");
    _jspx_th_menu_item_46.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_11(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_11 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_11.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_11.setParent(_jspx_parent);
    _jspx_th_menu_category_11.setZ("ivaY1Ww5zsZQWJ84p4lPq713Nf0=");
    _jspx_th_menu_category_11.setId("c_metodopago");
    _jspx_th_menu_category_11.setJspBody(new menu_jspxHelper( 12, _jspx_page_context, _jspx_th_menu_category_11, null));
    _jspx_th_menu_category_11.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_47(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_47 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_47.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_47.setParent(_jspx_parent);
    _jspx_th_menu_item_47.setZ("zD6WNqrEpRlwtGZvb/9F1ylZ5jA=");
    _jspx_th_menu_item_47.setUrl("/metodopagoes?form");
    _jspx_th_menu_item_47.setMessageCode("global_menu_new");
    _jspx_th_menu_item_47.setId("i_metodopago_new");
    _jspx_th_menu_item_47.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_48(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_48 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_48.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_48.setParent(_jspx_parent);
    _jspx_th_menu_item_48.setZ("v3V2nLlh/mJtkbUyrWKGzbA5f8Q=");
    _jspx_th_menu_item_48.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/metodopagoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_48.setMessageCode("global_menu_list");
    _jspx_th_menu_item_48.setId("i_metodopago_list");
    _jspx_th_menu_item_48.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_49(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_49 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_49.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_49.setParent(_jspx_parent);
    _jspx_th_menu_item_49.setZ("iRqVlAV3MnCEvxNPiMjbsTlgUKE=");
    _jspx_th_menu_item_49.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/metodopagoes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_49.setMessageCode("global_menu_find");
    _jspx_th_menu_item_49.setId("fi_metodopago_activo");
    _jspx_th_menu_item_49.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_12(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_12 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_12.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_12.setParent(_jspx_parent);
    _jspx_th_menu_category_12.setZ("2LBVRSm6Xc4kX2apzL7yJvN6LE0=");
    _jspx_th_menu_category_12.setId("c_fechavencimientotc");
    _jspx_th_menu_category_12.setJspBody(new menu_jspxHelper( 13, _jspx_page_context, _jspx_th_menu_category_12, null));
    _jspx_th_menu_category_12.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_50(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_50 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_50.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_50.setParent(_jspx_parent);
    _jspx_th_menu_item_50.setZ("T9DKwau9NltMs1BBXgc6fRhM9gY=");
    _jspx_th_menu_item_50.setUrl("/fechavencimientotcs?form");
    _jspx_th_menu_item_50.setMessageCode("global_menu_new");
    _jspx_th_menu_item_50.setId("i_fechavencimientotc_new");
    _jspx_th_menu_item_50.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_51(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_51 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_51.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_51.setParent(_jspx_parent);
    _jspx_th_menu_item_51.setZ("Xs7WMrae/Dd5XjdDmcySZwMKsfc=");
    _jspx_th_menu_item_51.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/fechavencimientotcs?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_51.setMessageCode("global_menu_list");
    _jspx_th_menu_item_51.setId("i_fechavencimientotc_list");
    _jspx_th_menu_item_51.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_52(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_52 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_52.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_52.setParent(_jspx_parent);
    _jspx_th_menu_item_52.setZ("eni6UtXhUBLi3pdJtEcrArCuDtE=");
    _jspx_th_menu_item_52.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/fechavencimientotcs?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_52.setMessageCode("global_menu_find");
    _jspx_th_menu_item_52.setId("fi_fechavencimientotc_activo");
    _jspx_th_menu_item_52.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_13(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_13 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_13.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_13.setParent(_jspx_parent);
    _jspx_th_menu_category_13.setZ("TJQIqxlnCFe0ttJYkvPRqOhfBD4=");
    _jspx_th_menu_category_13.setId("c_conceptocobro");
    _jspx_th_menu_category_13.setJspBody(new menu_jspxHelper( 14, _jspx_page_context, _jspx_th_menu_category_13, null));
    _jspx_th_menu_category_13.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_53(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_53 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_53.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_53.setParent(_jspx_parent);
    _jspx_th_menu_item_53.setZ("Sl254jJ7D32rdCXCwcKLu2ubIK0=");
    _jspx_th_menu_item_53.setUrl("/conceptocobroes?form");
    _jspx_th_menu_item_53.setMessageCode("global_menu_new");
    _jspx_th_menu_item_53.setId("i_conceptocobro_new");
    _jspx_th_menu_item_53.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_54(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_54 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_54.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_54.setParent(_jspx_parent);
    _jspx_th_menu_item_54.setZ("0EBHwNt+erLsNuQcDNFkq+KUShM=");
    _jspx_th_menu_item_54.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/conceptocobroes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_54.setMessageCode("global_menu_list");
    _jspx_th_menu_item_54.setId("i_conceptocobro_list");
    _jspx_th_menu_item_54.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_55(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_55 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_55.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_55.setParent(_jspx_parent);
    _jspx_th_menu_item_55.setZ("qg/WJGrm3CY+Y0VyKbIWJVoRK+E=");
    _jspx_th_menu_item_55.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/conceptocobroes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_55.setMessageCode("global_menu_find");
    _jspx_th_menu_item_55.setId("fi_conceptocobro_activo");
    _jspx_th_menu_item_55.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_14(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_14 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_14.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_14.setParent(_jspx_parent);
    _jspx_th_menu_category_14.setZ("UouYJGaZxe9M0wR/1bpWr8k5Aac=");
    _jspx_th_menu_category_14.setId("c_statuscedula");
    _jspx_th_menu_category_14.setJspBody(new menu_jspxHelper( 15, _jspx_page_context, _jspx_th_menu_category_14, null));
    _jspx_th_menu_category_14.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_56(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_56 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_56.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_56.setParent(_jspx_parent);
    _jspx_th_menu_item_56.setZ("DUNTsz5U1swOMUNNHlaIcsFn5lc=");
    _jspx_th_menu_item_56.setUrl("/statuscedulas?form");
    _jspx_th_menu_item_56.setMessageCode("global_menu_new");
    _jspx_th_menu_item_56.setId("i_statuscedula_new");
    _jspx_th_menu_item_56.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_57(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_57 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_57.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_57.setParent(_jspx_parent);
    _jspx_th_menu_item_57.setZ("YBAKyOdLaDRHWHOPc6RMtKpKaO8=");
    _jspx_th_menu_item_57.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuscedulas?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_57.setMessageCode("global_menu_list");
    _jspx_th_menu_item_57.setId("i_statuscedula_list");
    _jspx_th_menu_item_57.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_58(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_58 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_58.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_58.setParent(_jspx_parent);
    _jspx_th_menu_item_58.setZ("dWAq2rsFLDHuMejjgTdb9NUOphs=");
    _jspx_th_menu_item_58.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuscedulas?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_58.setMessageCode("global_menu_find");
    _jspx_th_menu_item_58.setId("fi_statuscedula_activo");
    _jspx_th_menu_item_58.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_15(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_15 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_15.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_15.setParent(_jspx_parent);
    _jspx_th_menu_category_15.setZ("iIzmodmLleLNiks5AmT8DMYjGLw=");
    _jspx_th_menu_category_15.setId("c_posicion");
    _jspx_th_menu_category_15.setJspBody(new menu_jspxHelper( 16, _jspx_page_context, _jspx_th_menu_category_15, null));
    _jspx_th_menu_category_15.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_59(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_59 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_59.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_59.setParent(_jspx_parent);
    _jspx_th_menu_item_59.setZ("gWmNqHEj2mj/dEGMy9YYroW1y/g=");
    _jspx_th_menu_item_59.setUrl("/posicions?form");
    _jspx_th_menu_item_59.setMessageCode("global_menu_new");
    _jspx_th_menu_item_59.setId("i_posicion_new");
    _jspx_th_menu_item_59.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_60(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_60 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_60.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_60.setParent(_jspx_parent);
    _jspx_th_menu_item_60.setZ("ElG+ypMn/gMVuua2yHqD6UPEnVY=");
    _jspx_th_menu_item_60.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/posicions?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_60.setMessageCode("global_menu_list");
    _jspx_th_menu_item_60.setId("i_posicion_list");
    _jspx_th_menu_item_60.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_61(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_61 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_61.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_61.setParent(_jspx_parent);
    _jspx_th_menu_item_61.setZ("zypaHEkfBGKjy3hyvDm3MfJ2yuU=");
    _jspx_th_menu_item_61.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/posicions?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_61.setMessageCode("global_menu_find");
    _jspx_th_menu_item_61.setId("fi_posicion_activo");
    _jspx_th_menu_item_61.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_16(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_16 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_16.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_16.setParent(_jspx_parent);
    _jspx_th_menu_category_16.setZ("1rq/0DZ2QlAFLA9GH9ShzVTKVQo=");
    _jspx_th_menu_category_16.setId("c_abono");
    _jspx_th_menu_category_16.setJspBody(new menu_jspxHelper( 17, _jspx_page_context, _jspx_th_menu_category_16, null));
    _jspx_th_menu_category_16.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_62(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_62 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_62.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_62.setParent(_jspx_parent);
    _jspx_th_menu_item_62.setZ("/g1rZOnFPzWqiiyzFQro0JGlZt8=");
    _jspx_th_menu_item_62.setUrl("/abonoes?form");
    _jspx_th_menu_item_62.setMessageCode("global_menu_new");
    _jspx_th_menu_item_62.setId("i_abono_new");
    _jspx_th_menu_item_62.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_63(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_63 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_63.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_63.setParent(_jspx_parent);
    _jspx_th_menu_item_63.setZ("5c3kFvwPzQwPgR6qoD3BFQFkpzI=");
    _jspx_th_menu_item_63.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/abonoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_63.setMessageCode("global_menu_list");
    _jspx_th_menu_item_63.setId("i_abono_list");
    _jspx_th_menu_item_63.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_64(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_64 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_64.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_64.setParent(_jspx_parent);
    _jspx_th_menu_item_64.setZ("e8zSlcYpPCJKKmPVsVtsweREKGo=");
    _jspx_th_menu_item_64.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/abonoes?find=ByCargoAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_64.setMessageCode("global_menu_find");
    _jspx_th_menu_item_64.setId("fi_abono_cargoandfechacreacionbetween");
    _jspx_th_menu_item_64.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_65(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_65 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_65.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_65.setParent(_jspx_parent);
    _jspx_th_menu_item_65.setZ("UgdNlMuCCtOYyvV3CgLQIPlwQK4=");
    _jspx_th_menu_item_65.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/abonoes?find=ByDescuentoAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_65.setMessageCode("global_menu_find");
    _jspx_th_menu_item_65.setId("fi_abono_descuentoandfechacreacionbetween");
    _jspx_th_menu_item_65.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_66(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_66 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_66.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_66.setParent(_jspx_parent);
    _jspx_th_menu_item_66.setZ("KI9wt644IrE4YRfUFfp0DIZ6yqk=");
    _jspx_th_menu_item_66.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/abonoes?find=ByMetodoPagoAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_66.setMessageCode("global_menu_find");
    _jspx_th_menu_item_66.setId("fi_abono_metodopagoandfechacreacionbetween");
    _jspx_th_menu_item_66.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_67(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_67 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_67.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_67.setParent(_jspx_parent);
    _jspx_th_menu_item_67.setZ("lW2/V0Ghi3+0OAqglUnuMSj3Nkg=");
    _jspx_th_menu_item_67.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/abonoes?find=ByStatusAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_67.setMessageCode("global_menu_find");
    _jspx_th_menu_item_67.setId("fi_abono_statusandfechacreacionbetween");
    _jspx_th_menu_item_67.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_17(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_17 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_17.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_17.setParent(_jspx_parent);
    _jspx_th_menu_category_17.setZ("PBJXO5cEtKap3FdJmF+wKbQSFh0=");
    _jspx_th_menu_category_17.setId("c_statuscargoabono");
    _jspx_th_menu_category_17.setJspBody(new menu_jspxHelper( 18, _jspx_page_context, _jspx_th_menu_category_17, null));
    _jspx_th_menu_category_17.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_68(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_68 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_68.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_68.setParent(_jspx_parent);
    _jspx_th_menu_item_68.setZ("IP6L7+VheZuuYc3LSVX2puzyj7w=");
    _jspx_th_menu_item_68.setUrl("/statuscargoabonoes?form");
    _jspx_th_menu_item_68.setMessageCode("global_menu_new");
    _jspx_th_menu_item_68.setId("i_statuscargoabono_new");
    _jspx_th_menu_item_68.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_69(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_69 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_69.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_69.setParent(_jspx_parent);
    _jspx_th_menu_item_69.setZ("VsCHOFP7y5tOXJS6wvtL9KX75o4=");
    _jspx_th_menu_item_69.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuscargoabonoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_69.setMessageCode("global_menu_list");
    _jspx_th_menu_item_69.setId("i_statuscargoabono_list");
    _jspx_th_menu_item_69.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_70(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_70 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_70.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_70.setParent(_jspx_parent);
    _jspx_th_menu_item_70.setZ("+XYKfvoApV98p7f6uYMzxyPC7Qc=");
    _jspx_th_menu_item_70.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuscargoabonoes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_70.setMessageCode("global_menu_find");
    _jspx_th_menu_item_70.setId("fi_statuscargoabono_activo");
    _jspx_th_menu_item_70.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_18(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_18 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_18.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_18.setParent(_jspx_parent);
    _jspx_th_menu_category_18.setZ("Xjy5A0or4vG6vbTqn6rhxV9JsiY=");
    _jspx_th_menu_category_18.setId("c_torneo");
    _jspx_th_menu_category_18.setJspBody(new menu_jspxHelper( 19, _jspx_page_context, _jspx_th_menu_category_18, null));
    _jspx_th_menu_category_18.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_71(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_71 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_71.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_71.setParent(_jspx_parent);
    _jspx_th_menu_item_71.setZ("MUYrHLKrU+r0QFqxdoDUe+aclWw=");
    _jspx_th_menu_item_71.setUrl("/torneos?form");
    _jspx_th_menu_item_71.setMessageCode("global_menu_new");
    _jspx_th_menu_item_71.setId("i_torneo_new");
    _jspx_th_menu_item_71.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_72(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_72 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_72.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_72.setParent(_jspx_parent);
    _jspx_th_menu_item_72.setZ("WLL42KQVEn92DV7DEKNOlevUVv4=");
    _jspx_th_menu_item_72.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/torneos?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_72.setMessageCode("global_menu_list");
    _jspx_th_menu_item_72.setId("i_torneo_list");
    _jspx_th_menu_item_72.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_19(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_19 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_19.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_19.setParent(_jspx_parent);
    _jspx_th_menu_category_19.setZ("Ck9PMzgsVRmOAYyB4+fZCSWuRu0=");
    _jspx_th_menu_category_19.setId("c_torneoequipo");
    _jspx_th_menu_category_19.setJspBody(new menu_jspxHelper( 20, _jspx_page_context, _jspx_th_menu_category_19, null));
    _jspx_th_menu_category_19.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_73(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_73 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_73.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_73.setParent(_jspx_parent);
    _jspx_th_menu_item_73.setZ("OmWKq3BCCUBIeOoe74ErYMtkb+k=");
    _jspx_th_menu_item_73.setUrl("/torneoequipoes?form");
    _jspx_th_menu_item_73.setMessageCode("global_menu_new");
    _jspx_th_menu_item_73.setId("i_torneoequipo_new");
    _jspx_th_menu_item_73.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_74(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_74 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_74.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_74.setParent(_jspx_parent);
    _jspx_th_menu_item_74.setZ("fHcjQzqG94P41r26sKU6NTe5nU4=");
    _jspx_th_menu_item_74.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/torneoequipoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_74.setMessageCode("global_menu_list");
    _jspx_th_menu_item_74.setId("i_torneoequipo_list");
    _jspx_th_menu_item_74.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_75(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_75 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_75.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_75.setParent(_jspx_parent);
    _jspx_th_menu_item_75.setZ("pZUWyixdA5dpXz4uaXf4rtXUv8Y=");
    _jspx_th_menu_item_75.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/torneoequipoes?find=ByEquipo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_75.setMessageCode("global_menu_find");
    _jspx_th_menu_item_75.setId("fi_torneoequipo_equipo");
    _jspx_th_menu_item_75.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_76(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_76 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_76.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_76.setParent(_jspx_parent);
    _jspx_th_menu_item_76.setZ("fc4FwE7rAR5mNNgtHgXPtpfqDoI=");
    _jspx_th_menu_item_76.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/torneoequipoes?find=ByTorneo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_76.setMessageCode("global_menu_find");
    _jspx_th_menu_item_76.setId("fi_torneoequipo_torneo");
    _jspx_th_menu_item_76.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_20(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_20 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_20.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_20.setParent(_jspx_parent);
    _jspx_th_menu_category_20.setZ("MW6b0dyj2ozO9yp3D621gV1cR2Q=");
    _jspx_th_menu_category_20.setId("c_equipo");
    _jspx_th_menu_category_20.setJspBody(new menu_jspxHelper( 21, _jspx_page_context, _jspx_th_menu_category_20, null));
    _jspx_th_menu_category_20.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_77(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_77 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_77.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_77.setParent(_jspx_parent);
    _jspx_th_menu_item_77.setZ("6sZphUjzCLhVSt0KKwI1gapzN/g=");
    _jspx_th_menu_item_77.setUrl("/equipoes?form");
    _jspx_th_menu_item_77.setMessageCode("global_menu_new");
    _jspx_th_menu_item_77.setId("i_equipo_new");
    _jspx_th_menu_item_77.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_78(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_78 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_78.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_78.setParent(_jspx_parent);
    _jspx_th_menu_item_78.setZ("1eDhyr/G9kztJAE1vSXgcjQoCcM=");
    _jspx_th_menu_item_78.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/equipoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_78.setMessageCode("global_menu_list");
    _jspx_th_menu_item_78.setId("i_equipo_list");
    _jspx_th_menu_item_78.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_79(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_79 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_79.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_79.setParent(_jspx_parent);
    _jspx_th_menu_item_79.setZ("G+Vq7QvW+lEStFFIBKBNtBwq/UI=");
    _jspx_th_menu_item_79.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/equipoes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_79.setMessageCode("global_menu_find");
    _jspx_th_menu_item_79.setId("fi_equipo_activo");
    _jspx_th_menu_item_79.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_80(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_80 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_80.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_80.setParent(_jspx_parent);
    _jspx_th_menu_item_80.setZ("+MEw6hXSH2zbwZA5Z8Ab3umfySY=");
    _jspx_th_menu_item_80.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/equipoes?find=ByStatusAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_80.setMessageCode("global_menu_find");
    _jspx_th_menu_item_80.setId("fi_equipo_statusandactivo");
    _jspx_th_menu_item_80.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_21(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_21 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_21.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_21.setParent(_jspx_parent);
    _jspx_th_menu_category_21.setZ("cabFd5KnP1vqZoB1ZScC0Db6IBg=");
    _jspx_th_menu_category_21.setId("c_pagohecho");
    _jspx_th_menu_category_21.setJspBody(new menu_jspxHelper( 22, _jspx_page_context, _jspx_th_menu_category_21, null));
    _jspx_th_menu_category_21.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_81(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_81 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_81.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_81.setParent(_jspx_parent);
    _jspx_th_menu_item_81.setZ("ALDhFSgE8hfcKtspeVejVoGRXcM=");
    _jspx_th_menu_item_81.setUrl("/pagohechoes?form");
    _jspx_th_menu_item_81.setMessageCode("global_menu_new");
    _jspx_th_menu_item_81.setId("i_pagohecho_new");
    _jspx_th_menu_item_81.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_82(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_82 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_82.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_82.setParent(_jspx_parent);
    _jspx_th_menu_item_82.setZ("u6AMK209Yp4CU+mxqnORjt32rWU=");
    _jspx_th_menu_item_82.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/pagohechoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_82.setMessageCode("global_menu_list");
    _jspx_th_menu_item_82.setId("i_pagohecho_list");
    _jspx_th_menu_item_82.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_22(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_22 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_22.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_22.setParent(_jspx_parent);
    _jspx_th_menu_category_22.setZ("wSvRfgoszppu9zm8BrRnNGWRCTA=");
    _jspx_th_menu_category_22.setId("c_descuento");
    _jspx_th_menu_category_22.setJspBody(new menu_jspxHelper( 23, _jspx_page_context, _jspx_th_menu_category_22, null));
    _jspx_th_menu_category_22.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_83(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_83 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_83.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_83.setParent(_jspx_parent);
    _jspx_th_menu_item_83.setZ("n6V/wCtQEeMV7soyAyjaJwv9Lbk=");
    _jspx_th_menu_item_83.setUrl("/descuentoes?form");
    _jspx_th_menu_item_83.setMessageCode("global_menu_new");
    _jspx_th_menu_item_83.setId("i_descuento_new");
    _jspx_th_menu_item_83.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_84(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_84 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_84.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_84.setParent(_jspx_parent);
    _jspx_th_menu_item_84.setZ("EPajtgwqkmZvTaGuZOsF4c/1Ywk=");
    _jspx_th_menu_item_84.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/descuentoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_84.setMessageCode("global_menu_list");
    _jspx_th_menu_item_84.setId("i_descuento_list");
    _jspx_th_menu_item_84.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_85(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_85 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_85.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_85.setParent(_jspx_parent);
    _jspx_th_menu_item_85.setZ("0pDyd4NQKaA4aR+FaeN5GF4Lz0I=");
    _jspx_th_menu_item_85.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/descuentoes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_85.setMessageCode("global_menu_find");
    _jspx_th_menu_item_85.setId("fi_descuento_activo");
    _jspx_th_menu_item_85.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_23(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_23 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_23.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_23.setParent(_jspx_parent);
    _jspx_th_menu_category_23.setZ("meDoIw2Zed5E3/mhWqzVl91oAW8=");
    _jspx_th_menu_category_23.setId("c_diasjuego");
    _jspx_th_menu_category_23.setJspBody(new menu_jspxHelper( 24, _jspx_page_context, _jspx_th_menu_category_23, null));
    _jspx_th_menu_category_23.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_86(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_86 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_86.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_86.setParent(_jspx_parent);
    _jspx_th_menu_item_86.setZ("s62ogHhbyI5oLTc4IYqkTvgft0w=");
    _jspx_th_menu_item_86.setUrl("/diasjuegoes?form");
    _jspx_th_menu_item_86.setMessageCode("global_menu_new");
    _jspx_th_menu_item_86.setId("i_diasjuego_new");
    _jspx_th_menu_item_86.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_87(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_87 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_87.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_87.setParent(_jspx_parent);
    _jspx_th_menu_item_87.setZ("fwToPMUDNDnYIy7usVKcGbIl09c=");
    _jspx_th_menu_item_87.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/diasjuegoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_87.setMessageCode("global_menu_list");
    _jspx_th_menu_item_87.setId("i_diasjuego_list");
    _jspx_th_menu_item_87.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_24(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_24 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_24.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_24.setParent(_jspx_parent);
    _jspx_th_menu_category_24.setZ("J+Hi/keRmN98PdC0DMjBolnvRho=");
    _jspx_th_menu_category_24.setId("c_tipocobro");
    _jspx_th_menu_category_24.setJspBody(new menu_jspxHelper( 25, _jspx_page_context, _jspx_th_menu_category_24, null));
    _jspx_th_menu_category_24.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_88(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_88 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_88.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_88.setParent(_jspx_parent);
    _jspx_th_menu_item_88.setZ("F/zSSNmjI02jB/Kyg0ebOYGc7rk=");
    _jspx_th_menu_item_88.setUrl("/tipocobroes?form");
    _jspx_th_menu_item_88.setMessageCode("global_menu_new");
    _jspx_th_menu_item_88.setId("i_tipocobro_new");
    _jspx_th_menu_item_88.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_89(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_89 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_89.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_89.setParent(_jspx_parent);
    _jspx_th_menu_item_89.setZ("v53mnVUuUAvvt08KLJjGY1MPeV0=");
    _jspx_th_menu_item_89.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/tipocobroes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_89.setMessageCode("global_menu_list");
    _jspx_th_menu_item_89.setId("i_tipocobro_list");
    _jspx_th_menu_item_89.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_25(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_25 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_25.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_25.setParent(_jspx_parent);
    _jspx_th_menu_category_25.setZ("/g3f1kEg8pkCvmGS+4mVi+Q+aIM=");
    _jspx_th_menu_category_25.setId("c_tipotarjeta");
    _jspx_th_menu_category_25.setJspBody(new menu_jspxHelper( 26, _jspx_page_context, _jspx_th_menu_category_25, null));
    _jspx_th_menu_category_25.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_90(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_90 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_90.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_90.setParent(_jspx_parent);
    _jspx_th_menu_item_90.setZ("NLX5x6bdI6xaL59cPxa+3gvGjbs=");
    _jspx_th_menu_item_90.setUrl("/tipotarjetas?form");
    _jspx_th_menu_item_90.setMessageCode("global_menu_new");
    _jspx_th_menu_item_90.setId("i_tipotarjeta_new");
    _jspx_th_menu_item_90.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_91(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_91 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_91.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_91.setParent(_jspx_parent);
    _jspx_th_menu_item_91.setZ("95Z6RcUPwG2MI26NqxfMabEWcfc=");
    _jspx_th_menu_item_91.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/tipotarjetas?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_91.setMessageCode("global_menu_list");
    _jspx_th_menu_item_91.setId("i_tipotarjeta_list");
    _jspx_th_menu_item_91.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_92(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_92 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_92.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_92.setParent(_jspx_parent);
    _jspx_th_menu_item_92.setZ("7SH7DQcGy184UEFj22UwphWLWYk=");
    _jspx_th_menu_item_92.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/tipotarjetas?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_92.setMessageCode("global_menu_find");
    _jspx_th_menu_item_92.setId("fi_tipotarjeta_activo");
    _jspx_th_menu_item_92.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_26(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_26 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_26.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_26.setParent(_jspx_parent);
    _jspx_th_menu_category_26.setZ("RkgM1RFJmYcsCrUrSD/Wv8nbL2A=");
    _jspx_th_menu_category_26.setId("c_cargo");
    _jspx_th_menu_category_26.setJspBody(new menu_jspxHelper( 27, _jspx_page_context, _jspx_th_menu_category_26, null));
    _jspx_th_menu_category_26.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_93(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_93 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_93.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_93.setParent(_jspx_parent);
    _jspx_th_menu_item_93.setZ("qMLzugfFynKkMvazLt0WjeDGg/0=");
    _jspx_th_menu_item_93.setUrl("/cargoes?form");
    _jspx_th_menu_item_93.setMessageCode("global_menu_new");
    _jspx_th_menu_item_93.setId("i_cargo_new");
    _jspx_th_menu_item_93.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_94(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_94 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_94.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_94.setParent(_jspx_parent);
    _jspx_th_menu_item_94.setZ("szKeASlLTApTFwfZGlrE8sQ2teI=");
    _jspx_th_menu_item_94.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_94.setMessageCode("global_menu_list");
    _jspx_th_menu_item_94.setId("i_cargo_list");
    _jspx_th_menu_item_94.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_95(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_95 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_95.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_95.setParent(_jspx_parent);
    _jspx_th_menu_item_95.setZ("zIPVRtMR4KhwmZUV7osp8EdUy+s=");
    _jspx_th_menu_item_95.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndFechaCreacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_95.setMessageCode("global_menu_find");
    _jspx_th_menu_item_95.setId("fi_cargo_conceptocobroandfechacreacionbetween");
    _jspx_th_menu_item_95.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_96(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_96 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_96.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_96.setParent(_jspx_parent);
    _jspx_th_menu_item_96.setZ("mELb/AKJ76TY2+KWSakIamuCsZA=");
    _jspx_th_menu_item_96.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_96.setMessageCode("global_menu_find");
    _jspx_th_menu_item_96.setId("fi_cargo_conceptocobroandstatus");
    _jspx_th_menu_item_96.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_97(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_97 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_97.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_97.setParent(_jspx_parent);
    _jspx_th_menu_item_97.setZ("k1l4dmGzZa3WzoA8ijapBJdBRpg=");
    _jspx_th_menu_item_97.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndTorneo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_97.setMessageCode("global_menu_find");
    _jspx_th_menu_item_97.setId("fi_cargo_conceptocobroandtorneo");
    _jspx_th_menu_item_97.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_98(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_98 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_98.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_98.setParent(_jspx_parent);
    _jspx_th_menu_item_98.setZ("Vcys6/Ir2DQUCBeeZRPTFg7gKyA=");
    _jspx_th_menu_item_98.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndTorneoAndEquipo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_98.setMessageCode("global_menu_find");
    _jspx_th_menu_item_98.setId("fi_cargo_conceptocobroandtorneoandequipo");
    _jspx_th_menu_item_98.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_99(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_99 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_99.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_99.setParent(_jspx_parent);
    _jspx_th_menu_item_99.setZ("8ARYXx7PMjjNULnT04b9dYWSXYA=");
    _jspx_th_menu_item_99.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_99.setMessageCode("global_menu_find");
    _jspx_th_menu_item_99.setId("fi_cargo_conceptocobroandtorneoandequipoandfechamodificacionbetween");
    _jspx_th_menu_item_99.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_100(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_100 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_100.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_100.setParent(_jspx_parent);
    _jspx_th_menu_item_100.setZ("DZFwYHBdEhBebPHmSgU6a4XCcC8=");
    _jspx_th_menu_item_100.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cargoes?find=ByConceptoCobroAndTorneoAndFechaModificacionBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_100.setMessageCode("global_menu_find");
    _jspx_th_menu_item_100.setId("fi_cargo_conceptocobroandtorneoandfechamodificacionbetween");
    _jspx_th_menu_item_100.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_27(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_27 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_27.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_27.setParent(_jspx_parent);
    _jspx_th_menu_category_27.setZ("/lP1jvdnWQxpyeByg9cpBVLSslQ=");
    _jspx_th_menu_category_27.setId("c_partido");
    _jspx_th_menu_category_27.setJspBody(new menu_jspxHelper( 28, _jspx_page_context, _jspx_th_menu_category_27, null));
    _jspx_th_menu_category_27.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_101(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_101 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_101.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_101.setParent(_jspx_parent);
    _jspx_th_menu_item_101.setZ("Xg9y5lhYECVB4HPix+20GfIUoUY=");
    _jspx_th_menu_item_101.setUrl("/partidoes?form");
    _jspx_th_menu_item_101.setMessageCode("global_menu_new");
    _jspx_th_menu_item_101.setId("i_partido_new");
    _jspx_th_menu_item_101.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_102(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_102 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_102.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_102.setParent(_jspx_parent);
    _jspx_th_menu_item_102.setZ("jmxAmlR7UYl6HV3YV85Z91DgVV8=");
    _jspx_th_menu_item_102.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_102.setMessageCode("global_menu_list");
    _jspx_th_menu_item_102.setId("i_partido_list");
    _jspx_th_menu_item_102.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_103(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_103 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_103.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_103.setParent(_jspx_parent);
    _jspx_th_menu_item_103.setZ("YimpUvRQuZllL0FohFhX3eT2JsM=");
    _jspx_th_menu_item_103.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByCancha&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_103.setMessageCode("global_menu_find");
    _jspx_th_menu_item_103.setId("fi_partido_cancha");
    _jspx_th_menu_item_103.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_104(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_104 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_104.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_104.setParent(_jspx_parent);
    _jspx_th_menu_item_104.setZ("EQV9VAUEB539ehQkvyR6vfw4tAE=");
    _jspx_th_menu_item_104.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByCanchaAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_104.setMessageCode("global_menu_find");
    _jspx_th_menu_item_104.setId("fi_partido_canchaandstatus");
    _jspx_th_menu_item_104.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_105(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_105 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_105.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_105.setParent(_jspx_parent);
    _jspx_th_menu_item_105.setZ("LRrKRmi6stBN5tkrPJPnq7Xn59E=");
    _jspx_th_menu_item_105.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByCanchaAndStatusAndFechaJuegoBetween&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_105.setMessageCode("global_menu_find");
    _jspx_th_menu_item_105.setId("fi_partido_canchaandstatusandfechajuegobetween");
    _jspx_th_menu_item_105.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_106(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_106 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_106.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_106.setParent(_jspx_parent);
    _jspx_th_menu_item_106.setZ("GzLbMf2VwPa0FWrcl59DQQkckI8=");
    _jspx_th_menu_item_106.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByCanchaAndStatusAndFechaJuegoEquals&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_106.setMessageCode("global_menu_find");
    _jspx_th_menu_item_106.setId("fi_partido_canchaandstatusandfechajuegoequals");
    _jspx_th_menu_item_106.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_107(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_107 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_107.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_107.setParent(_jspx_parent);
    _jspx_th_menu_item_107.setZ("xJ7A//G3b4Yc4JFIYZIG7a85vRE=");
    _jspx_th_menu_item_107.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByFechaJuegoBetweenAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_107.setMessageCode("global_menu_find");
    _jspx_th_menu_item_107.setId("fi_partido_fechajuegobetweenandstatus");
    _jspx_th_menu_item_107.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_108(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_108 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_108.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_108.setParent(_jspx_parent);
    _jspx_th_menu_item_108.setZ("VhOKQsoOyq92EiYrfzQkdc3cYOE=");
    _jspx_th_menu_item_108.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByFechaJuegoEqualsAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_108.setMessageCode("global_menu_find");
    _jspx_th_menu_item_108.setId("fi_partido_fechajuegoequalsandstatus");
    _jspx_th_menu_item_108.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_109(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_109 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_109.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_109.setParent(_jspx_parent);
    _jspx_th_menu_item_109.setZ("L2vvjEseAVaFDD1Z6YawY9ogy1g=");
    _jspx_th_menu_item_109.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_109.setMessageCode("global_menu_find");
    _jspx_th_menu_item_109.setId("fi_partido_torneoequipolocalandtorneoequipovisitanteandequipolocalandequipovisitante");
    _jspx_th_menu_item_109.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_110(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_110 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_110.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_110.setParent(_jspx_parent);
    _jspx_th_menu_item_110.setZ("z7z2eJUA6fpqQ/BaLU989HRN+5s=");
    _jspx_th_menu_item_110.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_110.setMessageCode("global_menu_find");
    _jspx_th_menu_item_110.setId("fi_partido_torneoequipolocalandtorneoequipovisitanteandequipolocalandequipovisitanteandstatus");
    _jspx_th_menu_item_110.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_111(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_111 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_111.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_111.setParent(_jspx_parent);
    _jspx_th_menu_item_111.setZ("MT29Ect6OT1JC1I8hN0oz//BcQw=");
    _jspx_th_menu_item_111.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalOrTorneoEquipoVisitante&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_111.setMessageCode("global_menu_find");
    _jspx_th_menu_item_111.setId("fi_partido_torneoequipolocalortorneoequipovisitante");
    _jspx_th_menu_item_111.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_112(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_112 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_112.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_112.setParent(_jspx_parent);
    _jspx_th_menu_item_112.setZ("vN0PCKySg8+jpHC8R9BZtBXrVtA=");
    _jspx_th_menu_item_112.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_112.setMessageCode("global_menu_find");
    _jspx_th_menu_item_112.setId("fi_partido_torneoequipolocalortorneoequipovisitanteandequipolocalorequipovisitante");
    _jspx_th_menu_item_112.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_113(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_113 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_113.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_113.setParent(_jspx_parent);
    _jspx_th_menu_item_113.setZ("Udw0HLVhzPZh6vLJcnITv14BjdQ=");
    _jspx_th_menu_item_113.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_113.setMessageCode("global_menu_find");
    _jspx_th_menu_item_113.setId("fi_partido_torneoequipolocalortorneoequipovisitanteandequipolocalorequipovisitanteandstatus");
    _jspx_th_menu_item_113.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_114(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_114 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_114.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_114.setParent(_jspx_parent);
    _jspx_th_menu_item_114.setZ("9/dXY2TI9HW9KBzYrZwpplLy7yM=");
    _jspx_th_menu_item_114.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/partidoes?find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_114.setMessageCode("global_menu_find");
    _jspx_th_menu_item_114.setId("fi_partido_torneoequipolocalortorneoequipovisitanteandstatus");
    _jspx_th_menu_item_114.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_28(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_28 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_28.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_28.setParent(_jspx_parent);
    _jspx_th_menu_category_28.setZ("WyJ0DN0p4cfPsGF7WGHEFk6Ok1k=");
    _jspx_th_menu_category_28.setId("c_rol");
    _jspx_th_menu_category_28.setJspBody(new menu_jspxHelper( 29, _jspx_page_context, _jspx_th_menu_category_28, null));
    _jspx_th_menu_category_28.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_115(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_115 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_115.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_115.setParent(_jspx_parent);
    _jspx_th_menu_item_115.setZ("pci13zJkyKMJXhGhbCY9f9yBMb4=");
    _jspx_th_menu_item_115.setUrl("/rols?form");
    _jspx_th_menu_item_115.setMessageCode("global_menu_new");
    _jspx_th_menu_item_115.setId("i_rol_new");
    _jspx_th_menu_item_115.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_116(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_116 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_116.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_116.setParent(_jspx_parent);
    _jspx_th_menu_item_116.setZ("GQHH+mdvcxfHlFAlkR2gFwHsv1s=");
    _jspx_th_menu_item_116.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/rols?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_116.setMessageCode("global_menu_list");
    _jspx_th_menu_item_116.setId("i_rol_list");
    _jspx_th_menu_item_116.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_117(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_117 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_117.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_117.setParent(_jspx_parent);
    _jspx_th_menu_item_117.setZ("ZWCN5VNp+7t7wmkTgYhRueAYB64=");
    _jspx_th_menu_item_117.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/rols?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_117.setMessageCode("global_menu_find");
    _jspx_th_menu_item_117.setId("fi_rol_activo");
    _jspx_th_menu_item_117.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_29(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_29 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_29.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_29.setParent(_jspx_parent);
    _jspx_th_menu_category_29.setZ("1LAxKp/dW+GW2FOYRyLjVPkk60Q=");
    _jspx_th_menu_category_29.setId("c_cedulapartido");
    _jspx_th_menu_category_29.setJspBody(new menu_jspxHelper( 30, _jspx_page_context, _jspx_th_menu_category_29, null));
    _jspx_th_menu_category_29.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_118(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_118 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_118.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_118.setParent(_jspx_parent);
    _jspx_th_menu_item_118.setZ("sgQgShRh/8jB1dfSlrLDz47zZI0=");
    _jspx_th_menu_item_118.setUrl("/cedulapartidoes?form");
    _jspx_th_menu_item_118.setMessageCode("global_menu_new");
    _jspx_th_menu_item_118.setId("i_cedulapartido_new");
    _jspx_th_menu_item_118.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_119(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_119 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_119.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_119.setParent(_jspx_parent);
    _jspx_th_menu_item_119.setZ("iLi9Cxg5oeePALgHCy/OlEjxEcs=");
    _jspx_th_menu_item_119.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cedulapartidoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_119.setMessageCode("global_menu_list");
    _jspx_th_menu_item_119.setId("i_cedulapartido_list");
    _jspx_th_menu_item_119.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_120(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_120 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_120.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_120.setParent(_jspx_parent);
    _jspx_th_menu_item_120.setZ("Vh+Z+nzVUaabWT4YyogxuQRd2No=");
    _jspx_th_menu_item_120.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cedulapartidoes?find=ByPartido&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_120.setMessageCode("global_menu_find");
    _jspx_th_menu_item_120.setId("fi_cedulapartido_partido");
    _jspx_th_menu_item_120.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_121(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_121 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_121.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_121.setParent(_jspx_parent);
    _jspx_th_menu_item_121.setZ("svjtmklAFS7yVYuiJVubWhaIQPg=");
    _jspx_th_menu_item_121.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/cedulapartidoes?find=ByPartidoAndStatus&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_121.setMessageCode("global_menu_find");
    _jspx_th_menu_item_121.setId("fi_cedulapartido_partidoandstatus");
    _jspx_th_menu_item_121.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_30(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_30 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_30.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_30.setParent(_jspx_parent);
    _jspx_th_menu_category_30.setZ("32bRFO8Dcpe8AX8UAmXm/Mp57RU=");
    _jspx_th_menu_category_30.setId("c_cancha");
    _jspx_th_menu_category_30.setJspBody(new menu_jspxHelper( 31, _jspx_page_context, _jspx_th_menu_category_30, null));
    _jspx_th_menu_category_30.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_122(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_122 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_122.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_122.setParent(_jspx_parent);
    _jspx_th_menu_item_122.setZ("oZaGCxORixLAqVkvP6ia+JKfhII=");
    _jspx_th_menu_item_122.setUrl("/canchas?form");
    _jspx_th_menu_item_122.setMessageCode("global_menu_new");
    _jspx_th_menu_item_122.setId("i_cancha_new");
    _jspx_th_menu_item_122.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_123(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_123 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_123.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_123.setParent(_jspx_parent);
    _jspx_th_menu_item_123.setZ("sR+DW1bFaT1g9CZhNpcjhFV7GdM=");
    _jspx_th_menu_item_123.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/canchas?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_123.setMessageCode("global_menu_list");
    _jspx_th_menu_item_123.setId("i_cancha_list");
    _jspx_th_menu_item_123.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_124(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_124 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_124.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_124.setParent(_jspx_parent);
    _jspx_th_menu_item_124.setZ("lYVABXGHru8xf4OPx5NNn5WybM0=");
    _jspx_th_menu_item_124.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/canchas?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_124.setMessageCode("global_menu_find");
    _jspx_th_menu_item_124.setId("fi_cancha_activo");
    _jspx_th_menu_item_124.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_125(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_125 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_125.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_125.setParent(_jspx_parent);
    _jspx_th_menu_item_125.setZ("vvtWdcnp09yfqx9EGj7hC26Bc0c=");
    _jspx_th_menu_item_125.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/canchas?find=BySucursalAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_125.setMessageCode("global_menu_find");
    _jspx_th_menu_item_125.setId("fi_cancha_sucursalandactivo");
    _jspx_th_menu_item_125.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_31(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_31 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_31.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_31.setParent(_jspx_parent);
    _jspx_th_menu_category_31.setZ("nR0eIQOdjxi6yv6JRhPls82vdxQ=");
    _jspx_th_menu_category_31.setId("c_statuspartido");
    _jspx_th_menu_category_31.setJspBody(new menu_jspxHelper( 32, _jspx_page_context, _jspx_th_menu_category_31, null));
    _jspx_th_menu_category_31.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_126(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_126 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_126.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_126.setParent(_jspx_parent);
    _jspx_th_menu_item_126.setZ("egXTI47i6BAWCMnGRq9sMzvhjHo=");
    _jspx_th_menu_item_126.setUrl("/statuspartidoes?form");
    _jspx_th_menu_item_126.setMessageCode("global_menu_new");
    _jspx_th_menu_item_126.setId("i_statuspartido_new");
    _jspx_th_menu_item_126.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_127(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_127 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_127.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_127.setParent(_jspx_parent);
    _jspx_th_menu_item_127.setZ("KS9SjxX3ofaQ+Ia5y36Cj4yGBI8=");
    _jspx_th_menu_item_127.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuspartidoes?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_127.setMessageCode("global_menu_list");
    _jspx_th_menu_item_127.setId("i_statuspartido_list");
    _jspx_th_menu_item_127.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_128(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_128 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_128.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_128.setParent(_jspx_parent);
    _jspx_th_menu_item_128.setZ("XzBbcVYgqx4+y1iRRboemg4+N6M=");
    _jspx_th_menu_item_128.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/statuspartidoes?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_128.setMessageCode("global_menu_find");
    _jspx_th_menu_item_128.setId("fi_statuspartido_activo");
    _jspx_th_menu_item_128.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_category_32(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:category
    org.apache.jsp.tag.web.menu.category_tagx _jspx_th_menu_category_32 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.category_tagx.class) : new org.apache.jsp.tag.web.menu.category_tagx();
    _jspx_th_menu_category_32.setJspContext(_jspx_page_context);
    _jspx_th_menu_category_32.setParent(_jspx_parent);
    _jspx_th_menu_category_32.setZ("Xy2UIEQBwGL74OghlgyDNqDXG44=");
    _jspx_th_menu_category_32.setId("c_empresa");
    _jspx_th_menu_category_32.setJspBody(new menu_jspxHelper( 33, _jspx_page_context, _jspx_th_menu_category_32, null));
    _jspx_th_menu_category_32.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_129(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_129 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_129.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_129.setParent(_jspx_parent);
    _jspx_th_menu_item_129.setZ("TBXez8QM+aB2tzcjHN1lQJYrewc=");
    _jspx_th_menu_item_129.setUrl("/empresas?form");
    _jspx_th_menu_item_129.setMessageCode("global_menu_new");
    _jspx_th_menu_item_129.setId("i_empresa_new");
    _jspx_th_menu_item_129.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_130(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_130 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_130.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_130.setParent(_jspx_parent);
    _jspx_th_menu_item_130.setZ("/YQYlSdehDz3lrOGSSpWZYe++Zk=");
    _jspx_th_menu_item_130.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/empresas?page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_130.setMessageCode("global_menu_list");
    _jspx_th_menu_item_130.setId("i_empresa_list");
    _jspx_th_menu_item_130.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_131(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_131 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_131.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_131.setParent(_jspx_parent);
    _jspx_th_menu_item_131.setZ("7P68c0LcqBnWqYfhp9slqzrFAvo=");
    _jspx_th_menu_item_131.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/empresas?find=ByActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_131.setMessageCode("global_menu_find");
    _jspx_th_menu_item_131.setId("fi_empresa_activo");
    _jspx_th_menu_item_131.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_132(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_132 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_132.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_132.setParent(_jspx_parent);
    _jspx_th_menu_item_132.setZ("mDZ3VLC292rE3KvzgChf8yQwIhY=");
    _jspx_th_menu_item_132.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/empresas?find=ByNombreComercialLikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_132.setMessageCode("global_menu_find");
    _jspx_th_menu_item_132.setId("fi_empresa_nombrecomerciallikeandactivo");
    _jspx_th_menu_item_132.doTag();
    return false;
  }

  private boolean _jspx_meth_menu_item_133(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:item
    org.apache.jsp.tag.web.menu.item_tagx _jspx_th_menu_item_133 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.menu.item_tagx.class) : new org.apache.jsp.tag.web.menu.item_tagx();
    _jspx_th_menu_item_133.setJspContext(_jspx_page_context);
    _jspx_th_menu_item_133.setParent(_jspx_parent);
    _jspx_th_menu_item_133.setZ("sPDbRjad7+HdDltQUuNr2jA5hR0=");
    _jspx_th_menu_item_133.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/empresas?find=ByNombreLikeAndActivo&form&page=1&size=${empty param.size ? 10 : param.size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_menu_item_133.setMessageCode("global_menu_find");
    _jspx_th_menu_item_133.setId("fi_empresa_nombrelikeandactivo");
    _jspx_th_menu_item_133.doTag();
    return false;
  }

  private class menu_jspxHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public menu_jspxHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_category_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_1((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_2((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_3((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_4((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_5((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_6((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_7((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_8((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_9((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_10((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_11((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_12((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_13((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_14((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_15((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_16((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_17((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_18((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_19((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_20((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_21((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_22((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_23((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_24((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_25((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_26((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_27((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_28((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_29((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_30((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_31((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_category_32((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_1((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_2((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_3((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_4((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_5((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_6((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_7((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_8((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_9((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke3( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_10((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_11((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_12((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_13((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke4( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_14((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_15((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_16((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_17((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_18((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_19((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_20((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke5( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_21((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_22((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke6( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_23((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_24((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_25((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke7( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_26((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_27((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_28((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_29((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_30((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke8( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_31((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_32((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_33((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_34((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke9( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_35((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_36((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_37((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke10( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_38((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_39((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_40((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke11( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_41((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_42((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_43((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_44((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_45((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_46((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke12( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_47((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_48((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_49((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke13( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_50((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_51((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_52((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke14( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_53((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_54((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_55((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke15( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_56((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_57((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_58((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke16( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_59((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_60((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_61((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke17( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_62((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_63((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_64((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_65((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_66((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_67((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke18( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_68((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_69((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_70((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke19( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_71((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_72((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke20( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_73((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_74((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_75((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_76((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke21( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_77((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_78((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_79((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_80((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke22( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_81((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_82((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke23( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_83((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_84((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_85((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke24( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_86((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_87((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke25( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_88((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_89((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke26( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_90((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_91((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_92((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke27( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_93((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_94((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_95((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_96((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_97((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_98((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_99((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_100((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke28( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_101((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_102((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_103((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_104((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_105((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_106((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_107((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_108((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_109((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_110((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_111((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_112((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_113((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_114((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke29( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_115((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_116((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_117((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke30( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_118((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_119((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_120((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_121((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke31( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_122((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_123((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_124((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_125((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke32( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_126((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_127((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_128((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke33( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_menu_item_129((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_130((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_131((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_132((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      if (_jspx_meth_menu_item_133((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
          case 3:
            invoke3( out );
            break;
          case 4:
            invoke4( out );
            break;
          case 5:
            invoke5( out );
            break;
          case 6:
            invoke6( out );
            break;
          case 7:
            invoke7( out );
            break;
          case 8:
            invoke8( out );
            break;
          case 9:
            invoke9( out );
            break;
          case 10:
            invoke10( out );
            break;
          case 11:
            invoke11( out );
            break;
          case 12:
            invoke12( out );
            break;
          case 13:
            invoke13( out );
            break;
          case 14:
            invoke14( out );
            break;
          case 15:
            invoke15( out );
            break;
          case 16:
            invoke16( out );
            break;
          case 17:
            invoke17( out );
            break;
          case 18:
            invoke18( out );
            break;
          case 19:
            invoke19( out );
            break;
          case 20:
            invoke20( out );
            break;
          case 21:
            invoke21( out );
            break;
          case 22:
            invoke22( out );
            break;
          case 23:
            invoke23( out );
            break;
          case 24:
            invoke24( out );
            break;
          case 25:
            invoke25( out );
            break;
          case 26:
            invoke26( out );
            break;
          case 27:
            invoke27( out );
            break;
          case 28:
            invoke28( out );
            break;
          case 29:
            invoke29( out );
            break;
          case 30:
            invoke30( out );
            break;
          case 31:
            invoke31( out );
            break;
          case 32:
            invoke32( out );
            break;
          case 33:
            invoke33( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}

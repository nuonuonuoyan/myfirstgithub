/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-14 06:55:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class faceCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t\t<title>车牌识别停车场管理系统</title>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/IncludeJS.jsp", out, false);
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write(" \t<body >\r\n");
      out.write("\t\t<div class=\"face_header\">\r\n");
      out.write("\t\t\t<div class=\"face_header_con\"><p class=\"face_header_lf\">车牌识别停车场管理系统</p><a class=\"face_header_rg\" href=\"javascript:void(0);\"><span class=\"headsp\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/icon-user.png\" ></span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"face_con\">\r\n");
      out.write("\t\t\t<div class=\"face_content\">\r\n");
      out.write("\t\t\t\t<div class=\"face_con_left\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"face_con_tit\">请开始车牌识别验证<p>请调整好摄像头，确保摄像头能够拍摄到车牌的位置，开始车牌识别验证</p></h1>\r\n");
      out.write("\t\t\t\t\t<div class=\"face_yanzhen\">\r\n");
      out.write("\t\t\t\t\t\t<span>\r\n");
      out.write("\t        \t\t\t<img id=\"userImg\" src=\"\"  width=\"280\" height=\"230\"/>\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;&nbsp;&nbsp;<input id=\"file1\" name=\"file1\" accept=\"image/*\" type=\"file\" value=\"上传头像\"/></p>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t<video id=\"video\" style='width:100%;height:100%'></video>\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"canvas\" width=\"320\" height=\"240\" style=\"display: none;\"></canvas>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"face_yanzhen_btn\" id=\"paizhao\">开始车牌识别</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<p class=\"yanzhen_con\">说明：请调整好摄像头，确保摄像头能够清晰拍摄到车牌号</p>\r\n");
      out.write("\t\t\t\t\t<a class=\"face_login_btn\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/carInfo\" >进入平台</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"face_con_right\"><h1 class=\"face_con_tit face_right_tit\" >常见问题:</h1>\r\n");
      out.write("\t\t\t\t\t<p style=\"margin-top:0px;\">1、不支持IE浏览器，建议使用火狐、谷歌、Edge浏览器进行考试</p>\r\n");
      out.write("\t\t\t\t\t<p>2、若浏览器顶部出现是否允许调用摄像头，请点击允许</p>\r\n");
      out.write("\t\t\t\t\t<p><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/cm.png\" style=\"width:100%\"></p>\r\n");
      out.write("\t\t\t\t\t<p>3、提示获取摄像头失败，请检查你的摄像头是否正确</p>\r\n");
      out.write("\t\t\t\t\t<p>4、<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/fire/Firefox.exe\">>>>>点击下载火狐游览器</a></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t video=document.getElementById(\"video\");\r\n");
      out.write("             var context = canvas.getContext(\"2d\");\r\n");
      out.write("\r\n");
      out.write("             //允许浏览器访问摄像头\r\n");
      out.write("             if(navigator.mediaDevices.getUserMedia){\r\n");
      out.write("                 var constraints={ audio: false, video: true };\r\n");
      out.write("                 navigator.mediaDevices.getUserMedia(constraints)\r\n");
      out.write("                     .then(function(stream) {\r\n");
      out.write("                         /* 使用这个stream stream */\r\n");
      out.write("                         video.srcObject=stream;\r\n");
      out.write("                         video.onloadedmetadata=function (ev) {\r\n");
      out.write("                             video.play();\r\n");
      out.write("                         }\r\n");
      out.write("                     });\r\n");
      out.write("\r\n");
      out.write("             }\r\n");
      out.write("\r\n");
      out.write("             paizhao.addEventListener(\"click\",function () {\r\n");
      out.write("\t\t\t\t $(\"#paizhao\").html(\"正在识别车牌\");\r\n");
      out.write("\t\t\t\t context.drawImage(video,0,0,320,240);\r\n");
      out.write("                 var data = canvas.toDataURL();//获取图片的b64码\r\n");
      out.write("                 var b64 = data.substring(22);//截掉前面对数据类型的描述\r\n");
      out.write("                 console.info(data);\r\n");
      out.write("                 console.info(b64);\r\n");
      out.write("                 //如何把图片写到左边的<img>标签中？？？\r\n");
      out.write("                 var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/paizhao\"\r\n");
      out.write("                 $.ajax({\r\n");
      out.write("\t\t\t\t\t url:url,\r\n");
      out.write("\t\t\t\t\t data:{\"imgdata\":b64,\"extName\":\".png\"},\r\n");
      out.write("\t\t\t\t\t type:\"post\",\r\n");
      out.write("\t\t\t\t\t dataType:\"json\",\r\n");
      out.write("\t\t\t\t\t success:function (data) {\r\n");
      out.write("\t\t\t\t\t\t alert(data);\r\n");
      out.write("                     }\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t )\r\n");
      out.write("             })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write(" ");
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
}
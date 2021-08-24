<%@ page import="manager.model.Manager" %><%--
  Created by IntelliJ IDEA.
  User: Rooter
  Date: 2021/8/23
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>医药管理首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
</head>
<body>
<%
    Object managerSession = (Manager)session.getAttribute("manager");
    if(managerSession==null){
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
%>
<div id="top">
    <div id="topleft"></div>
</div>
<div id="middle">
    <span>${sessionScope.manager.fullname}:欢迎登陆医药管理系统</span><span style="position: absolute; right: 10px;"><a href="index.html"></a>
       <a href="${pageContext.request.contextPath}/logout.manager">退出系统</a> </span>
</div>
<div id="body">
    <div id="bodyleft">
        <iframe src="${pageContext.request.contextPath}/menu.jsp"></iframe>
    </div>
    <div id="bodyright">
        <iframe src="${pageContext.request.contextPath}/selectByPage.category?pageNo=1" name="show"></iframe>
    </div>
</div>
<div id="footer">版权所有：南京市艾瑞职业培训学校 ICP备案：苏ICP备15022503号-1</div>
</body>
</html>

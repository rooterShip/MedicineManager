<%--
  Created by IntelliJ IDEA.
  User: Rooter
  Date: 2021/8/23
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>医药管理列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/menu.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="divmenu">
    <dl>
        <dt onclick="menu(this.parentNode)">类别管理</dt>
        <dd>
            <a href="${pageContext.request.contextPath}/toadd.category" target="show">添加类别</a>
        </dd>
        <dd>
            <a href="${pageContext.request.contextPath}/selectByPage.category?pageNo=1" target="show">查看类别</a>
        </dd>
    </dl>
</div>
<div class="divmenu">
    <dl>
        <dt onclick="menu(this.parentNode)">药品管理</dt>
        <dd>
            <a href="./Drug/Drug_toAdd.html" target="show">添加药品</a>
        </dd>
        <dd>
            <a href="./Drug/Drug_selectBypage.html" target="show">查看药品</a>
        </dd>
    </dl>
</div>
<div class="divmenu">
    <dl>
        <dt onclick="menu(this.parentNode)">购买药品</dt>
        <dd>
            <a href="./Buy/Buy_drug.html" target="show">选购药品</a>
        </dd>
    </dl>
</div>
<div class="divmenu">
    <dl>
        <dt onclick="menu(this.parentNode)">销售管理</dt>
        <dd>
            <a href="./Sale/Sale_selectByPage.html" target="show">查看明细</a>
        </dd>
    </dl>
</div>
<div class="divmenu">
    <dl>
        <dt onclick="menu(this.parentNode)">系统管理</dt>
        <dd>
            <a href="./Manager/Manager_toAdd.html" target="show">添加用户</a>
        </dd>
        <dd>
            <a href="./Manager/Manager_selectBypage.html" target="show">查看用户</a>
        </dd>
        <dd>
            <a href="./Manager/Manager_toUpdatePassword.html" target="show">修改密码</a>
        </dd>
    </dl>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Rooter
  Date: 2021/8/25
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>编辑药品类别</title>
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/query.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Category.js"></script>
<script type="text/javascript">
    $(function () {
        $("#description").val("${requestScope.category.description}");
    })
</script>
</head>
<body>
<div id="top">当前位置：类别管理——编辑类别</div>
<form action="${pageContext.request.contextPath}/addorupdate.category" method="post">
    <table id="tab">
        <tr>
            <td align="right" style="width: 40%;">类别ID:</td>
            <td align="left"><input type="text" id="id" name="id" readonly="readonly" placeholder="无需填写自动生成" value="${requestScope.category.id}"/></td>
        </tr>

        <tr>
            <td align="right" style="width: 40%;">类别名称:</td>
            <td align="left"><input type="text" id="cname" name="cname" value="${requestScope.category.cname}"/><span
                    style="color: red;">*</span><span id="message0" style="color: red;"></span>
            </td>
        </tr>
        <tr>
            <td align="right">类别描述:</td>
            <td align="left"><textarea id="description" name="description"></textarea><span
                    style="color: red;">*</span><span id="message1" style="color: red;"></span>
            </td>
        </tr>
        <tr>
            <td  colspan="2"><input style="width: 60px;"type="submit" id="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>

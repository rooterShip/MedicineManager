<%@ page import="category.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="util.PageModel" %><%--
  Created by IntelliJ IDEA.
  User: Rooter
  Date: 2021/8/24
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>药品类别管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/query.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function () {
            var pageNo=${requestScope.pageModel.pageNo};
            var pageCount=${requestScope.pageModel.pageCount};
            if (pageNo==1){
                $("#previouspage").prop("href","#");
            }
            if (pageNo==pageCount){
                $("#nextpage ").prop("href","#");
            }
        })
    </script>
</head>
<body>
<%
    PageModel pageModel = (PageModel)request.getAttribute("pageModel");
    List<Category> categories = (List<Category>)pageModel.getRecordList();
%>
<div id="top">当前位置： 类别管理--查看类别</div>
<div id="contexttop">
    <table id="tab" border="1">
        <tr>
            <td colspan="6" height="50">
                <form action="${pageContext.request.contextPath}/selectByPage.category?pageNo=1" method="post">
                    <input type="hidden" name="pageNo" value="1"/>
                    <input type="text" title="类别ID,类别名称,描述" name="likeValue" value="<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>"/><input type="submit" value="查询" />
                </form>
            </td>
        </tr>
        <tr bgcolor="#E0FBC4">
            <th>类别ID</th>
            <th>类别名称</th>
            <th>创建时间</th>
            <th>描述</th>
            <th colspan="2">操作</th>
        </tr>
        <%
            for(Category c:categories){
        %>
        <tr>
            <td><%=c.getId()%></td>
            <td><%=c.getCname()%></td>
            <td><%=c.getCreatetime()%></td>
            <td><%=c.getDescription()%></td>
            <td><a href="">编辑</a></td>
            <td><a href="">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<div align="center" id="contextbotton">
    &nbsp;总记录数&nbsp;<%=pageModel.getRecordCount()%>&nbsp;条&nbsp;共&nbsp;<%=pageModel.getPageCount()%>&nbsp;页
    &nbsp;<a href="${pageContext.request.contextPath}/selectByPage.category?pageNo=1&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>">首页</a>
    &nbsp;<a id="previouspage" href="${pageContext.request.contextPath}/selectByPage.category?pageNo=<%=pageModel.getPageNo()-1%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>">上一页</a>
    &nbsp;<a id="nextpage" href="${pageContext.request.contextPath}/selectByPage.category?pageNo=<%=pageModel.getPageNo()+1%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>">下一页</a>
    &nbsp;<a href="${pageContext.request.contextPath}/selectByPage.category?pageNo=<%=pageModel.getPageCount()%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>">尾页</a>
    &nbsp;第&nbsp;<%=pageModel.getPageNo()%>&nbsp;页&nbsp;
</div>
</body>
</html>

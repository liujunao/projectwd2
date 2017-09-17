<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/8
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4><%=session.getAttribute("success")%></h4>
    <br><br>
    <a href="/pages/minor/addArticle.jsp">添加文章</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:" onclick="history.go(-2)">返回</a>
</body>
</html>

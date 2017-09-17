<%@ page import="com.service.Wd_infoService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/11
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Wd_infoService wd_infoService = new Wd_infoService();
    List<Map<String,Object>> list = wd_infoService.queryData();
    Map<String,Object>map = null;
    //int pageNumber = Integer.parseInt(String.valueOf(request.getAttribute("pageNumber") != null ? request.getAttribute("pageNumber") : "0").trim());
    int pageNumber = -1;
%>
    <%=pageNumber%>

</body>
</html>

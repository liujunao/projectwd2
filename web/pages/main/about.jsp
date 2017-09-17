<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.models.Wd_info" %>
<%@ page import="com.service.Wd_infoService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/13
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>${about3 }</title>
</head>
<body>
<%@include file="/pages/commons/common_1.jsp"%>
    <script language="JavaScript">
        function killErrors() {
            return true;
        }
        window.onerror = killErrors;
    </script>
    <div class="banner">
        <c:if test="${channelId == 2}">
            <a href="aboutServlet?channelId=2&sortId=1"><img src="/img/20140704023107.jpg" width="980" height="220"></a>
        </c:if>
        <c:if test="${channelId == 5}">
            <a href="aboutServlet?channelId=5&sortId=1"><img src="/img/20140529092719.jpg" width="980" height="220"></a>
        </c:if>
    </div>
    <div class="ny_main">
        <div class="ny_main_left">
            <h1><span>${about2 }</span>${about3 }</h1>
            <ul>
                <c:if test="${channelId == 2}">
                    <li><a href="aboutServlet?channelId=2&sortId=1">公司简介</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=2">组织架构</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=3">管理体系</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=4">公司资质</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=5">企业文化</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=6">《上城物业》内刊</a></li>
                    <li><a href="aboutServlet?channelId=2&sortId=7">公司荣誉</a></li>
                </c:if>
                <c:if test="${channelId == 5}">
                    <li><a href="/aboutServlet?channelId=5&sortId=1">上步大厦</a></li>
                    <li><a href="/aboutServlet?channelId=5&sortId=2">鹏丽大厦</a></li>
                    <li><a href="/aboutServlet?channelId=5&sortId=3">御景华城</a></li>
                </c:if>
            </ul>
            <div class="ge"></div>
        </div>
        <div class="ny_main_right">
            <div class="ny_main_head_top"></div>
            <%
                int channelId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("channelId") != null ? request.getSession().getAttribute("channelId") : "2"));
                int sortId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("sortId") != null ?  request.getSession().getAttribute("sortId") : "2 "));

                Wd_info wd_info = new Wd_info();
                Wd_infoService wd_infoService = new Wd_infoService();
                wd_info.setChannelId(channelId);
                wd_info.setSortId(sortId);
                List<Map<String,Object>> list = wd_infoService.queryData(wd_info);
                Map<String,Object>map = list.get(0);
            %>
            <div class="ny_main_head">
                <%=map.get("Wt_title")%><em>${about1 }</em>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/ViewArticleServlet?id=<%=map.get("Wt_infoId")%>&name=revise">修改</a>
            </div>
            <div class="ny_cenner">
                <div class="pd_nc_zw">
                <p><%=map.get("Wt_content")%></p>
                </div>
            </div>
        </div>
        <div class="ge"></div>
    </div>
</div>
<%@ include file="/pages/commons/common_2.jsp"%>
</body>
</html>

<%@ page import="com.service.Wd_infoService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="javax.jws.Oneway" %>
<%@ page import="com.models.Wd_info" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/7
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <title>${common1}</title>
</head>
<body>
<%@ include file="/pages/commons/common_1.jsp"%>
    <script language="JavaScript">
        function killErrors() {
            return true;
        }
        window.onerror = killErrors;
    </script>
    <div class="banner">
        <c:if test="${channelId == 3}">
            <a href="http://www.sz-scwy.com/news.php"><img src="/img/20140529092235.jpg" width="980" height="220"></a>
        </c:if>
        <c:if test="${channelId == 4}">
            <a href="http://www.sz-scwy.com/law.php"><img src="/img/20140529092346.jpg" width="980" height="220"></a>
        </c:if>
    </div>
    <div class="ny_main">
        <div class="ny_main_left">
            <h1><span>${common3 }</span>${common2 }</h1>
            <ul>
                <c:if test="${channelId == 3}">
                    <li><a href="/newsServlet?channelId=3&sortId=1">行业新闻</a></li>
                    <li><a href="/newsServlet?channelId=3&sortId=2">公司动态</a></li>
                    <li><a href="/newsServlet?channelId=3&sortId=3">业主公告</a></li>
                </c:if>
                <c:if test="${channelId == 4}">
                    <li><a href="/newsServlet?channelId=4&sortId=1">法律法规</a></li>
                </c:if>
            </ul>
            <div class="ge"></div>
        </div>

        <div class="ny_main_right">
            <div class="ny_main_head_top"></div>
            <div class="ny_main_head">${common5 } <em> ${common4 }</em>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/pages/minor/addArticle.jsp">添加文章</a>
            </div>
            <div class="ny_cenner">
                <div class="main_right_con">
                    <ul class="inner_news">
                        <%
                            Wd_infoService wd_infoService = new Wd_infoService();
                            Wd_info wd_info = new Wd_info();
                            int channelId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("channelId") != null ? request.getSession().getAttribute("channelId") : 1));
                            int sortId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("sortId") != null ? request.getSession().getAttribute("sortId") : 1));
                            wd_info.setChannelId(channelId);
                            wd_info.setSortId(sortId);
                            List<Map<String,Object>>list = wd_infoService.queryData(wd_info);
                            Map<String,Object>map = null;
                            int pageNumber = Integer.parseInt(String.valueOf(request.getAttribute("pageNumber") != null ? request.getAttribute("pageNumber") : "1"));
                            int totalPage = Integer.parseInt(String.valueOf(request.getAttribute("totalPage") != null ? request.getAttribute("totalPage") : "1"));
                            int pageSize = Integer.parseInt(String.valueOf(request.getAttribute("pageSize") != null ? request.getAttribute("pageSize") : "2"));
                            int startIndex = (pageNumber - 1) * pageSize;
                            int lastIndex = pageNumber * pageSize == totalPage ? totalPage - 1 : pageNumber * pageSize - 1;
                            if (list.size() > 0 && list != null){
                                for (int i = startIndex;i < list.size() && i <= lastIndex;i++){
                                    map = list.get(i);
                        %>
                        <li>
                            <a href="/ViewArticleServlet?id=<%=map.get("Wt_infoId")%>&name=view"><%=map.get("Wt_infoId")%>-<%=map.get("Wt_title")%></a>
                            <input type="button" value="删除" onclick="deleteArticle()"/></a>
                            <a href="/ViewArticleServlet?id=<%=map.get("Wt_infoId")%>&name=revise"><input type="button"value="修改"/></a>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                    <div class="pages">
                        <div class="page">
                            <span><%=pageNumber%> / ${totalPage } &nbsp;&nbsp;&nbsp;&nbsp; 第 <%=pageNumber%> 页 </span>
                            <a href="/pageServlet?pageNumber=1">首页</a>
                            <c:if test="${pageNumber > 1 }">
                                <a href="/pageServlet?pageNumber=${pageNumber - 1 }">上一页</a>
                            </c:if>
                            <c:if test="${pageNumber < totalPage }">
                                <a href="/pageServlet?pageNumber=${pageNumber + 1}">下一页</a>
                            </c:if>
                            <a href="/pageServlet?pageNumber=${totalPage }">末页</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="ge"></div>
    </div>
</div>
<script>
    function deleteArticle() {
        var flag = window.confirm("确认删除吗？");
        if (flag){
            window.location.href = "/ViewArticleServlet?id=<%=map.get("Wt_infoId")%>&name=delete";
        }
    }
</script>
<%@ include file="/pages/commons/common_2.jsp"%>
</body></html>

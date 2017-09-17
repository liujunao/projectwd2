<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/8
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>广东省安全生产监督管理局关于印发《广东省安全生产监督管理局关于〈生产安全事故应急预案管理办法〉的实施细则》的通知粤安监应急〔2017〕9号</title>
    <meta name="Keywords" content="">
    <meta name="Description" content="">

    <link type="text/css" rel="stylesheet" href="/css/style.css">
    <script src="/js/nav.js" language="JavaScript" type="text/javascript"></script>
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
        <a href="http://www.sz-scwy.com/news.php"><img src="/img/20140529092235.jpg" width="980" height="220"></a>
    </div>
    <div class="ny_main">
        <div class="ny_main_left">
            <h1><span>News</span>新闻中心</h1>
            <ul>
                <li><a href="http://www.sz-scwy.com/news.php?id=4">行业新闻</a></li>
                <li><a href="http://www.sz-scwy.com/news.php?id=5">公司动态</a></li>
                <li><a href="http://www.sz-scwy.com/news.php?id=7">业主公告</a></li>
            </ul>
            <div class="ge"></div>
        </div>
        <div class="ny_main_right">
            <div class="ny_main_head_top"></div>
            <div class="ny_main_head">新闻详情</div>
            <div class="ny_cenner">
                <div class="main_right_con">
                    <h1 class="inner_news_tit"><%=session.getAttribute("title")%></h1>
                    <h2 class="inner_news_time"><span><a href="${pageContext.request.contextPath}/pages/main/news_industry.jsp">返回新闻列表</a></span>发表日期：<%=session.getAttribute("date")%></h2>
                    <div class="pd_nc_zw">&nbsp;
                        <p class="MsoNormal"><%=session.getAttribute("content")%></p>
                        <br><br>
                        <p class="MsoNormal"><%=session.getAttribute("author")%></p>
                    </div>
                    <div class="SBack"><strong><a href="javascript:history.back(-1)" class="ttt"> 返回 </a></strong></div>
            </div>
        </div>
        </div>
        <div class="ge"></div>
    </div>
</div>
<%@ include file="/pages/commons/common_2.jsp"%>
</body></html>